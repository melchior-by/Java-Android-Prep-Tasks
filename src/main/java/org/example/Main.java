package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Написать программу со следующим функционалом:
 * На вход передать строку (будем считать, что это номер документа).
 * Номер документа имеет формат xxxx-yyy-xxxx-yyy-xyxy, где x — это число,
 * а y — это буква.
 * - Вывести на экран в одну строку два первых блока по 4 цифры.
 * - Вывести на экран номер документа, но блоки из трех букв заменить
 * на *** (каждая буква заменятся на *).
 * - Вывести на экран только одни буквы из номера документа в формате
 * yyy/yyy/y/y в нижнем регистре.
 */
public class Main {
    static String s = "1234-abc-1234-yyy-5y6y";
    static String delimeter =  s.substring(4, 5);
    public static void main(String[] args) {
        System.out.println(getNumbers());
        System.out.println(getReplaced());
        getLetters();
    }

    private static String getNumbers() {
        String[] strings = s.split(delimeter);
        return strings[0] + strings[2];
    }

    private static String getReplaced() {
        String[] strings = s.split(delimeter);
        for (int i = 1; i < strings.length; i+=2) {
            strings[i] = "***";
        }
        return String.join(delimeter,strings);
    }

    private static void getLetters() {
        char[] charsInput = s.toCharArray();
        List<Character> out = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < charsInput.length; i++) {
            if(!(charsInput[i]>=0 || charsInput[i]<=9)) {
                out.add(charsInput[i]);
            }
        }
        int i;
    }

    private static void getLetters2() {
        String[] strings = s.split(delimeter);
        for (int i = 1; i < strings.length; i+=2) {

        }
    }
}