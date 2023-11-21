package com.barteczkobook.object_oriented_programming.abstract_methods_and_classes;

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
