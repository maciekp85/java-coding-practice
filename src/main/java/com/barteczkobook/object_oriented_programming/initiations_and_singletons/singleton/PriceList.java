package com.barteczkobook.object_oriented_programming.initiations_and_singletons.singleton;

import java.util.HashMap;

public final class PriceList extends HashMap<String, Double> {

    public static final PriceList INSTANCE = new PriceList();

    private PriceList() {};
}
