package mirea.ru.marchenko.kvbo0121.lab6;

import java.util.Arrays;

class Node {
    private int[] data;

    private Node next;

    public Node(int[] data) {
        this.data = data;
    }

    public Node(int[] data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + Arrays.toString(data) + '}';
    }
}
