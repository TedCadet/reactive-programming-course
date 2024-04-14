package io.tedcadet.rp.sec01;

import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // use just only when you have data already
//        Mono<String> mono = Mono.just(getName());
        Mono<String> mono = Mono.fromSupplier(Util::getName);
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Callable<String> stringCallable = Util::getName;
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
