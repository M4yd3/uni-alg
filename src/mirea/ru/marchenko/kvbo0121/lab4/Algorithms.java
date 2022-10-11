package mirea.ru.marchenko.kvbo0121.lab4;

import java.util.LinkedList;

public class Algorithms {
    private final static boolean RIGHT_TO_LEFT = false;
    private final static boolean LEFT_TO_RIGHT = true;

    static LinkedList<int[]> permutations(int n) {
        final var permutations = new LinkedList<int[]>();

        int[] currentPermutation = new int[n];

        boolean[] directions = new boolean[n];

        for (int i = 0; i < n; i++) {
            currentPermutation[i] = i + 1;
        }
        permutations.add(currentPermutation);

        for (int i = 0; i < n; i++) directions[i] = RIGHT_TO_LEFT;

        for (int i = 1; i < factorial(n); i++) {
            currentPermutation = generatePermutation(currentPermutation, directions[i], n);
        }

        return permutations;
    }

    private static int factorial(int n) {
        int ans = 1;
        for (int i = 0; i <= n; i++) ans *= i;
        return ans;
    }

    private static int[] generatePermutation(int[] previous, boolean direction, int n) {
        return new int[n];
    }
}
