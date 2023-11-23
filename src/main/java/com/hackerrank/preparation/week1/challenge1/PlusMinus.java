package com.hackerrank.preparation.week1.challenge1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/*
Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
Print the decimal value of each fraction on a new line with  places after the decimal.

Sample input:               Function:
6                           arr[] size n=6
-4 3 -9 0 4 1               arr = [-4, 3, -9, 0, 4, 1]

Sample output:
0.500000
0.333333
0.166667
*/
class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int size = arr.size();
        float positive = 0, negative = 0, zero = 0;
        for(Integer i: arr) {
            if(i < 0) {
                negative++;
            } else if (i > 0) {
                positive++;
            } else {
                zero++;
            }
        }

        float positiveRatio = positive/size;
        float negativeRatio = negative/size;
        float zeroRatio = zero/size;

        Formatter fmt = new Formatter();

        fmt.format("%.6f\n%.6f\n%.6f", positiveRatio, negativeRatio, zeroRatio);
        System.out.println(fmt);
        fmt.close();
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
