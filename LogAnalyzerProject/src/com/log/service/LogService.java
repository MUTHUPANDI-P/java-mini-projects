package com.log.service;

import java.io.*;
import java.util.*;

public class LogService {

    public void analyzeLogFile(String filePath) {

        List<String> allLogs = new ArrayList<>();

   
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                allLogs.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file!");
            return;
        }

    
        int mid = allLogs.size() / 2;

        List<String> part1 = allLogs.subList(0, mid);
        List<String> part2 = allLogs.subList(mid, allLogs.size());

        LogAnalyzerTask t1 = new LogAnalyzerTask(part1);
        LogAnalyzerTask t2 = new LogAnalyzerTask(part2);

        t1.start();
        t2.start();

  
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalInfo = t1.getInfoCount() + t2.getInfoCount();
        int totalError = t1.getErrorCount() + t2.getErrorCount();
        int totalWarning = t1.getWarningCount() + t2.getWarningCount();

        System.out.println("INFO Count: " + totalInfo);
        System.out.println("ERROR Count: " + totalError);
        System.out.println("WARNING Count: " + totalWarning);
    }
}