package com.designbirds.combiningoperators;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeOperator {

        public static void main(String[] args) throws InterruptedException {

            Observable o1 = Observable.fromIterable(RxUtils.positiveNumbers(10));
            Observable o2 = Observable.fromIterable(RxUtils.shapes(10));

           Observable.merge(o1,o2).subscribe(new DemoObserver());
            RxUtils.sleep(10000);
        }
}
