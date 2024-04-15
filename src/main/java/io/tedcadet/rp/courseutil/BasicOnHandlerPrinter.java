package io.tedcadet.rp.courseutil;

import java.util.function.Consumer;

public class BasicOnHandlerPrinter {

    private BasicOnHandlerPrinter() {
    }

    public static Consumer<Object> onNext() {
        return o -> System.out.printf("Received: %s%n", o);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.printf("Error: %s%n", e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.printf("Done%n");
    }
}
