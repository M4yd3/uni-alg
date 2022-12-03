package mirea.ru.marchenko.kvbo0121.lab9;

class BinarySearchTree {
    Node root;
    int count = 0;

    public void insert(int value) {
        insert(value, root);
    }

    private void insert(int value, Node node) {
        if (root == null) {
            root = new Node(value);
            count++;
            return;
        }

        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
                count++;
            } else {
                insert(value, node.left);
            }
            return;
        }

        if (node.value < value) {
            if (node.right == null) {
                node.right = new Node(value);
                count++;
            } else {
                insert(value, node.right);
            }
        }
    }

    public void delete(int value) {
        root = delete(value, root);
    }

    private Node delete(int value, Node node) {
        if (node == null) return null;

        if (node.value == value) {
            if (node.left == null) return node.right;

            if (node.right == null) return node.left;

            node.value = minValue(node.right);

            node.right = delete(node.value, node.right);
        }

        if (node.value > value) node.left = delete(value, node.left);

        if (node.value < value) node.right = delete(value, node.right);

        return node;
    }

    public int minValue() {
        return minValue(root);
    }

    private int minValue(Node node) {
        int min = node.value;
        while (node.left != null) {
            min = node.left.value;
            node = node.left;
        }
        return min;
    }

    public int maxValue() {
        return maxValue(root);
    }

    private int maxValue(Node node) {
        int min = node.value;
        while (node.right != null) {
            min = node.right.value;
            node = node.right;
        }
        return min;
    }

    public boolean contains(int value) {
        return contains(value, root);
    }

    private boolean contains(int value, Node node) {
        if (node == null) return false;

        if (node.value == value) return true;

        if (node.value > value) return contains(value, node.left);

        return contains(value, node.right);
    }

    public void print() {
        print(root, 0);
    }

    private void print(Node node, int depth) {
        if (node == null) return;

        print(node.left, depth + 1);
        System.out.println("\t".repeat(depth) + node.value);
        print(node.right, depth + 1);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
