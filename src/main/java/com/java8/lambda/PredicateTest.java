package com.java8.lambda;

import java.util.function.Predicate;

public class PredicateTest {

    /**
     * boolean判断
     * @param args
     */
    public static void main(String[] args) {
        Predicate<Integer> bo = t -> t>5;
        Predicate<Integer> bo2 = t -> t>4;
        boolean test = bo.test(7);
        boolean test1 = bo.or(bo2).test(5);
        System.out.println(test1);
    }

}
