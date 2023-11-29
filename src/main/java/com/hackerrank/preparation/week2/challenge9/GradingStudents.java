package com.hackerrank.preparation.week2.challenge9;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
HackerLand University has the following grading policy:

Every student receives a grade in the inclusive range from 0 to 100.
Any grade less than 40 is a failing grade.
Sam is a professor at the university and likes to round each student's grade according to these rules:

If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.

Examples:
grade = 84 round to 85 (85 - 84 is less than 3)
grade = 29 do not round (result is less than 40)
grade = 57 do not round (60 - 57 is 3 or higher)

Input format:
The first line contains a single integer, n, the number of students.
Each line  of the  subsequent lines contains a single integer, grades[i].
4       - n, the number of students.
73
67
38
33

Output format:
int[n]: the grades after rounding as appropriate
75
67
40
33

 */
class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> listAfterRounding = new ArrayList<>();
        for (int i=0; i < grades.size(); i++) {
            if (grades.get(i) < 38) {
                listAfterRounding.add(grades.get(i));
            } else if( grades.get(i) % 5 == 0 ) {
                listAfterRounding.add(grades.get(i));
            } else {
                int number = grades.get(i);

                while (number <= 100) {
                    if (number % 5 == 0) {
                        if ((number - grades.get(i)) < 3) {
                            listAfterRounding.add(number);
                            break;
                        } else {
                            listAfterRounding.add(grades.get(i));
                            break;
                        }
                    }
                    number++;
                }
            }

        }
        return listAfterRounding;
    }
}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
