package de.mawiguko.studium.aldastru.Aufgabe_6;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Krankenhaus{
    private String name, adresse;
    private int plz;
    private String ort;
    private int kapazität;

    public Krankenhaus(String name, String adresse, int plz, String ort, int kapazität) {
        this.name = name;
        this.adresse = adresse;
        this.plz = plz;
        this.ort = ort;
        this.kapazität = kapazität;
    }

    public static List<Krankenhaus> readFromFile(File file) throws IOException {
        System.out.println("## Read from File");
        System.out.println("\tFile:\t"+file.getAbsolutePath());
        List<Krankenhaus> tmp  = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file, Charset.defaultCharset()));

        String st;
        br.readLine();
        br.readLine();
        while ((st = br.readLine()) != null) {
            String[] args = st.split("\t");
            String name = args[0];
            String adresse = args[1];
            int plz = Integer.valueOf(args[2]);
            String ort = args[3];
            int kapazität = Integer.valueOf(args[4]);
            tmp.add(new Krankenhaus(name,adresse,plz,ort,kapazität));
            br.readLine();
        }
        System.out.println("\tCount:\t"+tmp.size());
        System.out.println("\tStatus:\t"+"finished");

        return tmp;
    }

    public String getName() {
        return name.length()<1?"unkown":name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse.length()<1?"unkown":adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort.length()<1?"unkown":ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getKapazität() {
        return kapazität;
    }

    public void setKapazität(int kapazität) {
        this.kapazität = kapazität;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("# ")
                .append(this.getName())
                .append(" #")
                .append("\t\n\tStraße:\t")
                .append(this.getAdresse())
                .append("\t\n\tPLZ:\t")
                // adding a leading '0' if needed
                .append(this.getPlz()<10000?"0"+this.getPlz():this.getPlz())
                .append("\t\n\tOrt:\t")
                .append(this.getOrt())
                .append("\t\n\tKapaz.:\t")
                .append(this.getKapazität());
        return sb.toString();
    }

    public int compareToCapacity(Krankenhaus k) {
        if(this.getKapazität() > k.getKapazität()) {
            return 1;
        } else if (this.getKapazität() < k.getKapazität()) {
            return  -1;
        }
        return 0;
    }

    public int compareToPLZ(Krankenhaus k) {
        if(this.getPlz() > k.getPlz()) {
            return 1;
        } else if (this.getPlz() < k.getPlz()) {
            return  -1;
        }
        return 0;
    }
}
