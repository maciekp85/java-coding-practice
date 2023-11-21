package com.barteczkobook.object_oriented_programming.virtual_methods_and_polymorphism;

public class Cat extends Animal {

    Cat(){}
    Cat(String s) {
        super(s);
    }

    public String getType() {
        return "Cat";
    }

    public String getVoice() {
        return "Miauuuu...";
    }
}
