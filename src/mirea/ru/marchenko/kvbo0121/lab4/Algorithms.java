package mirea.ru.marchenko.kvbo0121.lab4;

public class Algorithms {
    private final static boolean RIGHT_TO_LEFT = false;

    static int[][] permutations(int n) {
        int permutationsLength = factorial(n);

        int[] permutation = new int[n];
        boolean[] directions = new boolean[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i + 1;
            directions[i] = RIGHT_TO_LEFT;
        }

        final var permutations = new int[permutationsLength][n];
        permutations[0] = permutation.clone();


        for (int i = 1; i < permutationsLength; i++) {
            generateNextPermutation(permutation, directions);
            permutations[i] = permutation.clone();
        }

        return permutations;
    }

    private static int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) ans *= i;
        return ans;
    }

    private static void generateNextPermutation(int[] permutation, boolean[] directions) {
        int[] m = findMobileValueAndIndex(permutation, directions);
        int mobileNumber = m[0];
        int mobileIndex = m[1];

        boolean mobileGoesLeft = directions[permutation[mobileIndex] - 1] == RIGHT_TO_LEFT;
        int temp = permutation[mobileIndex];

        if (mobileGoesLeft) {
            permutation[mobileIndex] = permutation[mobileIndex - 1];
            permutation[mobileIndex - 1] = temp;
        } else {
            permutation[mobileIndex] = permutation[mobileIndex + 1];
            permutation[mobileIndex + 1] = temp;
        }

        for (int i : permutation) if (i > mobileNumber) directions[i - 1] = !directions[i - 1];

    }

    private static int[] findMobileValueAndIndex(int[] permutation, boolean[] directions) {
        final int n = permutation.length;
        int mobile = 0, index = 0;

        for (int i = 0; i < n; i++) {
            int number = permutation[i];

            boolean goesLeft = directions[number - 1] == RIGHT_TO_LEFT;
            boolean canGoLeft = i != 0 && goesLeft && number > permutation[i - 1];
            boolean canGoRight = i != n - 1 && !goesLeft && number > permutation[i + 1];
            boolean isMobile = canGoLeft || canGoRight;

            boolean largerThanPrevious = number > mobile;

            if (largerThanPrevious && isMobile) {
                mobile = number;
                index = i;
            }
        }

        return new int[]{mobile, index};
    }


}
