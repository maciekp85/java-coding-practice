package com.barteczkobook.object_oriented_programming.interfaces;

public class Dog extends Animal implements Speakable, Moveable {

    Dog() {}
    Dog(String s) {
        super(s);
    }

    public String getType() {
        return "Dog";
    }

    public String getVoice(int voice) {
        if(voice == LOUD)
            return "HAU... HAU... HAU...";
        else
            return "hau... hau...";
    }

    public Dog start() {
        System.out.println("Dog " + getName() + " moving");
        return this;
    }

    public Dog stop() {
        System.out.println("Dog " + getName() + " stopped");
        return this;
    }
}
