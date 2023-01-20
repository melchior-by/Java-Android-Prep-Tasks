package org.example.generics;

import java.io.Serializable;

/**
 * 3. (Дополнительно не generic'и)
 * Создать обобщенный класс с тремя параметрами (T, V, K).
 * Класс содержит три переменные типа (T, V, K), конструктор, принимающий на вход параметры типа (T, V, K), методы
 * возвращающие значения трех переменных. Создать метод, выводящий на консоль имена классов для трех переменных класса.
 * Наложить ограничения на параметры типа: T должен реализовать интерфейс Comparable (классы оболочки, String),
 * V должен реализовать интерфейс Serializable и расширять класс Animal, K должен расширять класс Number.
 */
public class GenericTask<T extends Comparable<String>,
        V extends Animal & Serializable,
        K extends Number> {
    T type;
    V value;
    K key;

    public GenericTask(T type, V value, K key) {
        this.type = type;
        this.value = value;
        this.key = key;
    }

    public T getType() {
        return type;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public void printNames() {
        System.out.printf("T: %s, V:%s, K:%s\n",
                type.getClass().getName(),
                value.getClass().getName(),
                key.getClass().getName());
    }
}
