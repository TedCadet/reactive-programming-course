package io.tedcadet.rp.sec02;

import io.tedcadet.rp.courseutil.BasicOnHandlerPrinter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello");

        Flux<String> flux = Flux.from(mono);

        flux.subscribe(BasicOnHandlerPrinter.onNext());

        Flux.range(1, 10)
                .next()
                .subscribe(BasicOnHandlerPrinter.onNext());
    }
}
