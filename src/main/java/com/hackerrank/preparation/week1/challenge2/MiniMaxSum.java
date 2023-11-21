package com.hackerrank.preparation.week1.challenge2;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

// Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly
// four of the five integers.Then print the respective minimum and maximum values as a single line of two
// space-separated long integers.
// Example
// arr = [1,3,5,7,9]
// The minimum sum is 1+3+5+7=16 and the maximum sum is 3+5+7+9=24. The function prints 16 24

// Sample input: 1 2 3 4 5
// Sample output: 10 14
class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int elementsNumber = arr.size();
        long [] longArray = new long[elementsNumber];
        long sumValue = 0;
        int value = 0;

        int arrayIndex = 0;

        while(arrayIndex < elementsNumber) {
            for (int i=0; i < elementsNumber; i++) {
                value = arr.get(i);

                if(i == arrayIndex) {
                    continue;
                }
                sumValue += value;
            }

            longArray[arrayIndex] = sumValue;
            sumValue = 0;
            arrayIndex++;
        }
        Arrays.sort(longArray);
        System.out.print(longArray[0] + " " + longArray[elementsNumber-1]);
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
