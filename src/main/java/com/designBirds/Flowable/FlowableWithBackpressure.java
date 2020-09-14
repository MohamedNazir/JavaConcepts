package com.designbirds.Flowable;

import com.designbirds.RxUtils;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class FlowableWithBackpressure {

    public static void main(String[] args) throws InterruptedException {

        Flowable<Integer> flowable = Flowable.fromIterable(RxUtils.positiveNumbers(1000000)).repeat()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext(integer -> System.out.println("emiting Integer -> {}"+  integer));

        flowable.subscribe(new Subscriber<Integer>() {

            private Subscription subscription;
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("On Subscription");
                this.subscription = s;
                subscription.request(10);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("On Next -> {} " + integer);
                try {
                    RxUtils.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("On Error");
            }

            @Override
            public void onComplete() {
                System.out.println("On Complete");
            }
        });

        RxUtils.sleep(10000);

    }
}
