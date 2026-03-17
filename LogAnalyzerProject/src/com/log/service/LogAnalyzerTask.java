package com.log.service;

import java.util.List;

public class LogAnalyzerTask extends Thread {

    private List<String> logs;
    private int infoCount = 0;
    private int errorCount = 0;
    private int warningCount = 0;

    public LogAnalyzerTask(List<String> logs) {
        this.logs = logs;
    }

    public void run() {
        for (String log : logs) {

            if (log.contains("INFO")) {
                infoCount++;
            } else if (log.contains("ERROR")) {
                errorCount++;
            } else if (log.contains("WARNING")) {
                warningCount++;
            }
        }
    }

    public int getInfoCount() { return infoCount; }
    public int getErrorCount() { return errorCount; }
    public int getWarningCount() { return warningCount; }
}