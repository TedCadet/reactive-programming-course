package io.tedcadet.rp.sec02;

import io.tedcadet.rp.courseutil.BasicOnHandlerPrinter;
import io.tedcadet.rp.courseutil.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);

        NameGenerator.getFluxNames(5)
                .subscribe(BasicOnHandlerPrinter.onNext());
    }
}
