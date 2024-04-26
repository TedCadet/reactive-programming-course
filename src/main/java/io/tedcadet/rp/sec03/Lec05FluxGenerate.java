package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    // can only emit one item
                    synchronousSink.next(System.currentTimeMillis());
                    synchronousSink.complete();
                })
                .subscribe(new DefaultSubscriber("Lec05FluxGenerate"));
    }
}
