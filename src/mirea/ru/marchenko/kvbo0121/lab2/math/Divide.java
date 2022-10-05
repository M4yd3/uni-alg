package mirea.ru.marchenko.kvbo0121.lab2.math;

public class Divide extends MathObject {

    public Divide(MathObject left, MathObject right) {
        super(left, right);
    }

    @Override
    public double evaluate(double variable) {
        return getLeft().evaluate(variable) / getRight().evaluate(variable);
    }
}
