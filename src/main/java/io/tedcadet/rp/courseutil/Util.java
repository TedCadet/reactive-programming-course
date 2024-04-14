package io.tedcadet.rp.courseutil;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Faker getFaker() {
        return FAKER;
    }

    public static String getName() {
        System.out.println("Generating name...");
        return getFaker().name().fullName();
    }

    public static Mono<String> getMonoName() {
        System.out.println("Entering getName method");
        return Mono.fromSupplier(() -> {
                    System.out.println("Generating name...");
                    sleepSeconds(3);
                    return getFaker().name().fullName();
                })
                .map(String::toUpperCase);
    }

    public static Consumer<Object> onNext() {
        return o -> System.out.printf("Received: %s%n", o);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.printf("Error: %s%n", e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.printf("Done");
    }

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
