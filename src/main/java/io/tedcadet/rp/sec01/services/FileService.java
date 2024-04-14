package io.tedcadet.rp.sec01.services;

import reactor.core.publisher.Mono;

import java.io.IOException;

public interface FileService {
    Mono<String> readFile(String fileName) throws IOException;

    Mono<Void> writeFile(String fileName, String content);

    Mono<Void> deleteFile(String fileName);
}
