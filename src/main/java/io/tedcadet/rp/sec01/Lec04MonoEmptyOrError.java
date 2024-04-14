package io.tedcadet.rp.sec01;

import io.tedcadet.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {
    private static Mono<String> userRepository(int userId) {
        return switch (userId) {
            case 1 -> Mono.just(Util.getFaker().name().firstName());
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("User not found"));
        };
    }

    public static void main(String[] args) {
        userRepository(1)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
