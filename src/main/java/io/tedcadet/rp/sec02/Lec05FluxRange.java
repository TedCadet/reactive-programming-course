package io.tedcadet.rp.sec02;

import io.tedcadet.rp.courseutil.BasicOnHandlerPrinter;
import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(1, 10)
//                .log()
                .map(i -> Util.getName())
                .subscribe(BasicOnHandlerPrinter.onNext());
    }
}
