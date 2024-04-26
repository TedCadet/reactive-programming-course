package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.DefaultSubscriber;
import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(
                        () -> 1,
                        (counter, sink) -> {
                            String country = Util.getFaker().country().name();
                            System.out.println("emitting " + country);
                            sink.next(country);
                            if (counter >= 10 || country.equalsIgnoreCase("canada")) {
                                sink.complete();
                            }
                            return counter + 1;
                        }
                )
                .subscribe(new DefaultSubscriber("Lec07FluxGenerateCounter"));
    }
}
