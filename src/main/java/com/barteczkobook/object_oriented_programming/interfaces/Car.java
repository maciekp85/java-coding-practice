package com.barteczkobook.object_oriented_programming.interfaces;

public class Car extends Vehicle {

    private String nrRej;
    private int tankCapacity;
    private int fuel;

    public Car(String nr, Person owner, int w, int h, int l, int weight, int tankCap) {
        super(owner, w, h, l, weight);
        nrRej = nr;
        tankCapacity = tankCap;
    }

    public String getNrRej() {
        return nrRej;
    }

    public Car fill(int amount) {
        fuel += amount;
        if(fuel > tankCapacity) fuel = tankCapacity;
        return this;
    }

    @Override
    public Car start() {
        if(fuel > 0) super.start();
        else {
            super.stop();
            error("No fuel");
        }
        return this;
    }

    @Override
    public Car stop() {
        super.stop();
        return this;
    }

    @Override
    public String toString() {
        return "Car with registration number " + nrRej + " - " + getState();
    }

}
