package com.barteczkobook.object_oriented_programming.interfaces;

public class Person {
    private String name;
    private String pesel;

    Person(String name, String id) {
        this.name = name;
        this.pesel = id;
    }

    public String getName() {
        return this.name;
    }

    public String getPesel() {
        return this.pesel;
    }
}
