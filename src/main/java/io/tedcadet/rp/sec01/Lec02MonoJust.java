package io.tedcadet.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);
        mono.subscribe(i -> System.out.printf("Received: %s%n", i));
    }
}
