package de.mawiguko.studium.aldastru.Aufgabe_1;


import de.mawiguko.studium.aldastru.doublelinkedlist.DoubleLinkedElement;
import de.mawiguko.studium.aldastru.doublelinkedlist.DoublyLinkedList;
import de.mawiguko.studium.aldastru.testdaten.Searchcriteria;
import de.mawiguko.studium.aldastru.testdaten.Stammdatum;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Markus Kohn
 *
 * Main to Test all Exercises from Aufgabe 1, AlDaStru
 */
public class Programm {

    public static void main(String[] args) {
        DoubleLinkedElement<Stammdatum> alan = new DoubleLinkedElement<Stammdatum>(
                new Stammdatum(
                        "Alan",
                        "Turing",
                        new Date(1912, 6, 23),
                        2123123));

        DoubleLinkedElement<Stammdatum> linus = new DoubleLinkedElement<Stammdatum>(
                new Stammdatum(
                        "Linus",
                        "Torvalds",
                        new Date(1969, 12, 28),
                        71717171));

        DoubleLinkedElement<Stammdatum> konrad = new DoubleLinkedElement<Stammdatum>(
                new Stammdatum(
                        "Konrad Ernst Otto",
                        "Zuse",
                        new Date(1995, 12, 18),
                        13371337));

        DoubleLinkedElement<Stammdatum> joseph = new DoubleLinkedElement<Stammdatum>(
                new Stammdatum(
                        "Joseph",
                        "Weizenbaum",
                        new Date(1923, 1, 8),
                        69696969));

        DoubleLinkedElement<Stammdatum> tim = new DoubleLinkedElement<Stammdatum>(
                new Stammdatum(
                        "Tim",
                        "Berners-Lee",
                        new Date(1955, 6, 8),
                        42424242));

        DoublyLinkedList liste = new DoublyLinkedList();

        System.out.print("### Algorithmen und Datenstrukturen ###");
        System.out.print("\n\t~ Doppelt Verkettete Liste ~");
        System.out.print("\n\t   ~ Aufgabe 1.1 und .2 ~\n");

        liste.insert(alan);
        liste.printList();

        liste.insert(konrad);
        liste.printList();

        List<DoubleLinkedElement> tmpList = new ArrayList<>();
        tmpList.add(linus);
        tmpList.add(joseph);
        tmpList.add(tim);
        DoubleLinkedElement[] tmpArray = new DoubleLinkedElement[3];
        tmpArray = tmpList.toArray(tmpArray);
        liste.insert(tmpArray);
        liste.printList();

        liste.printCountElements();

        File location = new File("liste");
        if (location.exists()) {
            location.delete();
            try {
                location.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        liste.writeListToDisk(location);

        DoublyLinkedList newList = liste.readFromDisk(location);
        newList.printList();

        DoublyLinkedList deleteList = newList;
        deleteList.delete(deleteList.find(Searchcriteria.Vorname,"Alan"));
        deleteList.printList();
        deleteList.delete(deleteList.find(Searchcriteria.Vorname,"Linus"));
        deleteList.printList();
        liste.deleteAll(deleteList);
    }
}