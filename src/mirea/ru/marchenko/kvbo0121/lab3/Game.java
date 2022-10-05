package mirea.ru.marchenko.kvbo0121.lab3;

import java.util.LinkedList;

public class Game {
    LinkedList<Card> hand1;
    LinkedList<Card> hand2;

    public Game(LinkedList<Card> hand1, LinkedList<Card> hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    private void simulateTurn() {
        Card card1 = hand1.poll();
        Card card2 = hand2.poll();
        int result = 0;
        if (card1 != null) {
            result = card1.compareTo(card2);
        }
        if (result > 0) {
            hand1.add(card1);
            hand1.add(card2);
        } else {
            hand2.add(card1);
            hand2.add(card2);
        }
    }

    public String play(int turn) {
        if (turn > 106) return "botva";
        if (hand2.isEmpty()) return "first " + turn;
        if (hand1.isEmpty()) return "second " + turn;
        simulateTurn();
        return play(turn + 1);
    }
}
