package com.kabarret.predojo.service;

import com.kabarret.predojo.domain.LogLine;
import com.kabarret.predojo.enums.LogInstruction;
import junit.framework.TestCase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class LoggerReaderTest extends TestCase {

    public void testFileLogReader() throws Exception {
        BufferedWriter writer = null;

        File logFile = new File("testFileLogReader.tmp");

        // This will output the full path where the file will be written to...
        System.out.println(logFile.getCanonicalPath());

        writer = new BufferedWriter(new FileWriter(logFile));
        writer.write("23/04/2013 15:34:22 - New match 11348965 has started\n" +
                "23/04/2013 15:36:04 - Roman killed Nick using M16\n" +
                "23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN\n" +
                "23/04/2013 15:39:22 - Match 11348965 has ended");

        writer.close();
        List<LogLine> logInstructionList = new LoggerReaderService().fileLogReader(logFile);

        assert logInstructionList.size() == 4;
        assert logInstructionList.get(0).getLogInstruction() == LogInstruction.NEW_MATCH;
        assert logInstructionList.get(1).getLogInstruction() == LogInstruction.KILL;
        assert logInstructionList.get(2).getLogInstruction() == LogInstruction.WORLD_KILL;
        assert logInstructionList.get(3).getLogInstruction() == LogInstruction.END_MATCH;

        logFile.delete();
    }
}
