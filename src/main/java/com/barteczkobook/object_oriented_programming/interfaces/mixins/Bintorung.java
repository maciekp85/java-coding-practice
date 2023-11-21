package com.barteczkobook.object_oriented_programming.interfaces.mixins;

public class Bintorung implements Bear, Cat {

    private String name;

    public Bintorung(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "My name is " + name + " and I am Bintorung, or " + bear() + cat();
    }
}
