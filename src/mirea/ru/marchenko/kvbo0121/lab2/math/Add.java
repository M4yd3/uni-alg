package mirea.ru.marchenko.kvbo0121.lab2.math;

public class Add extends MathObject {

    public Add(MathObject left, MathObject right) {
        super(left, right);
    }

    @Override
    public double evaluate(double variable) {
        return getLeft().evaluate(variable) + getRight().evaluate(variable);
    }
}
