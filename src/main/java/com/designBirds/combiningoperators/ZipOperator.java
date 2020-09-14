package com.designbirds.combiningoperators;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import com.designbirds.Shape;
import io.reactivex.rxjava3.core.Observable;

public class ZipOperator {

    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> o1 = Observable.fromIterable(RxUtils.positiveNumbers(10));
        Observable<Shape> o2 = Observable.fromIterable(RxUtils.shapes(10));

        o2.zipWith(o1, (a,b)-> a.toString() + " --" + b.toString()).subscribe(new DemoObserver());
        RxUtils.sleep(10000);
    }
}
