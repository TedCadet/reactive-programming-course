package io.tedcadet.rp.sec01;

import io.tedcadet.rp.courseutil.Util;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        Util.getMonoName();
        Util.getMonoName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        String name = Util.getMonoName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
        Util.getMonoName();

        Util.sleepSeconds(4);
    }
}
