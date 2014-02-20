package com.kabarret.predojo.enums;

import junit.framework.TestCase;
import org.junit.Test;

public class LogInstructionTest extends TestCase {

    @Test
    public void testGetLogInstruction() throws Exception {
        assert LogInstruction.NEW_MATCH == LogInstruction.getLogInstruction("23/04/2013 15:34:22 - New match 11348965 has started");
        assert LogInstruction.KILL == LogInstruction.getLogInstruction("23/04/2013 15:36:04 - Roman killed Nick using M16");
        assert LogInstruction.WORLD_KILL == LogInstruction.getLogInstruction("23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN");
        assert LogInstruction.END_MATCH == LogInstruction.getLogInstruction("23/04/2013 15:39:22 - Match 11348965 has ended");
        assert null == LogInstruction.getLogInstruction("bla bla bla");
    }
}
