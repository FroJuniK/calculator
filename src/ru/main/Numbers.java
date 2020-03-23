package ru.main;

public class Numbers {
    private static int[] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] letters = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static boolean roman = false;

    public static boolean isRoman() {
        return roman;
    }

    public static void setRoman(boolean roman) {
        Numbers.roman = roman;
    }

    public static int toArabic(String roman) {
        int arabic = 0;
        String N = roman;
        for (int i = 0; i < letters.length; i++) {
            while (N.indexOf(letters[i]) == 0) {
                arabic += numbers[i];
                N = N.replaceFirst(letters[i], "");
            }
        }
        return arabic;
    }

    public static String toRoman(int arabic) {
        String roman = "";
        int N = arabic;
        for (int i = 0; i < numbers.length; i++) {
            while (N >= numbers[i]) {
                roman += letters[i];
                N -= numbers[i];
            }
        }
        return roman;
    }
}
