package com.designbirds.Flowable;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObservableWithoutBackPressure {

    // Run this program with a low memory, so that you can see out of memory error.
    public static void main(String[] args) throws InterruptedException {

        Observable<Integer> positiveNumbersStream = Observable.fromIterable(RxUtils.positiveNumbers(100000))
                .repeat()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread());

        positiveNumbersStream.subscribe(new DemoObserver());
        RxUtils.sleep(100000);
    }
}
