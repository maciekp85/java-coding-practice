package com.hackerrank.preparation.week1.challenge5;

import java.util.*;
import java.util.regex.*;

/*
Camel Case is a naming style common in many programming languages. In Java, method and variable names typically start with a lowercase letter,
with all subsequent words starting with a capital letter (example: startThread). Names of classes follow the same pattern,
except that they start with a capital letter (example: BlueCar).

Your task is to write a program that creates or splits Camel Case variable, method, and class names.

Input Format:
- Each line of the input file will begin with an operation (S or C) followed by a semicolon followed by M, C, or V followed by a semicolon
followed by the words you'll need to operate on.
- The operation will either be S (split) or C (combine)
- M indicates method, C indicates class, and V indicates variable
- In the case of a split operation, the words will be a camel case method, class or variable name that you need to split
into a space-delimited list of words starting with a lowercase letter.
- In the case of a combine operation, the words will be a space-delimited list of words starting with lowercase letters that you need
to combine into the appropriate camel case String. Methods should end with an empty set of parentheses to differentiate them from variable names.

Output Format:
For each input line, your program should print either the space-delimited list of words (in the case of a split operation)
or the appropriate camel case string (in the case of a combine operation).

Sample input:
S;M;plasticCup()
C;V;mobile phone
C;C;coffee machine
S;C;LargeSoftwareBook
C;M;white sheet of paper
S;V;pictureFrame

Sample output:
plastic cup
mobilePhone
CoffeeMachine
large software book
whiteSheetOfPaper()
picture frame

Explanation:
- Use Scanner to read in all information as if it were coming from the keyboard.
- Print all information to the console using standard output (System.out.print() or System.out.println()).
- Outputs must be exact (exact spaces and casing).
*/
public class CamelCase {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner src = new Scanner(System.in);
        src.useDelimiter("\n");

        String operation;
        String typeOfWord;
        String word;
        String result ="";
        Pattern pattern;
        Matcher matcher;

        while(src.hasNext()) {
            String input = src.next();
            pattern = Pattern.compile("[^;]+");
            matcher = pattern.matcher(input);
            List<String> list = new ArrayList<>();
            while (matcher.find()) {
                list.add(matcher.group());
            }
            operation = list.get(0);
            typeOfWord = list.get(1);
            word = list.get(2);

            if (operation.equals("S")) {
                if (typeOfWord.equals("M") || typeOfWord.equals("V")) {
                    pattern = Pattern.compile("^[a-z]+");
                    matcher = pattern.matcher(word);
                    while(matcher.find()) {
                        result += matcher.group() + " ";
                    }
                    char c = result.charAt(0);
                    result = result.replaceFirst("^[a-z]", String.valueOf(c).toUpperCase());
                }
                pattern = Pattern.compile("([A-Z][a-z]+)");
                matcher = pattern.matcher(word);
                while(matcher.find()) {
                    result += matcher.group() + " ";
                }
                result = result.toLowerCase();

            } else if (operation.equals("C")){
                String [] words = word.split(" ");
                String temp;

                if (typeOfWord.equals("C")) {
                    for (int i = 0; i < words.length; i++) {
                        temp = words[i];
                        char c = temp.charAt(0);
                        temp = temp.replaceFirst("^[a-z]", String.valueOf(c).toUpperCase());
                        result += temp;
                    }
                    result += " ";
                } else if (typeOfWord.equals("V") || typeOfWord.equals("M")) {
                    for (int i=0; i<words.length; i++) {
                        if (words.length > 1 && i > 0) {
                            temp = words[i];
                            char c = temp.charAt(0);
                            temp = temp.replaceFirst("^[a-z]", String.valueOf(c).toUpperCase());
                            result += temp.trim();
                        } else {
                            result += words[i];
                        }
                    }

                    if (typeOfWord.equals("V")) {
                        result += " ";
                    } else {
                        result += "() ";
                    }
                }
            }

            // It works only on hackerrank
//            if(!src.hasNext()) {
//                System.out.println(result.trim());
//                return;
//            }

            System.out.println(result);
            result = "";
        }

        src.close();
    }
}
