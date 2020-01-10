package de.mawiguko.studium.aldastru.Aufgabe_5;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;

public class Aufgabe_5 {
    static HashMap<String, String> javaHash = new HashMap<>();
    static HashMap<Integer, String> ownHash = new HashMap<>();
    static String[] namen= new String[32];
    public static void main (String[] args) {
        String namenString = "Alexander, David, Felix, Maximilian, Leon, Lukas, Luca, Paul, Jonas, Tim, Anna, Emily, Julia, Maria, Laura, Lea, Lena, Leonie, Marie, Sophie";

        de.mawiguko.util.HashMap myMap = new de.mawiguko.util.HashMap(32);
        namen = namenString.split(", ");
        myMap.put(namen);

        System.out.println(myMap.toString());

        System.out.println("");
    }
}
