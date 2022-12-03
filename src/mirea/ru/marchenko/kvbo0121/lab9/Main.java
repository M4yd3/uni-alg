package mirea.ru.marchenko.kvbo0121.lab9;

class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);

        System.out.println(tree.contains(5));

        tree.print();

        tree.delete(4);

        System.out.println();
        tree.print();
    }
}
