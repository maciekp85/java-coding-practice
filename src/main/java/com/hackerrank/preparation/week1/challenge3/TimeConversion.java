package com.hackerrank.preparation.week1.challenge3;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Given a time in -hour AM/PM format, convert it to military (24-hour) time.

// Sample input: 07:05:45PM
// Sample output: 19:05:45
class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        LocalTime time = LocalTime.parse(s, DateTimeFormatter.ofPattern("hh':'mm':'ssa", Locale.US));
        s = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        // 2nd solution
//        s =  DateTimeFormatter.ofPattern("HH:mm:ss").format(DateTimeFormatter.ofPattern("hh:mm:ssa",  Locale.US).parse(s));
        return s;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
