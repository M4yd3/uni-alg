package mirea.ru.marchenko.kvbo0121.lab5;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final long seed = 678499869;
        final Crypto crypto = new Crypto(seed);

//        final Scanner in = new Scanner(System.in);
//        final String message = in.nextLine();
        final String message = "Hello, World!";

        final byte[] encodedMessage = crypto.encode(message);
        final String decodedMessage = crypto.decode(encodedMessage);
    }
}
