package ru.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String input = buffReader.readLine();

//        Регулярные выражения для проверки введённой строки
        boolean arabicNum = input.matches("^\\d{1,2}\\s{1}[\\+,\\-,\\*,\\/]{1}\\s{1}\\d{1,2}$");
        boolean romanNum = input.matches("^[IVX]{1,4}\\s{1}[\\+,\\-,\\*,\\/]{1}\\s{1}[IVX]{1,4}$");

//        Установка флага римские/арабские
        if (!arabicNum && !romanNum)
            throw new NumberFormatException("Строка введена неверно!");
        if (arabicNum && !romanNum)
            Numbers.setRoman(false);
        if (!arabicNum && romanNum)
            Numbers.setRoman(true);

        return input;
    }
}
