package mirea.ru.marchenko.kvbo0121.lab6;

import java.util.Arrays;

class MyLinkedList {
    private final Node head;

    private int size;

    public MyLinkedList() {
        head = new Node(null);
        size = 0;
    }

    public void add(int data) {
        Node current = head.getNext();
        if (current == null) {
            head.setNext(new Node(new int[]{data}));
            return;
        }

        while (current.getNext() != null) {
            if (current.getNext().getData()[0] > data) break;
            current = current.getNext();
        }

        int[] currentData = current.getData();
        int[] newData = new int[currentData.length + 1];
        System.arraycopy(currentData, 0, newData, 0, currentData.length);
        newData[currentData.length] = data;
        Arrays.sort(newData);

        if (newData.length > 5) {
            int extra = newData[5];

            int[] temp = new int[5];
            System.arraycopy(newData, 0, temp, 0, 5);
            current.setData(temp);

            while (true) {
                if (current.getNext() == null) {
                    current.setNext(new Node(new int[]{extra}));
                    size++;
                    break;
                } else {
                    current = current.getNext();
                    currentData = current.getData();

                    newData = new int[Math.min(5, currentData.length + 1)];
                    System.arraycopy(currentData, 0, newData, 1, Math.min(4, currentData.length));
                    newData[0] = extra;
                    current.setData(newData);

                    if (currentData.length < 5) break;

                    extra = currentData[4];
                }
            }

        } else {
            current.setData(newData);
        }

    }

    public int[] get(int index) {
        if (index <= 0) return null;

        Node current = head.getNext();

        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) return null;
            current = current.getNext();
        }

        return current.getData();
    }

    public boolean remove(int index) {
        if (index <= 0) return false;

        Node current = head.getNext();

        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) return false;
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node current = head.getNext();

        StringBuilder output = new StringBuilder();

        while (current != null) {
            output.append(Arrays.toString(current.getData()));
            current = current.getNext();
        }

        return output.toString();
    }
}
