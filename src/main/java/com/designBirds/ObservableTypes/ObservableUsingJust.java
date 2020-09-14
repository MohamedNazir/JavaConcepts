package com.designbirds.ObservableTypes;

import io.reactivex.rxjava3.core.Observable;

public class ObservableUsingJust {

    public static void main(String[] args) {

        // Just can hold only max of 10 elements, you can't add more than that.
        Observable.just("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .subscribe(new DemoObserver());
    }
}
