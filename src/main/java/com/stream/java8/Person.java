package com.stream.java8;

public class Person {

    private Integer height;

    private City city;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public Person(Integer height, City city) {
        this.height = height;
        this.city = city;
    }


    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", city=" + city +
                '}';
    }
}
