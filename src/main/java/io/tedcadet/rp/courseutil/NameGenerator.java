package io.tedcadet.rp.courseutil;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private NameGenerator() {
    }

    private static final Faker FAKER = Faker.instance();

    public static Faker getFaker() {
        return FAKER;
    }

    public static String getName() {
        System.out.println("Generating name...");
        Util.sleepSeconds(1);
        return getFaker().name().fullName();
    }

    public static List<String> getNames(int count) {
        List<String> names = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            names.add(getName());
        }

        return names;
    }

    public static Flux<String> getFluxNames(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }
}
