package de.mawiguko.studium.aldastru.doublelinkedlist;

import de.mawiguko.studium.aldastru.testdaten.Searchcriteria;
import de.mawiguko.studium.aldastru.testdaten.Stammdatum;

import java.io.*;
import java.util.NoSuchElementException;

/**
 * DoubleLinkedList of DoubleLinkedElement<T>
 * @author Markus Kohn
 */
public class DoublyLinkedList<T> implements Serializable {
    public DoubleLinkedElement start = new DoubleLinkedElement("start");
    public DoubleLinkedElement end = new DoubleLinkedElement("end");

    int length;

    public DoublyLinkedList() {
        length = 0;
    }

    /**
     *
     * @param elements Variadic function
     */
    public void insert(DoubleLinkedElement... elements) {

        for(DoubleLinkedElement element : elements) {
            StringBuilder sb = new StringBuilder();
            sb
                    .append("\n## Inserting ##\n\t")
                    .append(element.getObject().toString());
            if (length == 0) {
                start = element;
                element.setNext(null);
                length = 1;
                sb.append("\n\t@start");
            } else if (length == 1) {
                end = element;
                start.setNext(end);
                end.setPrev(start);
                length = 2;
                sb.append("\n\t@"+length);
            } else {
                element.setPrev(end);
                end.setNext(element);
                end = element;
                length++;
                sb.append("\n\t@"+length);
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * Deletes Element and Closes the Chain from the DoubleLinkedList
     * @param element
     */
    public void delete(DoubleLinkedElement element) {
        try{
            find(element);
            if(start.equals(element)){
                start = start.getNext();
            }
            if(element.hasNext()) {
                element.getNext().setPrev(element.getPrev());
            }
            if (element.hasPrev()) {
                element.getPrev().setNext(element.getNext());
            }
            length--;
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {

        }
    }

    public DoubleLinkedElement find (DoubleLinkedElement element){
        DoubleLinkedElement tmp = start;
        while(tmp.hasNext()) {
            if(tmp.equals(element)) {
                return tmp;
            } else {
                tmp = tmp.getNext();
            }
        }
        return null;
        //throw new NoSuchElementException("Element not part of this DoubleLinkedList");
    }

    /**
     * Searches for Stammdatum in Double Linked List
     * @param searchcriteria
     * @param searchString
     * @return
     */
    public DoubleLinkedElement find (Searchcriteria searchcriteria, String searchString) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("\n## Suche nach Searchcriteria ##")
                .append("\n\tCriteria:\t")
                .append(searchcriteria.name())
                .append("\n\tSearchstr:\t")
                .append(searchString);

        String objectString = "";
        DoubleLinkedElement le = start;
        Stammdatum obj = (Stammdatum) le.getObject();

        while(le.getNext() != null) {
            switch (searchcriteria) {
                case Vorname: {
                    objectString = obj.getVorname();
                    break;
                }
                case Nachname: {
                    objectString = obj.getNachname();
                    break;
                }
                case Geburtstag: {
                    objectString = obj.getGeburtstag().toString();
                    break;
                }
                case Verischerungsnummer: {
                    objectString = String.valueOf(obj.getVersicherungsnummer());
                    break;
                }
                default:
                    break;
            }
            if(objectString.contains(searchString)) {
                sb
                        .append("\n\tFound:\t\t'")
                        .append(searchString)
                        .append("' in '")
                        .append(objectString)
                        .append("'\n\tObject:\t\t")
                        .append(le.toString());
                System.out.println(sb.toString());
                return le;
            }
            le=le.getNext();
            obj= (Stammdatum) le.getObject();
        }
        System.out.println(sb.append("\nNothing found...").toString());
        return null;
    }

    /**
     * Deletes Elements from a DoubleLinkedList from the DoubleLinkedList
     * @param elements
     */
    public void deleteAll (DoublyLinkedList elements) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("\n## Delete All ##\n\tDeleting:\n\t\t")
                .append(elements.toString())
                .append("\n\tFrom:")
                .append("\n\t\t")
                .append(this.toString());
        DoubleLinkedElement deleteCandidate = elements.start;
        while(deleteCandidate.hasNext()) {
            this.delete(this.find(deleteCandidate));
            deleteCandidate = deleteCandidate.getNext();
        }
        deleteCandidate = deleteCandidate.getNext();
        this.delete(this.find(deleteCandidate));
        sb
                .append("\n\tLeft:\n\t\t")
                .append(this.toString());
        System.out.println(sb.toString());
    }

    /**
     * Will Print from starting Element to End of List
     * @param startElement from that the Recursion will take place.
     */
    public void printRecursive (DoubleLinkedElement startElement) {
        startElement.printObject();
        if (startElement.hasNext()) {
            this.printRecursive(startElement.getNext());
        }
    }

    /**
     * Uses recursive Print trough List
     */
    public void printList () {
        StringBuilder sb = new StringBuilder();
        sb.append("\n## Printing List Details ##")
                .append("\n\tlength:\t\t")
                .append(this.countFrom(start))
                .append("\n\tClass:\t\t")
                .append(this.start.getObject().getClass().getSimpleName())
                .append("\n\tItems:\t\t")
                .append(this.toString());
        System.out.println(sb.toString());
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();
        DoubleLinkedElement tmp = start;
        sb
                .append("[null] <-> [")
                .append(((Stammdatum)start.getObject()).getName())
                .append("] <-> ");
        while(tmp.hasNext()) {
            tmp = tmp.getNext();
            sb
                    .append("[")
                    .append(((Stammdatum)tmp.getObject()).getName())
                    .append("] <-> ");
        }
        sb.append("[null]");
        return sb.toString();
    }

    /**
     * Output is Generated
     * @return
     */
    public void printCountElements() {
        System.out.println("\n##  Zähle Elemente: ##");
        System.out.println("\tLänge:\t"+countFrom(start));
    }

    private int countFrom(DoubleLinkedElement start) {
        if(start.hasNext()) {
            return 1 + countFrom(start.getNext());
        }
        return 1;
    }

    public void writeListToDisk(File file) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("\n## Writing List to Disk ##")
                .append("\n\tLength:\t\t"+countFrom(start))
                .append("\n\tClass:\t\t"+this.start.getObject().getClass().getSimpleName())
                .append("\n\tFile:\t\t"+file.getAbsolutePath());
        System.out.println(sb.toString());
        try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(file, true))){
        oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DoublyLinkedList readFromDisk(File file) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("\n## Lese Liste von Datei ##")
                .append("\n\tFile:\t")
                .append(file.getAbsolutePath());
        DoublyLinkedList newList;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            newList = (DoublyLinkedList) ois.readObject();
            sb
                    .append("\n\tListe erfolgreich eingelesen")
                    .append("\n\tListe:\t")
                    .append(newList.toString());
            System.out.println(sb.toString());
            return newList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        sb.append("\n\tKonnte keine Liste lesen");
        System.out.println(sb.toString());
        return null;
    }
}