package mirea.ru.marchenko.kvbo0121.lab2.math;

public abstract class MathObject {
    protected MathObject left;
    protected MathObject right;

    public MathObject(MathObject left, MathObject right) {
        this.left = left;
        this.right = right;
    }

    MathObject() {
    }

    abstract double evaluate(double variable);
}
