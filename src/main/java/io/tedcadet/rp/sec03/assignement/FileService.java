package io.tedcadet.rp.sec03.assignement;

import reactor.core.publisher.Flux;

public interface FileService {
    Flux<String> readFile(String path);
}
