package com.designbirds.operators;

import com.designbirds.ObservableTypes.DemoObserver;
import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Observable;

public class BufferOperators {

    public static void main(String[] args) {

        Observable.just(1,2,3,4,5,6,7,8,9).buffer(3).subscribe(new DemoObserver());

        Observable.fromIterable(RxUtils.shapes(15)).buffer(3).subscribe(new DemoObserver());
    }
}
