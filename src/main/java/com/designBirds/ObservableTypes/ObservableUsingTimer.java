package com.designbirds.ObservableTypes;

import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableUsingTimer {

    public static void main(String[] args) throws InterruptedException {

        Observable.timer(1, TimeUnit.SECONDS).subscribe(new DemoObserver());
        RxUtils.sleep(5000);
    }
}
