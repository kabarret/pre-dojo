package com.kabarret.predojo.service;

import com.kabarret.predojo.domain.LogLine;
import com.kabarret.predojo.domain.Match;
import com.kabarret.predojo.parser.KillParser;
import com.kabarret.predojo.parser.MatchParser;

import java.util.ArrayList;
import java.util.List;

public class MatchService {

    public List<Match> buildMatches(List<LogLine> logLines){
        List<Match> matches = new ArrayList<Match>();

        Match currentMatch = null;

        for (LogLine logLine : logLines) {
            switch (logLine.getLogInstruction()){
                case  NEW_MATCH :
                    currentMatch = buildMatch(logLine);
                    break;
                case  KILL :
                    addKill(currentMatch, logLine);
                    break;
                case WORLD_KILL:
                    break;
                case END_MATCH:
                    endMatch(matches, currentMatch, logLine);
                    break;
            }
        }

        return matches;
    }

    private void endMatch(List<Match> matches, Match currentMatch, LogLine logLine) {
        MatchParser.endMatch(logLine.getText(), currentMatch);
        matches.add(currentMatch);
    }

    private Match buildMatch(LogLine logLine) {
        return MatchParser.parse(logLine.getText());
    }

    private void addKill(Match currentMatch, LogLine logLine) {
        if(currentMatch != null){
            currentMatch.getKillList().add(KillParser.parser(logLine.getText()));
        }
    }
}
