package com.designbirds.combiningoperators;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class CombineLatestOperators {
    public static void main(String[] args) throws InterruptedException {

        Observable o1 = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Observable o2 = Observable.interval(2000, TimeUnit.MILLISECONDS);

        Observable.combineLatest(o1,o2,(a,b) -> {
            return "First "+ a.toString() + "   Second " + b.toString() ;
        }).take(6).subscribe(new DemoObserver());


        RxUtils.sleep(10000);
    }
}
