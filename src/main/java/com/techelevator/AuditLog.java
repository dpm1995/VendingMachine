package com.techelevator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AuditLog {
    //Which writes out the full string to the log.txt file.0
    // Instance Variables
    private String fileName = "log.txt";
    private File logFile = new File(fileName);
    public AuditLog() {
        createNewFile();
    }
    // creates the new file log.txt
    private void createNewFile() {
        try {
            logFile.createNewFile();
        } catch (IOException e) {
        }
    }
    // will provide the current time in the log
    private String getCurrentTime() {
        String date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
        return date;
    }
    public String logEvent(String event, String balanceBeforeTransaction, String afterTransaction) {
        String logString = String.format("%-24s %-22s %-14s %-14s", getCurrentTime(),
                event, balanceBeforeTransaction, afterTransaction);
        // the append true allows us to write to same file w/o deleting deleting content
        try (Writer fileWriter = new FileWriter(logFile, true);
             BufferedWriter buffered = new BufferedWriter(fileWriter)) {
            buffered.write(logString + "\n"); // new line
        } catch (IOException e1) {
        }
        return logString;
    }
}
