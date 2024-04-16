package io.tedcadet.rp.sec02.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StockPriceSubscriber implements Subscriber<Double> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Double price) {
        System.out.printf("Price: %.2f%n", price);
        if (price < 90 || price > 110) {
            subscription.cancel();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error: " + throwable.getCause());
        subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }
}
