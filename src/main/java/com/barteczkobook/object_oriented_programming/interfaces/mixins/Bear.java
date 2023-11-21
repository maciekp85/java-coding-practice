package com.barteczkobook.object_oriented_programming.interfaces.mixins;

public interface Bear {

    default String bear() {
        return "Bear";
    }
}
