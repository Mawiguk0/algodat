package de.mawiguko.studium.aldastru.Aufgabe_2;

import de.mawiguko.util.Spooler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Aufgabe_2_1 {

    public static void main (String[] args) {
        ArrayList<Character> spooler = new ArrayList<>();
        System.out.print("### Algorithmen und Datenstrukturen ###");
        System.out.print("\n\t~ Spooler für Tastatureingaben ~");
        System.out.print("\n\t    ~ Aufgabe 2.1 und 2.2 ~\n");

        Spooler mySpooler = new Spooler(20,10);
        do {
            mySpooler.read();
        } while (true);
    }
}
