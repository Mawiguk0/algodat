package de.mawiguko.studium.aldastru.testdaten;

import java.io.Serializable;
import java.util.Date;

/**
 * @auhtor Markus Kohn
 * Easy Stammdatum Class for Testing the DoubleLinkedList/ Element
 */
public class Stammdatum implements Serializable{
    private String vorname, nachname;
    private Date geburtstag;
    private int versicherungsnummer;

    public Stammdatum(String vorname, String nachname, Date geburtstag, int versicherungsnummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.versicherungsnummer = versicherungsnummer;
    }

    public Stammdatum(String hans, String peter, Date date) {
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public void setVersicherungsnummer(int versicherungsnummer) {
        this.versicherungsnummer = versicherungsnummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getName() {
        return getVorname() + " " + getNachname();
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public int getVersicherungsnummer() {
        return versicherungsnummer;
    }

    @Override
    public String toString() {
        return "Stammdatum{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", geburtstag=" + geburtstag +
                ", versicherungsnummer=" + versicherungsnummer +
                '}';
    }
}
