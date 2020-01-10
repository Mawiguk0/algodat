package de.mawiguko.util;

public class AlgoMath {
    public AlgoMath() {

    }
    public static int ggT(int a, int b, int recursions) {
        if (b == 0) {
            System.out.println("Recursions: "+recursions);
            return a;
        }
        recursions++;
        return ggT(b,a%b, recursions);
    }
}
