package com.kabarret.predojo.parser;

import com.kabarret.predojo.domain.Kill;
import junit.framework.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KillParserTest extends TestCase {

    public void testParser() throws ParseException {

        Kill kill = (Kill) new KillParser().parser("23/04/2013 15:36:04 - Roman killed Nick using M16");
        assert kill.getUser().getName().equals("Roman");
        assert kill.getUserKilled().getName().equals("Nick");
        assert kill.getWeapon().equals("M16");
        assert kill.getTime().equals(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("23/04/2013 15:36:04"));

    }
}
