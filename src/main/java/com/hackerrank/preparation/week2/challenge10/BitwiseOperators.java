package com.hackerrank.preparation.week2.challenge10;

public class BitwiseOperators {

    public static void main(String[] args) {
        int number10RadixFirst = 2147483647;
        int number10RadixSecond = 1;

        System.out.println("You will be given a list of 32 bit unsigned integers. Flip all the bits (1 -> 0 and 0 -> 1) and return the result as an unsigned integer.");

        System.out.println("1) 32 bit unsigned number: " + number10RadixFirst + ", Binary: " + String.format("%32s", Integer.toBinaryString(number10RadixFirst)).replaceAll(" ", "0"));
        System.out.println("2) 32 bit unsigned number: " + number10RadixSecond + ", Binary: " + String.format("%32s", Integer.toBinaryString(number10RadixSecond)).replaceAll(" ", "0"));

        int flippedNumber10RadixFirst = ~number10RadixFirst;    // bitwise unary NOT
        int flippedNumber10RadixSecond = ~number10RadixSecond;   // bitwise unary NOT

        System.out.println();
        System.out.println("1) Number after flipping (1 -> 0 and 0 -> 1): " + flippedNumber10RadixFirst + ", Binary: " + String.format("%32s", Integer.toBinaryString(flippedNumber10RadixFirst)).replaceAll(" ", "0"));
        System.out.println("2) Number after flipping (1 -> 0 and 0 -> 1): " + flippedNumber10RadixSecond + ", Binary: " + String.format("%32s", Integer.toBinaryString(flippedNumber10RadixSecond)).replaceAll(" ", "0"));

        String unsignedNumber10RadixFirst = Integer.toUnsignedString(flippedNumber10RadixFirst);
        String unsignedNumber10RadixSecond = Integer.toUnsignedString(flippedNumber10RadixSecond);

        long unsignedLongNumber10RadixFirst = Long.parseUnsignedLong(unsignedNumber10RadixFirst);
        long unsignedLongNumber10RadixSecond = Long.parseUnsignedLong(unsignedNumber10RadixSecond);

        System.out.println();
        System.out.println("1) Unsigned decimal integer: " + unsignedLongNumber10RadixFirst);
        System.out.println("2) Unsigned decimal integer: " + unsignedLongNumber10RadixSecond);
    }
}
