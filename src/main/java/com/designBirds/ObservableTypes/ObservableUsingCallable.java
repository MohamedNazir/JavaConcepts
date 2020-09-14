package com.designbirds.ObservableTypes;

import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.Callable;

public class ObservableUsingCallable {

    public static void main(String[] args) {

        Observable.fromCallable(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return doSomething();
            }
        }).subscribe(new DemoObserver());


    }

    private static String doSomething() throws InterruptedException {
        RxUtils.sleep(5000);
        return "Hello";
    }
}
