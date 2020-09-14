package com.designbirds.operators;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import com.designbirds.Shape;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GroupByOperator {

    public static void main(String[] args) throws InterruptedException {
        Observable.fromIterable(RxUtils.shapes(20)).groupBy(new Function<Shape, Object>() {
            @Override
            public Object apply(Shape shape) throws Throwable {
                return shape.getColor();
            }
        }).observeOn(Schedulers.newThread()).subscribe(new Observer<GroupedObservable<Object, Shape>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull GroupedObservable<Object, Shape> objectShapeGroupedObservable) {
                System.out.println("On Next"+ objectShapeGroupedObservable.getKey() );
                objectShapeGroupedObservable.subscribe(new DemoObserver());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        RxUtils.sleep(1000);
    }

}
