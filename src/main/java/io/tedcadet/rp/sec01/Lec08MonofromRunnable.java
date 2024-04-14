package io.tedcadet.rp.sec01;

import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonofromRunnable {
    public static void main(String[] args) {

        Mono.fromRunnable(timeConsummingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Runnable timeConsummingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Opeartion completed");
        };
    }
}
