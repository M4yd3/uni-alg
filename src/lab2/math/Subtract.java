package lab2.math;

public class Subtract extends MathObject {
    public Subtract(MathObject left, MathObject right) {
        super(left, right);
    }

    @Override
    public double evaluate(double variable) {
        return getLeft().evaluate(variable) - getRight().evaluate(variable);
    }
}
