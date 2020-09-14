package com.designbirds.filteringOperators;

import com.designbirds.ObservableTypes.DemoObserver;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class ElementAtOperator {
    public static void main(String[] args) {

        Observable.just(1,2,3,1,2,4,6,8,8,5).elementAt(5).subscribe(new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Integer integer) {
                System.out.println("is Found  " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("on complete");
            }
        });
    }
}

