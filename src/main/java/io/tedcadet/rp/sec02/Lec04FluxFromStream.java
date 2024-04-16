package io.tedcadet.rp.sec02;

import io.tedcadet.rp.courseutil.BasicOnHandlerPrinter;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream();

        // if you use directly a stream, the stream wiil close once used and cause and error
//        Flux<Integer> flux = Flux.fromStream(() -> stream);
        Flux<Integer> flux = Flux.fromStream(list::stream);

        flux.subscribe(BasicOnHandlerPrinter.onNext());
        flux.subscribe(BasicOnHandlerPrinter.onNext());
    }
}
