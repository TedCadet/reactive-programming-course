package io.tedcadet.rp.sec01.services;

import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class FileServiceImpl implements FileService {

    private static final String BASE_FILE_NAME = "src/main/resources/assignment/sec01";

    @Override
    public Mono<String> readFile(String fileName) {
        return Mono.fromCallable(fileReaderCallable(BASE_FILE_NAME.concat(fileName)));
    }

    @Override
    public Mono<String> writeFile(String fileName, String content) {
        return Mono.fromCallable(fileWriterCallable(BASE_FILE_NAME.concat(fileName), content));
    }

    @Override
    public Mono<String> deleteFile(String fileName) {
        return Mono.fromCallable(deleteFileRunnable(BASE_FILE_NAME.concat(fileName)));
    }

    private Callable<String> fileReaderCallable(String fileName) {
        return () -> {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();

            bufferedReader
                    .lines()
                    .forEach(line -> stringBuilder.append(line).append("\n"));

            return stringBuilder.toString();
        };
    }

    private Callable<String> fileWriterCallable(String fileName, String content) {
        return () -> {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            return "file writing success";
        };
    }

    private Callable<String> deleteFileRunnable(String fileName) {
        return () -> {
            Files.delete(Paths.get(fileName));
            return "delete success";
        };
    }
}
