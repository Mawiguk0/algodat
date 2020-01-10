package de.mawiguko.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashMap {
    public String[] values;
    public String[] keys;
    public int myMapcollisions;
    public HashMap(int size) {
        values = new String[size];
        keys = new String[size];
        this.myMapcollisions = 0;
    }

    /**
     *
     * @param values to
     * @return number of myMapcollisions
     */
    public int put(String... values) {
        int collisions = 0;
        for(String s : values) {
            List<String> tmpValues =  Arrays.asList(this.values);
            ArrayList<String> tmptmpVal = new ArrayList<>();
            for(String tmpval : tmpValues) {
                if(tmpval != null) {
                    tmptmpVal.add(tmpval);
                }
            }
            tmptmpVal.add(s);
            this.values = tmptmpVal.toArray(this.values);

            List<String> tmpKeys = Arrays.asList(keys);
            ArrayList<String> tmptmpkeys = new ArrayList<>();
            for (String tempkey : tmpKeys) {
                if(tempkey != null) {
                    tmptmpkeys.add(tempkey);
                }
            }
            tmptmpkeys.add(generateKey(s));

            keys = tmptmpkeys.toArray(keys);

            for (String si : keys) {
                if(si!=null) {
                if (si.equals(generateKey(s))) {
                    System.out.println("Collision!!!");
                    collisions++;
                }
            }}
        }
        this.myMapcollisions = collisions;
        return collisions;
    }

    private String generateKey(String value) {
        int key = 0;
        for ( int i = 0; i < value.length() ; i++ ) {
            key = key + 10^1* (int) value.toCharArray()[i];
        }
        return String.valueOf(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("## HashMap ##\n\tKollisionen:\t")
                .append(this.myMapcollisions)
                .append("\n\tGröße:\t\t")
                .append(this.keys.length)
                .append("\n\t\t[Key] - [Value]");
        for(int i = 0; i < keys.length; i++) {
            sb.append("\n\t\t[").append(keys[i]).append("] - [").append(values[i]).append("]");
        }
        return sb.toString();
    }
}
