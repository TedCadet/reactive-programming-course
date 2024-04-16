package io.tedcadet.rp.sec02;

import io.tedcadet.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
    public static void main(String[] args) {

        AtomicReference<Subscription> subscriptionRef = new AtomicReference<>();

        Flux.range(1, 20)
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received subscription: " + subscription);
                        subscriptionRef.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Received: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error: " + throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });
        Util.sleepSeconds(3);
        subscriptionRef.get().request(3);
        Util.sleepSeconds(3);
        subscriptionRef.get().request(3);
        Util.sleepSeconds(3);
        subscriptionRef.get().request(3);
        System.out.println("Canceling subscription");
        subscriptionRef.get().cancel();
        Util.sleepSeconds(3);
        subscriptionRef.get().request(3);
    }
}
