package com.designbirds.operators;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

public class MapOperator {

    public static void main(String[] args) {

        Observable.fromIterable(RxUtils.positiveNumbers(10)).map(e -> e *2).subscribe(new DemoObserver());
    }
}
