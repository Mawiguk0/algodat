package de.mawiguko.studium.aldastru.Aufgabe_6;

import de.mawiguko.helpers.UserDialog;
import de.mawiguko.studium.aldastru.testdaten.Field;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Aufgabe_6_1 {
    public static void waitForInput(){
        System.out.println("\tContinue?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        File file = new File("KHR95_red.txt");
        List<Krankenhaus> khr95 = new ArrayList<>();
        try {
            khr95= Krankenhaus.readFromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Krankenhaus k : khr95) {
            //System.out.println("\n"+k.toString());
        }
        bubblesort(khr95, Field.PLZ);
        waitForInput();
        for(Krankenhaus k : khr95) {
            System.out.println("\n"+k.toString());
        }
        selectionSort(khr95, Field.PLZ);
        waitForInput();
        for(Krankenhaus k : khr95) {
            System.out.println("\n"+k.toString());
        }
        insertionSort(khr95, Field.PLZ);
        waitForInput();
        for(Krankenhaus k : khr95) {
            System.out.println("\n"+k.toString());
        }
    }

    public static List<Krankenhaus> bubblesort(List<Krankenhaus> toSort, Field field) {
        int lastWork = 0;
        System.out.println("## BubbleSort");
        System.out.println("\tField:\t"+field.name());
        System.out.println("\tSize:\t"+toSort.size());
        if(toSort.size()>1000) {
            UserDialog dialog = new UserDialog("\n\tDataset contains more than 1000 entries.","\tDo you want to continue anyway?");
            if(!dialog.getUserContinue()) {
                return toSort;
            }
        }
        Krankenhaus temp;
        outerLoop: for(int i=1; i<toSort.size(); i++) {
            innerLoop: for(int j=0; j<toSort.size()-1; j++) {
                int raw= 0;
                fieldSwitch: switch(field) {
                    case KAPAZITÄT: {
                        raw = toSort.get(j).compareToCapacity(toSort.get(j+1));
                        break fieldSwitch;
                    }
                    case PLZ: {
                        raw = toSort.get(j).compareToPLZ(toSort.get(j+1));
                        break fieldSwitch;
                    }
                }
                if(raw>0) {
                    lastWork++;
                    temp = toSort.get(j);
                    toSort.set(j, toSort.get(j+1));
                    toSort.set(j+1, temp);
                }
            }
        }
        System.out.println("\tAufwand war: "+String.valueOf(lastWork));
        return toSort;
    }


    /**
     * Simple SelectionSort algorithm.
     * @param toSort to be sorted
     * @param field which field should be used to sort
     * @return
     */
    public static List<Krankenhaus> selectionSort(List<Krankenhaus> toSort, Field field) {
        int lastWork = 0;
        System.out.println("## SelectionSort");
        System.out.println("\tField:\t"+field.name());
        System.out.println("\tSize:\t"+toSort.size());
        if(toSort.size()>1000) {
            UserDialog dialog = new UserDialog("\n\tDataset contains more than 1000 entries.","\tDo you want to continue anyway?");
            if(!dialog.getUserContinue()) {
                return toSort;
            }
        }
        outerLoop: for (int i = 0; i < toSort.size() - 1; i++) {
            innerLoop: for (int j = i + 1; j < toSort.size(); j++) {
                boolean raw = false;
                fieldSwitch: switch (field) {
                    case KAPAZITÄT: {
                        if(toSort.get(i).getKapazität()>toSort.get(j).getKapazität())
                            raw = true;break fieldSwitch;
                    } case PLZ: {
                        if(toSort.get(i).getKapazität()>toSort.get(j).getKapazität())
                            raw = true; break fieldSwitch;
                    }
                }
                if (raw) {
                    lastWork++;
                    Krankenhaus temp = toSort.get(i);
                    toSort.set(i, toSort.get(j));
                    toSort.set(j, temp);
                }
            }
        }
        System.out.println("\tAufwand war: "+String.valueOf(lastWork));
        return toSort;
    }

    /**
     * Simple InsertionSort algorithm.
     * @param toSort to be sorted
     * @param field which field should be used to sort
     * @return
     */
    public static List<Krankenhaus> insertionSort(List<Krankenhaus> toSort, Field field) {
        int lastWork = 0;
        System.out.println("## InsertionSort");
        System.out.println("\tField:\t"+field.name());
        System.out.println("\tSize:\t"+toSort.size());
        if(toSort.size()>1000) {
            UserDialog dialog = new UserDialog("\n\tDataset contains more than 1000 entries.","\tDo you want to continue anyway?");
            if(!dialog.getUserContinue()) {
                return toSort;
            }
        }
        Krankenhaus temp;
        loop: for (int i = 1; i < toSort.size(); i++) {
            temp = toSort.get(i);
            int j = i;
            selection: switch (field) {
                case KAPAZITÄT: {
                    while (j > 0 && toSort.get(j-1).getKapazität() > temp.getKapazität()) {
                        lastWork++;
                        toSort.set(j, toSort.get(j-1));
                        j--;
                    }
                    break selection;
                }
                case PLZ: {
                    while (j > 0 && toSort.get(j-1).getPlz() > temp.getPlz()) {
                        lastWork++;
                        toSort.set(j, toSort.get(j-1));
                        j--;
                    }
                    break selection;
                }
            }

            toSort.set(j, temp);
        }
        System.out.println("\tAufwand war: "+String.valueOf(lastWork));
        return toSort;
    }

    public static int search(int plz) {
        int aufwand = 0;


        return aufwand;
    }
}
