package com.hackerrank.preparation.week1.challenge4;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
Maria plays college basketball and wants to go pro. Each season she maintains a record of her play.
She tabulates the number of times she breaks her season record for most points and least points in a game.
Points scored in the first game establish her record for the season, and she begins counting from there.

Example:
scores=[12,24,10,24]

Input format
4                The first line contains an integer n, the number of games.
12 24 10 24      The second line contains n space-separated integers describing the respective values of score(0), score(1), ... ,score(n-1)

Output
1 1              int[2]: An array with the numbers of times she broke her records and
                         index 0 is for breaking most points records, and index 1 is for breaking least points records.
*/
class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        Integer [] numberOfTimesBreakingRecordsArray = new Integer[2];

        Integer mostPointsRecord = scores.get(0);
        Integer leastPointsRecord = scores.get(0);
        Integer numberOfTimesMostRecords = 0;
        Integer numberOfTimesLeastRecords = 0;

        for (int i=1; i < scores.size(); i++) {
            if (scores.get(i) > mostPointsRecord) {
                numberOfTimesMostRecords++;
                mostPointsRecord = scores.get(i);
            } else if (scores.get(i) < leastPointsRecord) {
                numberOfTimesLeastRecords++;
                leastPointsRecord = scores.get(i);
            }
        }

        numberOfTimesBreakingRecordsArray[0] = numberOfTimesMostRecords;
        numberOfTimesBreakingRecordsArray[1] = numberOfTimesLeastRecords;

        return Arrays.asList(numberOfTimesBreakingRecordsArray);
    }

}

public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
