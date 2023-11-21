package com.barteczkobook.object_oriented_programming.initiations_and_singletons.initiation_static_block;

import com.barteczkobook.object_oriented_programming.abstraction_and_encapsulation.hermet.VehState;

import java.util.Locale;

public class Vehicle {
    private int width;
    private int height;
    private int length;
    private int weight;
    private static int initNr;
    private Person owner;
    private VehState state;

    // Static initial block
    // using it we initialize initNr variable in way that vehicles numbers start in depend on default localization of application
    // for example: of an application is executed with italian localization, numbers start from 10000.

    static {
        Locale [] loc = { Locale.UK, Locale.US, Locale.JAPAN, Locale.ITALY};
        int [] begNr = {1, 100, 1000, 10000};
        initNr = 200;   // if an application works in other from among mentioned into geo localization array, numbers start from 200
        Locale defLoc = Locale.getDefault();    // what is default localization?
        for(int i=0; i<loc.length; i++) {
            if(defLoc.equals(loc[i])) {
                initNr = begNr[i];
                break;
            }
        }
    } // end of block

    private int currNr = initNr;

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

    public void start() {
        this.setState(VehState.MOVING);
    }

    public void stop() {
        this.setState(VehState.STOPPED);
    }

    public void repair() {
        if(this.state != VehState.BROKEN) {
            this.error("You can not repair capable vehicle");
        } else {
            this.state = VehState.STOPPED;
        }

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

    public void crash(Vehicle v) {
        if(this.state != VehState.MOVING && v.state != VehState.MOVING) {
            this.error("No vehicles drives - no events");
        }

        this.state = VehState.BROKEN;
        v.state = VehState.BROKEN;
    }

    public String toString() {
        String s = this.owner == null?"sklep":this.owner.getName();
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
