package mirea.ru.marchenko.kvbo0121.lab7;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(15);

        queue.insert(5);
        queue.insert(3);
        queue.insert(17);
        queue.insert(10);
        queue.insert(84);
        queue.insert(19);
        queue.insert(6);
        queue.insert(22);
        queue.insert(9);

        System.out.println("Queue: " + queue);
        System.out.println("\nQueue heap:\n" + queue.printHeap());

        for (int i = 0; i < 9; i++) {
            System.out.println("Max element: " + queue.pull());
        }

    }
}