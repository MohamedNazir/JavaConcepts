package com.designbirds.ObservableTypes;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class DemoObserver implements Observer {
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        System.out.println("onSubscribe");
    }

    @Override
    public void onNext(Object o) {
        System.out.println(Thread.currentThread().getName() +" : onNext -> {} " + o);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        System.out.println("onError " + e.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
