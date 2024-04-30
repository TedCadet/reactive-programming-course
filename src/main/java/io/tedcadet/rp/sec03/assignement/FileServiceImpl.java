package io.tedcadet.rp.sec03.assignement;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileServiceImpl implements FileService {
    @Override
    public Flux<String> readFile(String path) {
        return Flux.generate(readerState(path),
                        readFileSink(),
                        closeFileSink())
                .onErrorStop();
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> readFileSink() {
        return (bufferedReader, synchronousSink) -> {
            try {
                Optional.ofNullable(bufferedReader.readLine())
                        .ifPresentOrElse(synchronousSink::next,
                                synchronousSink::complete);
            } catch (IOException e) {
                synchronousSink.error(e);
            }

            return bufferedReader;
        };
    }

    private Callable<BufferedReader> readerState(String path) {
        return () -> new BufferedReader(new FileReader(path));
    }

    private Consumer<BufferedReader> closeFileSink() {
        return bufferedReader -> {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.printf("error while closing the bufferedReader: %s%n", e.getCause());
            }
        };
    }
}
