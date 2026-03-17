package com.log.app;

import com.log.service.LogService;

public class LogApp {

    public static void main(String[] args) {

        LogService service = new LogService();

        service.analyzeLogFile("log.txt");
    }
}