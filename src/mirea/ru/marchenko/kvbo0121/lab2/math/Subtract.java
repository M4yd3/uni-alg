package mirea.ru.marchenko.kvbo0121.lab2.math;

public class Subtract extends MathObject {
    public Subtract(MathObject left, MathObject right) {
        super(left, right);
    }

    @Override
    public double evaluate(double variable) {
        return left.evaluate(variable) - right.evaluate(variable);
    }
}
