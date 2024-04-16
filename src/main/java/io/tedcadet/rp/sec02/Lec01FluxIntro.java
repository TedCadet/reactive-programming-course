package io.tedcadet.rp.sec02;

import io.tedcadet.rp.courseutil.BasicOnHandlerPrinter;
import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1, 2, 3, Util.getName());

        flux.subscribe(
                BasicOnHandlerPrinter.onNext(),
                BasicOnHandlerPrinter.onError(),
                BasicOnHandlerPrinter.onComplete()
        );
    }
}
