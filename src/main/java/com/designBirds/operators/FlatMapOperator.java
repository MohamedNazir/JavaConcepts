package com.designbirds.operators;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;

public class FlatMapOperator {

    public static void main(String[] args) {

        Observable.fromIterable(RxUtils.positiveNumbers(10))
                .flatMap( integer -> { return twice(integer);})
                .subscribe(new DemoObserver());
    }

    private static ObservableSource<Integer> twice(Integer integer) {
        return Observable.create( onserverEmitter -> {
            if(!onserverEmitter.isDisposed()){
                onserverEmitter.onNext(integer*2);
            }else{
                onserverEmitter.onComplete();
            }

        });
    }
}
