package com.designbirds.ObservableTypes;

import com.designbirds.RxUtils;
import com.designbirds.Shape;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

import java.util.List;

public class ObservableUsingCreate {


    public static void main(String[] args) {
        List<Shape> shapeList = RxUtils.shapes(10);
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                try {
                    shapeList.forEach(emitter::onNext);
                }catch (Exception e){
                    emitter.onError(e);
                }
                emitter.onComplete();
            }
        }).subscribe(new DemoObserver());

    }
}
