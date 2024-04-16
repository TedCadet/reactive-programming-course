package io.tedcadet.rp.sec02;

import io.tedcadet.rp.courseutil.BasicOnHandlerPrinter;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromIterable {
    public static void main(String[] args) {
        List<String> strings = List.of("a", "b", "c");

        Flux.fromIterable(strings)
                .subscribe(BasicOnHandlerPrinter.onNext());
    }
}
