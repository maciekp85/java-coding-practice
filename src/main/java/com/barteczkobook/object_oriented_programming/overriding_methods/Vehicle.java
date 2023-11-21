package com.barteczkobook.object_oriented_programming.overriding_methods;

import com.barteczkobook.object_oriented_programming.abstraction_and_encapsulation.hermet.VehState;

public class Vehicle {
    private int width;
    private int height;
    private int length;
    private int weight;
    private static int initNr;
    private int currNr = ++initNr;
    private Person owner;
    private VehState state;

    Vehicle(int w, int h, int l, int ww) {
        this(null, w, h, l, ww);
    }

    Vehicle(Person p, int w, int h, int l, int ww) {
        this.owner = p;
        this.width = w;
        this.height = h;
        this.length = l;
        this.weight = ww;
    }

    public Vehicle start() {
        this.setState(VehState.MOVING);
        return this;
    }

    public Vehicle stop() {
        this.setState(VehState.STOPPED);
        return this;
    }

    public Vehicle repair() {
        if(this.state != VehState.BROKEN) {
            this.error("You can not repair capable vehicle");
        } else {
            this.state = VehState.STOPPED;
        }
        return this;

    }

    public VehState getState() {
        return this.state;
    }

    public int getCurrNr() {
        return currNr;
    }

    public void sellTo(Person p) {
        this.owner = p;
    }

    public Vehicle crash(Vehicle v) {
        if(this.state != VehState.MOVING && v.state != VehState.MOVING) {
            this.error("No vehicles drives - no events");
        }

        this.state = VehState.BROKEN;
        v.state = VehState.BROKEN;

        return this;
    }

    @Override
    public String toString() {
        String s = this.owner == null?"shop":this.owner.getName();
        return "Vehicle whose owner is " + s + " is able to " + this.state;
    }

    private void setState(VehState newState) {
        if(this.state == VehState.BROKEN) {
            this.error("Yo can not move from state " + this.state + " to state " + newState);
        } else {
            this.state = newState;
        }

    }

    protected void error(String msg) {
        throw new IllegalArgumentException(msg);
    }
}
