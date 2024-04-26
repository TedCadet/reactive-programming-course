package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.NameGenerator;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> fluxSink) {
        this.fluxSink = fluxSink;
    }

    public void produce() {
        String name = NameGenerator.getName();
        String threadName = Thread.currentThread().getName();
        fluxSink.next(String.format("[Thread: %s] %s", threadName, name));
    }
}
