package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.DefaultSubscriber;
import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String country = Util.getFaker().country().name();
                    System.out.println("emitting " + country);
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(new DefaultSubscriber("Lec06FluxGenerateAssignment"));
    }
}
