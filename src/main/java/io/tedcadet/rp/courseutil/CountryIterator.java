package io.tedcadet.rp.courseutil;

import com.github.javafaker.Faker;

import java.util.Iterator;

public class CountryIterator implements Iterator<String> {
    private static final Faker FAKER = Faker.instance();

    @Override
    public boolean hasNext() {
        return false;
    }

    // TODO: methods should throw "NoSuchElementException"
    @Override
    public String next() {
        return FAKER.country().name();
    }
}
