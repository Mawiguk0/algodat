package de.mawiguko.studium.aldastru.doublelinkedlist;

import de.mawiguko.studium.aldastru.testdaten.Stammdatum;

import java.io.*;

/**
 * DoubleLinkedElement is part of the DoubleLinkedList Package by Mawiguko
 * @author Markus Kohn
 * @param <T> Object to be stored in the DoubleLinkedElement<T>.
 */
public class DoubleLinkedElement<T> implements Serializable {
    DoubleLinkedElement prev;
    T object;
    DoubleLinkedElement next;

    public DoubleLinkedElement(T _object){
        this.object = _object;
        this.next = null;
    }

    public void setNext(DoubleLinkedElement _next) {
        this.next = _next;
    }

    public void setPrev(DoubleLinkedElement prev) {
        this.prev = prev;
    }

    public DoubleLinkedElement getNext() {
        return next;
    }

    public DoubleLinkedElement getPrev() {
        return prev;
    }

    public T getObject() {
        return object;
    }

    public boolean hasNext() {
        return getNext()!= null ? true: false;
    }

    public boolean hasPrev() {
        return getPrev()!= null ? true : false;
    }

    public void printObject() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb
                .append("\t[")
                .append((this.hasPrev())?((Stammdatum) this.getPrev().getObject()).getName():"null")
                .append("] <- [")
                .append(((Stammdatum) object).getName().toUpperCase())
                .append("] -> [")
                .append((this.hasNext())?((Stammdatum) this.getNext().getObject()).getName():"null")
                .append("]"));

    }

    @Override
    public boolean equals(Object obj) {
        try {
            if(((DoubleLinkedElement) obj).getObject().toString().equals(this.getObject().toString())) {
                return true;
            }
        }catch (Exception e) {
            return false;
        }
        return false;
    }


}
