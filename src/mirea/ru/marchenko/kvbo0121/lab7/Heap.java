package mirea.ru.marchenko.kvbo0121.lab7;

// https://www.geeksforgeeks.org/min-heap-in-java/
public class Heap {
    private final int[] heap;
    private final int size;
    private final int maxSize;

    private static final int FRONT = 1;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;

        heap = new int[maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return pos * 2 + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2);
    }

    private void swap(int pos1, int pos2) {
        int tmp = heap[pos1];

        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    private void maxHeapify(int pos) {

    }
}
