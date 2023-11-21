package com.barteczkobook.object_oriented_programming.interfaces;

public class Bicycle extends Vehicle {

    public Bicycle(Person owner, int w, int h, int l, int weight){
        super(owner, w, h, l, weight);
    }

    @Override
    public Bicycle start() {
        super.start();
        return this;
    }

    @Override
    public Bicycle stop() {
        super.stop();
        return this;
    }

}
