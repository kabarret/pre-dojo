package com.kabarret.predojo.service;

import com.kabarret.predojo.domain.LogLine;
import com.kabarret.predojo.enums.LogInstruction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoggerReaderService {

    public List<LogLine> fileLogReader(File log) throws IOException {
        List<LogLine> logLines = new ArrayList<LogLine>();

        FileReader fileReader = new FileReader(log);
        BufferedReader br = new BufferedReader(fileReader);
        String line = null;

        while ((line = br.readLine()) != null) {
            LogInstruction logInstruction = LogInstruction.getLogInstruction(line);
            if(logInstruction != null){
                logLines.add( new LogLine(line, logInstruction));
            }
        }

       return logLines;

    }
}
