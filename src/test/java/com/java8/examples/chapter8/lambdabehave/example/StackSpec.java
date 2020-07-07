package com.java8.examples.chapter8.lambdabehave.example;

import com.java8.examples.chapter8.lambdabehave.Lets;

import java.util.Stack;

// BEGIN StackSpec
public class StackSpec {{

    Lets.describe("a stack", it -> {

        it.should("be empty when created", expect -> {
            expect.that(new Stack()).isEmpty();
        });

        it.should("push new elements onto the top of the stack", expect -> {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);

            expect.that(stack.get(0)).isEqualTo(1);
        });

        it.should("pop the last element pushed onto the stack", expect -> {
            Stack<Integer> stack = new Stack<>();
            stack.push(2);
            stack.push(1);

            expect.that(stack.pop()).isEqualTo(2);
        });
        
    });

}}
// END StackSpec
