package mirea.ru.marchenko.kvbo0121.lab2.math;

public abstract class MathObject {
    private MathObject left;
    private MathObject right;

    public MathObject(MathObject left, MathObject right) {
        this.left = left;
        this.right = right;
    }

    public MathObject() {
    }

    abstract public double evaluate(double variable);

    public MathObject getLeft() {
        return left;
    }

    public MathObject getRight() {
        return right;
    }
}
