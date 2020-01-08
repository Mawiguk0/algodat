package de.mawiguko.util;

import de.mawiguko.helpers.OutputMode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Spooler {
    private LinkedList<Character> spooler = new LinkedList<>();
    private int maxSize, outputIndex;
    private Scanner stdin;
    private OutputMode mode;

    public Spooler(int _maxSize, int _outputIndex) {
        maxSize = _maxSize;
        outputIndex = _outputIndex;
        stdin = new Scanner(System.in);
        mode = OutputMode.VERBOSE;
    }

    public void read() {
        String raw = stdin.next();
        raw = validateInput(raw);
        for(Character c : raw.toCharArray()) {
            this.put(c);
        }
    }

    public void put(Character character) {
        spooler.addFirst(character);
        if(spooler.size() >= outputIndex + 1) {
            if(mode == OutputMode.VERBOSE) {
                System.out.println(spooler.get(outputIndex));
            }
        }
        if(spooler.size() >= maxSize+1) {
            spooler.remove(spooler.getLast());
        }
    }

    public void flush() {
        for (Iterator<Character> it = spooler.descendingIterator(); it.hasNext(); ) {
            char c = it.next();
            System.out.println(c);
        }
        spooler.clear();
    }

    public String validateInput(String raw) {
        raw = raw.strip();
        switch (raw) {
            case "CTRL-S" : mode = OutputMode.QUIET; break;
            case "CTRL-Q" : mode = OutputMode.VERBOSE; break;
            case "0" : flush(); break;
            default : return  raw;
        }
        raw = raw.replaceAll("CTRL-S","");
        raw = raw.replaceAll("CTRL-Q","");
        raw = raw.replaceAll("0","");
        return raw;
    }

    public int size() {
        return this.spooler.size();
    }
}
