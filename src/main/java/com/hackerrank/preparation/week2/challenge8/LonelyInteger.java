package com.hackerrank.preparation.week2.challenge8;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/*
Given an array of integers, where all elements but one occur twice, find the unique element
a = [1,2,3,4,3,2,1]
The unique element is 4.

Input:
The first line contains a single integer, n , the number of integers in the array.
The second line contains  space-separated integers that describe the values in .
6
1,2,3,4,3,2,1

Output:
4           int: the element that occurs only once

Constraints:
It is guaranteed that  is an odd number and that there is one unique element.

 */
class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        int frequencyOfOccurence = 0;
        int number = -1;
        Collections.sort(a);

        for (int i=0; i<a.size(); i++) {
            number = a.get(i);
            if (a.size() == 1) {
                return number;
            }

            for (int j=0; j<a.size(); j++) {
                if (number == a.get(j)) {
                    frequencyOfOccurence++;
                }
            }

            if (frequencyOfOccurence%2 != 0) {
                return number;
            }

            frequencyOfOccurence = 0;
        }

        return number;
    }

}

public class LonelyInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
