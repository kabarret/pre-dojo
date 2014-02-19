package com.kabarret.predojo.domain;

import com.kabarret.predojo.enums.LogInstruction;

public class LogLine {

    private String text;
    private LogInstruction logInstruction;

    public LogLine(String text, LogInstruction logInstruction) {
        this.text = text;
        this.logInstruction = logInstruction;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LogInstruction getLogInstruction() {
        return logInstruction;
    }

    public void setLogInstruction(LogInstruction logInstruction) {
        this.logInstruction = logInstruction;
    }
}
