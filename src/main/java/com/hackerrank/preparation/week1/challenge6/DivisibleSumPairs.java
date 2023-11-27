package com.hackerrank.preparation.week1.challenge6;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


/*
Given an array of integers and a positive integer k, determine the number of (i, j) pairs where i < j
and ar[i] + ar[k] is divisible by k.

divisibleSumPairs has the following parameter(s):

int n: the length of array
int ar[n]: an array of integers
int k: the integer divisor

Input format:
STDIN           Function
-----           --------
6 3             n = 6, k = 3
1 3 2 6 1 2     ar = [1, 3, 2, 6, 1, 2]

Output format:
5

Explanation:
Here are the 5 valid pairs when k = 3:
(0,2) -> ar[0] + ar[2] = 1 + 2 = 3
(0,5) -> ar[0] + ar[5] = 1 + 2 = 3
(1,3) -> ar[1] + ar[3] = 3 + 6 = 3
(2,4) -> ar[2] + ar[4] = 2 + 1 = 3
(4,5) -> ar[4] + ar[5] = 1 + 2 = 3

 */
class Result {

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int divisibleSumPairs = 0;
        int sum = 0;
        Integer element;

        for (int i=0; i < ar.size(); i++) {
            element = ar.get(i);
            for (int j=i+1; j < ar.size(); j++) {
                if (i < j) {
                    sum = element + ar.get(j);
                    if (sum%k == 0) {
                        divisibleSumPairs++;
                    }
                }
            }
        }
        
        return divisibleSumPairs;
    }

}

public class DivisibleSumPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
