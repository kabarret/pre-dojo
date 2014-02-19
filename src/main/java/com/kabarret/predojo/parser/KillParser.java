package com.kabarret.predojo.parser;

import com.kabarret.predojo.domain.Kill;
import com.kabarret.predojo.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.kabarret.predojo.enums.LogInstruction.KILL;

public class KillParser {

    private static final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";
    private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

    public static Kill parser(String killLog){
        Kill kill = new Kill();

        Pattern p = Pattern.compile(KILL.getPattern());
        Matcher m = p.matcher(killLog);

        if (m.find()) {
            try {
                kill.setTime(sdf.parse(m.group(1)));
            } catch (ParseException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            kill.setUser(new User(m.group(3)));
            kill.setUserKilled(new User(m.group(4)));
            kill.setWeapon(m.group(5));
        }

        return kill;
    }

}
