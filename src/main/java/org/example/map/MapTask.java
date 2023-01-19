package org.example.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. Напишите метод, который получает на вход Map<K, V> и возвращает Map, где ключи и значения поменяны местами.
 * Так как значения могут совпадать, то тип значения в Map будет уже не K, а Collection<K> (Map<V, Collection<K>>)
 * 2. Напишите методы union(Set<?>... set) и intersect(Set<?> ... set), реализующих операции объединения и
 * пересечения множеств соотвествующе.
 */
public class MapTask {

    public static void main(String[] args) {
        Set<String> s1 = Set.of("XML", "Json", "Java");
        Set<String> s2 = Set.of("Python", "Ruby", "Json");
        System.out.println(customUnion(s1, s2));
        System.out.println(customIntersection(s1, s2));
    }

    public static <V, K> Map<V, K> invertMapUsingForLoop(Map<K, V> map) {
        Map<V, K> inversedMap = new HashMap<V, K>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            inversedMap.put(entry.getValue(), entry.getKey());
        }
        return inversedMap;
    }

    private static <V, K> Map<V, List<K>> invertMapUsingGroupingBy(Map<K, V> map) {
        Map<V, List<K>> inversedMap = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        return inversedMap;
    }

    public static <T> Set<T> customUnion(Set<T> s1, Set<T> s2) {
        Set<T> union = new HashSet<>(s1);
        union.addAll(s2);
        return union;
    }

    public static <T> Set<T> customIntersection(Set<T> s1, Set<T> s2) {
        Set<T> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        return intersection;
    }

    public static <T> Set<T> customUnionStreamAPI(Set<T> s1, Set<T> s2) {
        return Stream.concat(s1.stream(), s2.stream()).collect(Collectors.toSet());
    }

    public static <T> Set<T> customIntersectionStreamAPI(Set<T> s1, Set<T> s2) {
        return s1.stream().filter(s2::contains).collect(Collectors.toSet());
    }
}
