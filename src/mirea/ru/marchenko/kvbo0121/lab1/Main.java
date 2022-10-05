package mirea.ru.marchenko.kvbo0121.lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Calculator calculator = new Calculator();

        final Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Input equation separated by spaces [enter \"q/Q\" to exit]: ");
            final String input = in.nextLine();

            if (input.toLowerCase().trim().equals("q")) break;

            try {
                System.out.println(calculator.calculate(input));
            } catch (RuntimeException exception) {
                if (exception instanceof IllegalOperandException) {
                    System.out.println("Invalid operand");
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }
}
