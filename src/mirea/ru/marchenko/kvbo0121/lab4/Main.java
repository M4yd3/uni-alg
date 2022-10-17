package mirea.ru.marchenko.kvbo0121.lab4;

import java.util.Scanner;

public class Main {
    private static final String[] colors = {
            "\033[0;32m", "\033[0;34m", "\033[0;33m", "\033[0;31m", "\033[0;36m", "\033[0m"
    };

    // Steinhaus–Johnson–Trotter algorithm
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();

        final int[][] permutations = Algorithms.permutations(n);

        for (final int[] permutation : permutations) {
            for (final int number : permutation) {
                System.out.print(colors[(number - 1) % colors.length]);
                System.out.print(number);
            }
            System.out.println();
        }
    }
}