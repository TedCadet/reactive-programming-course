package io.tedcadet.rp.sec01.services;

import reactor.core.publisher.Mono;

public interface FileService {
    Mono<String> readFile(String fileName);

    Mono<String> writeFile(String fileName, String content);

    Mono<String> deleteFile(String fileName);
}
