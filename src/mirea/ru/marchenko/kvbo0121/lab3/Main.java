package mirea.ru.marchenko.kvbo0121.lab3;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<Card> hand1 = new LinkedList<>();
        LinkedList<Card> hand2 = new LinkedList<>();

        int option;
        System.out.println("Choose starting conditions:\n [1] Input manually\n [2] Randomize");
        try {
            option = in.nextInt();
            in.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, try again");
            return;
        }

        if (option == 1) {
            try {
                System.out.println("Input first player hand: ");

                for (String c : in.nextLine().split(" ")) {
                    hand1.add(new Card(Integer.parseInt(c)));
                }

                System.out.println("Input second player hand: ");
                for (String c : in.nextLine().split(" ")) {
                    hand2.add(new Card(Integer.parseInt(c)));
                }

                if (hand2.size() != hand1.size()) {
                    System.out.println("Error: Hands have different sizes");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input is invalid");
                return;
            }
        } else if (option == 2) {
            List<Card> deck = new ArrayList<>(IntStream.range(0, 10).mapToObj(Card::new).toList());
            Collections.shuffle(deck);
            hand1 = new LinkedList<>(deck.subList(0, 5));
            hand2 = new LinkedList<>(deck.subList(5, 10));

            System.out.println("First hand: " + Arrays.toString(hand1.stream().mapToInt(Card::value).toArray()));
            System.out.println("Second hand: " + Arrays.toString(hand2.stream().mapToInt(Card::value).toArray()));
        } else {
            System.out.println("No such option, try again");
            return;
        }

        Game game = new Game(hand1, hand2);

        System.out.println("Result of the game: " + game.play(0));
    }
}

// 6 3 8 2 1 / 0 4 9 5 7 -> second 9
// 9 3 5 2 1/ / 0 4 8 6 7 -> second 5
// 4 0 1 9 7 / 2 3 5 6 8 -> botva
