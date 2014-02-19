package com.kabarret.predojo.enums;

public enum LogInstruction {

    NEW_MATCH("(.*) (-) New match (.*) has started"),
    KILL("(.*) (-) (.*) killed (.*) using (.*)"),
    WORLD_KILL("(.*) (-) <WORLD> killed (.*) by (.*)"),
    END_MATCH("(.*) (-) Match (.*) has ended");

    private String pattern;

    private LogInstruction (String pattern){
        this.pattern = pattern;
    }

    public static LogInstruction getLogInstruction(String logLine){
        LogInstruction matchLogInstruction = null;
        for (LogInstruction logInstruction : LogInstruction.values()) {
            if(logLine.matches(logInstruction.pattern)){
                matchLogInstruction = logInstruction;
                break;
            }
        }
        return matchLogInstruction;
    }

    public String getPattern() {
        return pattern;
    }
}
