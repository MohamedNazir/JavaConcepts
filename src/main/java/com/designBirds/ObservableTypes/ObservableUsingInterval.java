package com.designbirds.ObservableTypes;

import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableUsingInterval {

    public static void main(String[] args) throws InterruptedException {

        // emits sequence of integer at regular interval.

        Observable.interval(1, TimeUnit.SECONDS ).subscribe(new DemoObserver());
        RxUtils.sleep(3000);
    }
}
