package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .take(3)
                .subscribe(new DefaultSubscriber("Lec03FluxTake"));
    }
}
