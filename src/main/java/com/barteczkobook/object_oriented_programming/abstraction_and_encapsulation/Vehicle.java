package com.barteczkobook.object_oriented_programming.abstraction_and_encapsulation;
import com.barteczkobook.object_oriented_programming.abstraction_and_encapsulation.hermet.VehState;

public class Vehicle {
    private int width;
    private int height;
    private int length;
    private int weight;
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
        this.state = VehState.STOPPED;
    }

    public void start() {
        this.setState(VehState.MOVING);
    }

    public void stop() {
        this.setState(VehState.STOPPED);
    }

    public void repair() {
        if(this.state != VehState.BROKEN) {
            this.error("Nie można reperować sprawnego pojazdu");
        } else {
            this.state = VehState.STOPPED;
        }

    }

    public VehState getState() {
        return this.state;
    }

    public void sellTo(Person p) {
        this.owner = p;
    }

    public void crash(Vehicle v) {
        if(this.state != VehState.MOVING && v.state != VehState.MOVING) {
            this.error("Żaden z pojazdów nie jest w ruchu - nie ma zdarzenia");
        }

        this.state = VehState.BROKEN;
        v.state = VehState.BROKEN;
    }

    public String toString() {
        String s = this.owner == null?"sklep":this.owner.getName();
        return "Pojazd, właścicielem którego jest " + s + " jest w stanie " + this.state;
    }

    private void setState(VehState newState) {
        if(this.state == VehState.BROKEN) {
            this.error("Nie jest możliwe przejście ze stanu " + this.state + " do stanu " + newState);
        } else {
            this.state = newState;
        }

    }

    protected void error(String msg) {
        throw new IllegalArgumentException(msg);
    }
}
