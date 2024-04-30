package io.tedcadet.rp.sec03;

import io.tedcadet.rp.courseutil.DefaultSubscriber;
import io.tedcadet.rp.sec03.assignement.FileService;
import io.tedcadet.rp.sec03.assignement.FileServiceImpl;

public class Assignment {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        String path = "src/main/resources/assignment/sec03/toRead.txt";
        fileService
                .readFile(path)
                .take(4)
                .subscribe(new DefaultSubscriber("Assignment-sec-03"));
    }
}
