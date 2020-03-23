package ru.main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления " +
                "с двумя числами: a + b, a - b, a * b, a / b.\nВведите выражение:");

//        Чтение введённого выражения
        String expression = "";
        try {
            expression = ConsoleHelper.readString();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Разделение строки по пробелу
        String[] all = expression.split(" ");
//        Создание экземпляра класса калькулятор с переводом введённых операндов в арабские и int
        Calculator calculator = null;
        if (!Numbers.isRoman())
            calculator = new Calculator(Integer.parseInt(all[0]), Integer.parseInt(all[2]));
        if (Numbers.isRoman())
            calculator = new Calculator(Numbers.toArabic(all[0]), Numbers.toArabic(all[2]));

//        Вычисление
        calculator.setOperation(all[1].charAt(0));
        int result = calculator.perform();

//        Вывод результата в зависимости от вида цифр
        if (Numbers.isRoman()) {
            if (result > 0)
                ConsoleHelper.writeMessage("Ответ: " + Numbers.toRoman(result));
            else ConsoleHelper.writeMessage("Результат меньше 1 - невозможно отобразить римскими цифрами");
        }
        if (!Numbers.isRoman())
            ConsoleHelper.writeMessage("Ответ: " + result);
    }
}
