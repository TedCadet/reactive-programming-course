package io.tedcadet.rp.sec01;

import io.tedcadet.rp.courseutil.BasicOnHandlerPrinter;
import io.tedcadet.rp.sec01.services.FileService;
import io.tedcadet.rp.sec01.services.FileServiceImpl;

public class Assignement {
    public static void main(String[] args) {
        String fileNameRead = "toRead.txt";
        String fileNameWrite = "toWrite.txt";
        String fileNameDelete = "toDelete.txt";

        FileService fileService = new FileServiceImpl();

        fileService.readFile(fileNameRead)
                .subscribe(
                        BasicOnHandlerPrinter.onNext(),
                        BasicOnHandlerPrinter.onError(),
                        BasicOnHandlerPrinter.onComplete()
                );

        fileService.writeFile(fileNameWrite, "new content")
                .subscribe(
                        BasicOnHandlerPrinter.onNext(),
                        BasicOnHandlerPrinter.onError(),
                        BasicOnHandlerPrinter.onComplete()
                );

        fileService.deleteFile(fileNameDelete)
                .subscribe(
                        BasicOnHandlerPrinter.onNext(),
                        BasicOnHandlerPrinter.onError(),
                        BasicOnHandlerPrinter.onComplete()
                );
    }
}
