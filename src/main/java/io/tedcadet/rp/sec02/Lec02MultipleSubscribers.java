package io.tedcadet.rp.sec02;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);

        integerFlux.subscribe(i -> System.out.println("Subscriber 1: " + i));
        integerFlux.subscribe(i -> System.out.println("Subscriber 2: " + i * 2));
        integerFlux
                .filter(integer -> integer % 2 == 0)
                .subscribe(i -> System.out.println("Subscriber 3: " + i));
    }
}
