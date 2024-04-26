package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.DefaultSubscriber;
import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        // push is not Thread-Safe
        Flux.push(nameProducer)
                .subscribe(new DefaultSubscriber("Lec02FluxCreateRefactoring"));

        for (int i = 0; i < 10; i++) {
            Thread.ofVirtual()
                    .name(String.format("Lec02FluxCreateRefactoring-%d", i))
                    .start(nameProducer::produce);
        }

        Util.sleepSeconds(7);
    }
}
