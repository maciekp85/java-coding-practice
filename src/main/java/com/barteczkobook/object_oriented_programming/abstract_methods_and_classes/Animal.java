package com.barteczkobook.object_oriented_programming.abstract_methods_and_classes;

abstract class Animal {

    private String name = "without name";

    Animal(){}
    Animal(String name) {
        this.name = name;
    }

    abstract String getType();

    abstract String getVoice();

    public String getName() {
        return name;
    }


    /**
     * Speak method simulate animal voice by typing proper message
     */
    public String speak() {
        return getType() + " " + getName() + " speaks " + getVoice();
    }
}
