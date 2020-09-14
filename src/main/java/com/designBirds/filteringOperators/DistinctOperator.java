package com.designbirds.filteringOperators;

import com.designbirds.ObservableTypes.DemoObserver;
import io.reactivex.rxjava3.core.Observable;

public class DistinctOperator {
    public static void main(String[] args) {

        Observable.just(1,2,3,1,2,4,6,8,8,5).distinct().subscribe(new DemoObserver());
    }
}
