package io.tedcadet.rp.sec02.assignment;

import reactor.core.publisher.Flux;

public interface StockPricePublisher {
    Flux<Double> publish();
}
