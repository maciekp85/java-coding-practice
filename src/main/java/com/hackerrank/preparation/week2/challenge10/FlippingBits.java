package com.hackerrank.preparation.week2.challenge10;

import java.io.*;
import java.util.stream.*;

/*
You will be given a list of 32 bit unsigned integers. Flip all the bits (1 -> 0 and 0 -> 1 ) and return the result
as an unsigned integer.

Example:
n = 9 (10)
9 (10) = 1001 (2). We are working with 32 bits, so:
00000000000000000000000000001001 (2) = 9 (10)
11111111111111111111111111110110 (2) = 4294967286 (10)

Return 4294967286

Input format:
The first line of the input contains q, the number of queries.
Each of the next q lines contain an integer, n, to process.

Sample input:
3
2147483647
1
0

Returns
int: the unsigned decimal integer result

Sample output:
2147483648
4294967294
4294967295

 */
class Result {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
        int flippedNumber = (int) ~n;
        String unsignedDecimalNumber = Integer.toUnsignedString(flippedNumber);
        return Long.parseLong(unsignedDecimalNumber);
    }

}

public class FlippingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result.flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
