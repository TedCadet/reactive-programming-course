package io.tedcadet.rp.sec01.services;

import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class FileServiceImpl implements FileService {
    @Override
    public Mono<String> readFile(String fileName) {
        return Mono.fromCallable(fileReaderCallable(fileName));
    }

    @Override
    public Mono<Void> writeFile(String fileName, String content) {
        return Mono.fromRunnable(fileWriterCallable(fileName, content));
    }

    @Override
    public Mono<Void> deleteFile(String fileName) {
        return null;
    }

    private Callable<String> fileReaderCallable(String fileName) {
        return () -> {
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                StringBuilder stringBuilder = new StringBuilder();

                bufferedReader
                        .lines()
                        .forEach(stringBuilder::append);

                return stringBuilder.toString();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private Runnable fileWriterCallable(String fileName, String content) {
        return () -> {
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private Runnable deleteFileRunnable(String fileName) {
        return () -> {
            try {
                Files.delete(Paths.get(fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
