package com.enumUse;

import static org.junit.Assert.assertTrue;

/**
 * @Author: xiazhongwei
 * @Date: 2021/10/27 20:54
 */
public class PizaOrder_whenReady_thenDeliverable {

    /**
     * 枚举实现策略模式
     * @param args
     */
    public static void main(String[] args) {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        pz.deliver();
        System.out.println(pz.getStatus() == Pizza.PizzaStatus.DELIVERED);
//        assertTrue();

    }
}
