package com.kabarret.predojo.parser;

import com.kabarret.predojo.domain.Kill;
import com.kabarret.predojo.domain.Match;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.kabarret.predojo.enums.LogInstruction.END_MATCH;
import static com.kabarret.predojo.enums.LogInstruction.NEW_MATCH;

public class MatchParser {

    private static final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";
    private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

    public static Match parse(final String logLine) {
        Match match = new Match();

        Pattern p = Pattern.compile(NEW_MATCH.getPattern());
        Matcher m = p.matcher(logLine);

        if (m.find()) {
            try {
                match.setStart(sdf.parse(m.group(1)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            match.setId(m.group(3));
            match.setKillList(new ArrayList<Kill>());
        }

        return match;
    }

    public static Match endMatch(final String logLine,final Match match) {
        Pattern p = Pattern.compile(END_MATCH.getPattern());
        Matcher m = p.matcher(logLine);

        if (m.find()) {
            try {
                match.setEnd(sdf.parse(m.group(1)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return match;
    }

}
