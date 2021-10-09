package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PossibleAuditLog {
    // Instance Variables
    private String fileName = "log.txt";
    private File logFile = new File(fileName);
    public PossibleAuditLog() {
        createNewFile();
    }

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
    // the format for this was found via google so I hope it works. Anytime we call this we will need to pass these strings
    public String logEvent(String event, String balanceBeforeTransaction, String afterTransaction) {
        String logString = String.format("%-24s %-22s %-14s %-14s", getCurrentTime(), event, balanceBeforeTransaction,
                afterTransaction);
        //                                                  the append true allows us to write to same file w/o deleting deleting content
        try (Writer fileWriter = new FileWriter(logFile, true);
             BufferedWriter buffered = new BufferedWriter(fileWriter)) {
            buffered.write(logString + "\n"); // new line
        } catch (IOException e1) {
        }
        return logString;


    }

}
