package io.tedcadet.rp.sec02.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.random.RandomGenerator;

public class MycStockPricePublisher implements StockPricePublisher {
    private final AtomicReference<Double> price;

    public MycStockPricePublisher() {
        this.price = new AtomicReference<>(100.0);
    }

    @Override
    public Flux<Double> publish() {
        return Flux
                .interval(Duration.ofMillis(500L))
                .map(i -> updatePrice());
    }

    private Double updatePrice() {
        return price.getAndAccumulate(
                RandomGenerator
                        .getDefault()
                        .nextDouble(-5, 5),
                Double::sum
        );
    }
}
