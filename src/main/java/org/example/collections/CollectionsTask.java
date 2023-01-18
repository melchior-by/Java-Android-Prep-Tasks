package org.example.collections;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * 1. Напишите метод, который заполняет рандомными значениями (1_000_000 раз) коллекции ArrayList и LinkedList.
 * Напишите еще один метод, который выбирает из заполненного списка элемент наугад 100_000 раз.
 * Замерьте время, которое потрачено на это. Сравните результаты и сделайте выводы 🙂
 * (Время поможет замерить System.nanoseconds() метод)
 * <br><br>
 * 2. Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.
 */
public class CollectionsTask {
    private static final int N1 = 1_000_000;
    private static final int N2 = 100_000;
    private static List<Integer> generateRandomArrayList(int n) {
        List<Integer> list = new ArrayList<>(n);
        generateRandom(list, n);
        return list;
    }

    private static List<Integer> generateRandomLinkedList(int n) {
        List<Integer> list = new LinkedList<>();
        generateRandom(list, n);
        return list;
    }

    private static void generateRandom(List<Integer> list, int n) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            Integer r = rand.nextInt() % 256;
            list.add(r);
        }
    }

    private static void getRandom(List<Integer> list, int n) {
        int rand;
        for (int i = 0; i < n; i++) {
            rand = ThreadLocalRandom.current().nextInt(0, n);
            list.get(rand);
        }
    }

    private static Set<Integer> deleteDuplicatesByUsingSet(List<Integer> list) {
        return new LinkedHashSet<>(list);
    }

    private static List<Integer> deleteDuplicatesByStreamAPI(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<Integer> arrayList = generateRandomArrayList(N1);
        long duration = System.nanoTime() - startTime;
        System.out.println("ArrayList generate: " + duration);

        startTime = System.nanoTime();
        List<Integer> linkedList = generateRandomLinkedList(N1);
        duration = System.nanoTime() - startTime;
        System.out.println("LinkedList generate: " + duration);

        startTime = System.nanoTime();
        getRandom(arrayList, N2);
        duration = System.nanoTime() - startTime;
        System.out.println("ArrayList get: " + duration);

        startTime = System.nanoTime();
        getRandom(linkedList, N2);
        duration = System.nanoTime() - startTime;
        System.out.println("LinkedList get: " + duration);

    }
}
