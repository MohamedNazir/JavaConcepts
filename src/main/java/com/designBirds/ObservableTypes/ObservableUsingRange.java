package com.designbirds.ObservableTypes;

import io.reactivex.rxjava3.core.Observable;

public class ObservableUsingRange {

    public static void main(String[] args) {

        Observable.range(1, 15).subscribe(new DemoObserver());
    }
}
