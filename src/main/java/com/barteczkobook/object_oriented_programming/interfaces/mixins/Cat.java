package com.barteczkobook.object_oriented_programming.interfaces.mixins;

public interface Cat {

    default String cat() {
        return "Cat";
    }
}
