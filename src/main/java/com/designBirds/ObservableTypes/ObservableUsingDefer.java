package com.designbirds.ObservableTypes;

import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

public class ObservableUsingDefer {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.defer(() -> {
            return Observable.fromIterable(RxUtils.positiveNumbers(8));
        });

        observable.subscribe(new DemoObserver());
    }
}
