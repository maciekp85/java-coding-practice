package com.barteczkobook.object_oriented_programming.abstraction_and_encapsulation.hermet;

public enum VehState {
    BROKEN("ZEPSUTY"),
    STOPPED("STOI"),
    MOVING("JEDZIE");

    private String description;

    VehState(String s) {
        description = s;
    }

    @Override
    public String toString() {
        return description;
    }
}
