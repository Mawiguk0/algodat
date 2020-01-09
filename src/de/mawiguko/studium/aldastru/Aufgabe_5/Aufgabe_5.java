package de.mawiguko.studium.aldastru.Aufgabe_5;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;

public class Aufgabe_5 {
    static HashMap<String, String> javaHash = new HashMap<>();
    static HashMap<Integer, String> ownHash = new HashMap<>();
    static String[] namen= new String[32];
    public static void main (String[] args) {
        String namenString = "Alexander, David, Felix, Maximilian, Leon, Lukas, Luca, Paul, Jonas, Tim, Anna, Emily, Julia, Maria, Laura, Lea, Lena, Leonie, Marie, Sophie";

        namen = namenString.split(", ");
        put(namen);

        System.out.println("");

    }

    private static void put(String... _namen) {
        System.out.println("Hash : Value : Collisions");
        // Add All key-values to javaHash
        int collisionSum = 0;
        for(String s : _namen) {
            if(javaHash.containsKey(String.valueOf(s.hashCode()))) {
                collisionSum++;
            }
            javaHash.put(String.valueOf(s.hashCode()),s);
            ownHash.put(generateKey(s),s);
        }
        // check for collision per name and add to over all Collisions:
        for(String s : _namen) {
            String tmpCollisions = javaHash.containsKey(String.valueOf(s.hashCode()))?String.valueOf(collisionSum):"";
            System.out.println(s.hashCode()+" : "+ s+" : "+tmpCollisions);
            javaHash.containsKey(String.valueOf(s.hashCode()));
        }
    }

    public static int generateKey(String surname) {
        int key = 0;
        for ( int i = 0; i < surname.length() ; i++ ) {
            key = key + 10^1* (int) surname.toCharArray()[i];
        }
        return key;
    }
}
