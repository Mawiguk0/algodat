package de.mawiguko.studium.aldastru.Aufgabe_3;

import de.mawiguko.studium.aldastru.doublelinkedlist.DoublyLinkedList;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Aufgabe_3 {
    public static void main (String[] args ){
        String input = "Dies ist ein binaerer Baum zum traversieren.";
        String[] words = input.split("(?=(\\.|,|\\s|!|\\?))");

        LinkedList<LinkedList<Character>> root = new LinkedList<>();
        for (String s : words) {
            LinkedList<Character> tmp = new LinkedList<Character>();
            for(Character c : s.toCharArray()) {
                tmp.add(c);
            }
            root.add(tmp);
        }
        System.out.print(root.toString());
    }
}
