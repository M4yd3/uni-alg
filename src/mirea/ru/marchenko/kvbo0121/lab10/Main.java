package mirea.ru.marchenko.kvbo0121.lab10;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        String haystack = "abcaabcabdbcaabcabd";
        String needle = "abcabd";

        System.out.println(findMatch(haystack, needle));
    }

    static ArrayList<Integer> findMatch(String string, String pattern) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> a = new ArrayList<>();
        int[] p = prefix(string);

        while (i < string.length()) {
            if (string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                a.add(i - j);
                j = p[j - 1];
            } else if (i < string.length() && string.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = p[j - 1];
                } else {
                    i++;
                }
            }
        }
        return a;
    }

    static int[] prefix(String string) {
        int[] prefix = new int[string.length()];
        for (int i = 1; i < prefix.length; i++) {
            int k = prefix[i - 1];
            while (k > 0 && string.charAt(k) != string.charAt(i)) k = prefix[k - 1];
            if (string.charAt(k) == string.charAt(i)) k++;
            prefix[i] = k;
        }
        return prefix;
    }
}
