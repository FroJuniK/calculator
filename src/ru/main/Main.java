package ru.main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления " +
                "с двумя числами: a + b, a - b, a * b, a / b.\nВведите выражение:\n");
        String expression = "";
        try {
            expression = ConsoleHelper.readString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] all = expression.split(" ");
        Calculator calculator = null;
        boolean roman = false;
        if (all[3].equals("arabic")) {
            calculator = new Calculator(Integer.parseInt(all[0]), Integer.parseInt(all[2]));
            roman = false;
        }

        if (all[3].equals("roman")) {
            calculator = new Calculator(Numbers.toArabic(all[0]), Numbers.toArabic(all[2]));
            roman = true;
        }

        calculator.setOperation(all[1].charAt(0));
        int result = calculator.perform();

        if (roman) {
            if (result > 0)
                ConsoleHelper.writeMessage("Ответ: " + Numbers.toRoman(result));
            else ConsoleHelper.writeMessage("Результат меньше 1 - невозможно отобразить римскими цифрами");
        }
        if (!roman) {
            ConsoleHelper.writeMessage("Ответ: " + result);
        }

    }
}
