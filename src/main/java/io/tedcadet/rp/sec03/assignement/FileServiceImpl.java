package io.tedcadet.rp.sec03.assignement;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;

public class FileServiceImpl implements FileService {
    @Override
    public Flux<String> readFile(String path) {
        return Flux.generate(readerState(path), readFileSink(path))
                .onErrorStop();
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> readFileSink(String path) {
        return (bufferedReader, synchronousSink) -> {
            try {
                Optional.ofNullable(bufferedReader.readLine())
                        .ifPresentOrElse(synchronousSink::next,
                                () -> {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e) {
                                        System.out.printf("Error while close the bufferedReader:%s%n", e.getCause());
                                    }
                                    synchronousSink.complete();
                                });
            } catch (IOException e) {
                System.out.printf("Error while reading the file: %s%n%s%n", path, e.getCause());
            }

            return bufferedReader;
        };
    }

    private Callable<BufferedReader> readerState(String path) {
        return () -> new BufferedReader(new FileReader(path));
    }
}
