package com.barteczkobook.object_oriented_programming.abstract_methods_and_classes;

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
