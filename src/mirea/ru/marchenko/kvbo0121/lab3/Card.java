package mirea.ru.marchenko.kvbo0121.lab3;

public record Card(int value) implements Comparable<Card> {
    @Override
    public int compareTo(Card o) {
        if (value == 9 && o.value == 0) return -1;
        if (value == 0 && o.value == 9) return 1;
        return Integer.compare(value, o.value);
    }
}
