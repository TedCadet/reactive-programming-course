package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.CountryIterator;
import io.tedcadet.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    CountryIterator countryIterator = new CountryIterator();
                    String country;
                    do {
                        country = countryIterator.next();
                        System.out.printf("emmiting: %s%n", country);
                        fluxSink.next(country);
                    }
                    while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(new DefaultSubscriber("Lec04FluxCreateIssueFix"));
    }
}
