package com.designbirds.operators;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

public class ScanOperator {

    public static void main(String[] args) {

        Observable.fromIterable(RxUtils.positiveNumbers(10))
                .scan(  (a,b) ->  a+b )
                .subscribe(new DemoObserver());
    }
}
