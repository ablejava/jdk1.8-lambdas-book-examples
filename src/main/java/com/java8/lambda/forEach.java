package com.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class forEach {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        /**
         * 循环集合
         */
        integerList.forEach(k -> {
            System.out.println(k+1);
        });
    }

}
