package com.barteczkobook.object_oriented_programming.initiations_and_singletons;

public class Person {
    private String name;
    private String pesel;

    Person(String aname, String id) {
        this.name = aname;
        this.pesel = id;
    }

    public String getName() {
        return this.name;
    }

    public String getPesel() {
        return this.pesel;
    }
}
