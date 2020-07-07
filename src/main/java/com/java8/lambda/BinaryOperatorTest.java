package com.java8.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperator<Integer> add = (x, y) -> x+y;
        Integer apply = add.apply(3, 4);
        System.out.println(apply);

        Function<Integer, Integer> sum = x ->x+1;
        Integer apply1 = add.andThen(sum).apply(3, 4);
        System.out.println(apply1);


    }
}
