package com.stream.java8;

import com.util.DateUtil;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamAPI3 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5, Employee.Status.BUSY)
    );

    //3. 终止操作
	/*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);

        System.out.println("----------------------------------------");

        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }

    //需求：搜索名字中 “六” 出现的次数
    @Test
    public void test2() {
        Optional<Integer> sum = emps.stream()
                .map(Employee::getName)
                .flatMap(TestStreamAPI1::filterCharacter)
                .map((ch) -> {
                    if (ch.equals('六'))
                        return 1;
                    else
                        return 0;
                }).reduce(Integer::sum);

        System.out.println(sum.get());
    }

    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test3() {
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);

        System.out.println("----------------------------------");
        // Collectors.toCollection() 返回放入HashSet
        HashSet<String> hs = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    @Test
    public void test4() {
        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));

        System.out.println("最大值：" + max.get());

        Optional<Employee> op = emps.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println("最小值：" + op.get());

        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println("求和：" + sum);

        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println("平均工资：" + avg);

        Long count = emps.stream()
                .collect(Collectors.counting());

        System.out.println("总数量：" + count);

        System.out.println("--------------------------------------------");

        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        // DoubleSummaryStatistics 包含最大值，最小值，平均值
        // Collectors.maxBy() 只能求最大值
        System.out.println("最大值：" + dss.getMax());
    }

    //分组
    @Test
    public void test5() {
        Map<Employee.Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(map);
    }

    //多级分组----按照状态分组后再按年龄分组
    @Test
    public void test6() {
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() >= 60)
                        return "老年";
                    else if (e.getAge() >= 35)
                        return "中年";
                    else
                        return "成年";
                })));

        System.out.println(map);
    }

    /**
     * 分区：
     * 分成>=5000的一个区，其他的一个区
     */
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

        System.out.println(map);
    }

    // joining连接，分隔符，前缀，后缀
    @Test
    public void test8() {
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "----", "----"));

        System.out.println(str);
    }

    @Test
    public void test9() {
        Optional<Double> sum = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(Double::sum));

        System.out.println(sum.get() + "-------------------");
    }


    /**
     * 求每个城市中最高的人
     */
    @Test
    public void test10() {

        List<Person> people = new ArrayList<>();

        City shanghai = new City();
        City beijing = new City();
        City hangzhou = new City();
        City shenzheng = new City();
        Person person1 = new Person(1, shanghai);
        Person person2 = new Person(2, shanghai);
        Person person3 = new Person(3, shanghai);
        Person person4 = new Person(1, beijing);
        Person person5 = new Person(2, beijing);
        Person person6 = new Person(3, beijing);
        Person person7 = new Person(1, hangzhou);
        Person person8 = new Person(2, hangzhou);
        Person person9 = new Person(3, hangzhou);
        Person person10 = new Person(1, shenzheng);
        Person person11 = new Person(2, shenzheng);
        Person person12 = new Person(3, shenzheng);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);
        people.add(person9);
        people.add(person10);
        people.add(person11);
        people.add(person12);

        Comparator<Person> byHeight = Comparator.comparing(Person::getHeight);

        Map<City, Optional<Person>> collect = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(BinaryOperator.maxBy(byHeight))));
        Set<City> cities = collect.keySet();
        cities.forEach((e) -> {
            Optional<Person> r = collect.get(e);
            System.out.println(r.get());
        });
    }

    @Test
    public void test11() {
        //先按日期从小到大排序，再按功率从大到小，之后放入集合中过滤重复，返回List
//        emps.stream().sorted(Comparator.comparing(GraphResult::getDate)
//                .thenComparing((o1, o2) -> Integer.compare(o2.getPv1Power(), o1.getPv1Power()))
//                .thenComparing((o1, o2) -> Integer.compare(o2.getPv2Power(), o1.getPv2Power())))
//                .collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
//                        new TreeSet<>(Comparator.comparing(GraphResult::getDate))), ArrayList::new));//过滤重复时间点
    }

    @Test
    public void test12(){
        // 将List<Employee>中的Date转换为 List<sting>
        List<String> collect = emps.stream().map(Employee::getTime).map(item -> DateUtil.getDate2String(item, DateUtil.yyyy_MM_dd_HH_mm_ss)).collect(Collectors.toList());

    }
}
