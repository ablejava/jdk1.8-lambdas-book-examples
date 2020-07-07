package com.java8.lambda;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {

        // 没有返回值
        Consumer<Integer> consumer = x -> System.out.println(x);
        Consumer<Integer> consumer2 = x -> System.out.println(x+1);

        consumer.andThen(consumer2).accept(10);
    }
}
