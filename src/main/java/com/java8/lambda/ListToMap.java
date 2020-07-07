package com.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(v -> v.hashCode(), v -> v));

        collect.forEach((k, v) -> {
            System.out.println(k +":" + v);
        });
    }
}
