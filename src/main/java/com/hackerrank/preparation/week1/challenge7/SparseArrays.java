package com.hackerrank.preparation.week1.challenge7;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
There is a collection of input strings and a collection of query strings.
For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.

Complete the function matchingStrings in the editor below. The function must return an array of integers representing
the frequency of occurrence of each query string in strings.

matchingStrings has the following parameters:

- string strings[n] - an array of strings to search
- string queries[q] - an array of query strings

Input:
The first line contains and integer n, the size of strings[].
Each of the next n lines contains a string strings[i].
The next line contains q, the size of queries[].
Each of the next q lines contains a string queries[i].

Sample input:
4
aba
baba
aba
xzxb
3
aba
xzxb
ab

Sample output:
2
1
0

 */
class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        String queryElement;
        int frequencyOfOccurence = 0;
        List<Integer> results = new ArrayList();

        for (int i = 0; i < queries.size(); i++) {
            queryElement = queries.get(i);
            for (int j = 0; j < strings.size(); j++) {
                if (queryElement.equals(strings.get(j))) {
                    frequencyOfOccurence++;
                }
            }
            results.add(frequencyOfOccurence);
            frequencyOfOccurence = 0;
        }

        return results;
    }

}

public class SparseArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = Result.matchingStrings(strings, queries);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
