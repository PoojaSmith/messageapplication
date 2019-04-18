package com.osc;

import com.osc.core.SalesRecorder;
import com.osc.message.Message;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Enter atleast two command line arguments. Please refer to README.md file.");
            System.exit(1);
        }

        if(isInvalidFilePath(args[0]) || isInvalidFilePath(args[1])) {
            System.out.println("Given file path(s) is (/are) either incorrect or inaccessible. Please confirm and re-run.");
            System.exit(1);
        }

        String stockDataFile = args[0];
        String notificationsFile = args[1];

        SalesRecorder salesRecorder = SalesRecorder.getSalesEngine();

        boolean initialized = salesRecorder.initialize(stockDataFile);
        if(!initialized) {
            System.out.println("Sales initialization failed. Please check console.");
            System.exit(1);
        }

        List<Message> messages = salesRecorder.parse(notificationsFile);
        if(messages == null) {
            System.out.println("Sales message parsing failed");
            System.exit(1);
        }

        boolean processed = salesRecorder.process(messages);
        if(!processed) {
            System.out.println("Sales notifications' processing failed.");
            System.exit(1);
        }
    }

    private static boolean isInvalidFilePath(String filePath) {
        try {
            Path path = Paths.get(filePath);

            if(!Files.exists(path) || Files.notExists(path)) { //either does not exist or status is unknown
                return true;
            }

            if(!Files.isRegularFile(path)) { //an executable or directory
                return true;
            }

            if(!Files.isReadable(path)) { //not allowed to read (at least at this moment)
                return true;
            }
        } catch (InvalidPathException | NullPointerException exception) {
            return true; //raised an exception
        }

        return false;
    }
}
