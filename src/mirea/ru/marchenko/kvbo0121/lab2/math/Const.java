package mirea.ru.marchenko.kvbo0121.lab2.math;

public class Const extends MathObject {
    private final double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(double variable) {
        return value;
    }
}
