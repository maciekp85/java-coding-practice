package com.barteczkobook.object_oriented_programming.initiations_and_singletons.initiation_static_block;

public class InitOrder {

    private static InitOrder initOrder = new InitOrder();
    private static final int s = 100;
    private static final int C;

    static {
        C = 101;
        report("Static initial block, s, C = ", s, C);

    }

    private int a = 1;

    InitOrder() {
        report("Constructor: s, C, a, b have values: ", s, C, a, b);
    }

    private int b = 2;

    {
        report("Initial block, s, C, a, b = ", s, C, a, b);
    }



    private static void report(String msg, int ...args) {
        System.out.println(msg + " ");
        for (int i : args) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static void main(String [] args) {
        report("Calling main method:");
        new InitOrder();
    }

}
