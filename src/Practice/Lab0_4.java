/*
Mizuki Hashimoto

4. Input a list of words terminated by end of input (^D or ^Z), find the longest word, print it and how long it is.
   Use next() and hasNext(). Also print out how many words were input.
   (String type, scanning, next(), end of input, while loop).
*/
package com.company;
import java.util.Scanner;

public class Lab0_4 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String word = "";
        int lw_length = 0; // Longest word length
        int n = 0;

        System.out.println("Enter the text. Enter ^D or ^Z to finish.");

        // Detect empty line to terminate
        while (sc.hasNext()) {
            String input = sc.next();

            // Find the largest word and its length
            if (input.length() > word.length()) {
                word = input;
                lw_length = word.length();
            }
            n++;
        }
        System.out.println("The longest word among the text is " + word + " and its length is " + lw_length + ".");
        System.out.println("You entered " + n + " words");
    }
}
/*
Enter the text. Enter ^D or ^Z to finish.
Today is a beautiful day
^D
The longest word among the text is beautiful and its length is 9.
You entered 5 words
 */