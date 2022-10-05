package mirea.ru.marchenko.kvbo0121.lab2;

import mirea.ru.marchenko.kvbo0121.lab2.math.*;

public class Main {
    public static void main(String[] args) {
        double result = new Subtract(new Multiply(new Const(2), new Variable("x")), new Const(3)).evaluate(5);
        System.out.println(result);
        Variable x = new Variable("x");
        double result2 = new Add(new Subtract(new Multiply(x, x), new Multiply(new Const(2), x)), new Const(1)).evaluate(3);
        System.out.println(result2);
    }
}
