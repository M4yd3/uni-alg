package mirea.ru.marchenko.kvbo0121.lab7;

public class PriorityQueue {
    private final int[] heap;
    private int size;
    private final int maxSize;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return pos * 2 + 1;
    }

    private int rightChild(int pos) {
        return pos * 2 + 2;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int pos1, int pos2) {
        int tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos)) return;

        if (heap[pos] >= heap[leftChild(pos)] && heap[pos] >= heap[rightChild(pos)]) return;

        if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
            swap(pos, leftChild(pos));
            maxHeapify(leftChild(pos));
        } else {
            swap(pos, rightChild(pos));
            maxHeapify(rightChild(pos));
        }
    }

    public void insert(int element) {
        heap[size] = element;

        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }

        size++;
    }

    public int pull() {
        int popped = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return popped;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <= size; i++) {
            output.append(heap[i]).append(" ");
        }
        return output.toString();
    }

    public String printHeap() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < size / 2; i++) {
            output.append(" ".repeat(i / 2)).append("Parent: ").append(heap[i]).append("\n");
            if (leftChild(i) < size) {
                output.append(" ".repeat(i / 2 + 1)).append("Left child: ").append(heap[i * 2]).append("\n");
            }
            if (rightChild(i) < size) {
                output.append(" ".repeat(i / 2 + 1)).append("Right child: ").append(heap[i * 2 + 1]).append("\n");
            }
        }
        return output.toString();
    }
}
