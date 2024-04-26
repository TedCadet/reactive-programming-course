package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.DefaultSubscriber;
import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer)
                .subscribe(new DefaultSubscriber("Lec02FluxCreateRefactoring"));

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            Thread.ofVirtual()
                    .name(String.format("Lec02FluxCreateRefactoring-%d", i))
                    .start(runnable);
        }

        Util.sleepSeconds(5);
    }
}
