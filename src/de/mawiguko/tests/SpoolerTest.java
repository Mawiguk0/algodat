package de.mawiguko.tests;

import de.mawiguko.util.Spooler;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SpoolerTest {
    @Test
    void sizeIntegrity() {
        //int testSize = (int) (9123 * Math.random());
        //int testOutputIndex = (int) testSize/2;
        //Spooler spooler = new Spooler(testSize,(int) testSize/2);
        Spooler spooler = new Spooler(10,5);
        String testStringMaxSize ="abcdefghij";
        for(Character c : testStringMaxSize.toCharArray()) {
            spooler.put(c);
        }
        assertEquals(10,spooler.size());
        spooler.put('1');
        assertEquals(10, spooler.size());
    }

    @Test
    void flushExplicit() {
        Spooler spooler = new Spooler(10,5);
        String testStringMaxSize ="abcdefghij";
        for(Character c : testStringMaxSize.toCharArray()) {
            spooler.put(c);
        }
        spooler.flush();
        assertEquals(0, spooler.size());
    }

    @Test
    void flushImplicit() {
    }

    @Test
    void checkOutputModeVerbose() {
    }
    @Test
    void checkOutputModeQuiet() {
    }
    @Test
    void validateInput() {
    }

}