package com.barteczkobook.object_oriented_programming.virtual_methods_and_polymorphism;

public class Dog extends Animal {

    Dog() {}
    Dog(String s) {
        super(s);
    }

    public String getType() {
        return "Dog";
    }

    public String getVoice() {
        return "HAU, HAU!";
    }
}
