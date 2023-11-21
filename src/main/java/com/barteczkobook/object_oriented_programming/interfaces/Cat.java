package com.barteczkobook.object_oriented_programming.interfaces;

public class Cat extends Animal implements Moveable, Speakable {

    Cat(){}
    Cat(String s) {
        super(s);
    }

    public String getType() {
        return "Cat";
    }

    public String getVoice(int voice) {
        if(voice == LOUD)
            return "MIAUUUUU...";
        else
            return "miauuuuu...";
    }

    public Cat start() {
        System.out.println(getType() + " " + getName() + " sneaking");
        return this;
    }

    public Cat stop() {
        System.out.println(getType() + " " + getName() + " stopped");
        return this;
    }
}
