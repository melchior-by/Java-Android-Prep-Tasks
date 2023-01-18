package org.example;

/**
 * - Вывести на экран буквы из номера документа в формате
 * "Letters:yyy/yyy/y/y" в верхнем регистре(реализовать с помощью
 * класса StringBuilder).
 * - Проверить содержит ли номер документа последовательность abc и
 * вывети сообщение содержит или нет(причем, abc и ABC считается
 * одинаковой последовательностью).
 * - Проверить начинается ли номер документа с последовательности
 * 555.
 * - Проверить заканчивается ли номер документа на
 * последовательность 1a2b.
 * Все эти методы реализовать в отдельном классе в статических методах,
 * которые на вход (входным параметром) будут принимать вводимую на вход
 * программы строку.
 */
public class Main2 {
    private static String s = "yyy/abc/y/y";
    static String s_n = "1234-abc-1234-yyy-5y6y";

    public static void main(String[] args) {
        System.out.println(upReg());
        System.out.println(check("abc"));
        System.out.println(s_n.split("-")[0].equalsIgnoreCase("1234"));
        System.out.println(s_n.split("-")[s_n.split("-").length - 1].equalsIgnoreCase("5y6y"));
    }

    public static String upReg() {
        StringBuilder sb = new StringBuilder();
        sb.append("Letters:");
        sb.append(s);
        return sb.toString().toUpperCase();
    }

    public static boolean check(String pattern) {
        return s_n.toUpperCase().contains(pattern.toUpperCase());
    }

}
