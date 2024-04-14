package io.tedcadet.rp.sec01;

import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        // publisher
        Mono<String> mono = Mono.just("ball")
                .map(String::toUpperCase);

        Mono<Integer> monoError = Mono.just("ball")
                .map(String::length).
                map(l -> l / 0);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        monoError.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
