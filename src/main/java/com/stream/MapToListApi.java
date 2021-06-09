package com.stream;

import com.stream.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapToListApi {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.55, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.66, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );

    @Test
    public void mapToList() {
        Map<String, Employee> employeeMap1 = emps.stream().collect(Collectors.toMap(Employee::getName, Function.identity(), (k1, k2) -> k1));
        System.out.println(employeeMap1);
        Map<String, Employee> employeeMap = emps.stream().collect(Collectors.toMap(Employee::getName, Function.identity(), (k1, k2) -> k2));
        System.out.println(employeeMap);
    }

    /**
     * 希望得到的mp的值不是对象，而是对象的某个属性
     */
    @Test
    public void mapToFieldList() {
        Map<String, Double> collect = emps.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary, (k1, k2) -> k1));
        System.out.println(collect);
    }


}
