/*
Mizuki Hashimoto

6. Create an array to hold up to 100 strings.
a. input a few full lines of text, not just words, into the array until an empty line is entered. Use nextLine().
   Count the number of lines.
b. input a character (such as an 'A' or 'x'. Print all lines that start with that character.
c. input a word and find and print all lines that contain that word (String manipulations, searching, and loops)
*/

package com.company;
import java.util.Scanner;

public class Lab0_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] text = new String[100]; // Create an array to hold up to 100 strings
        int n = 0;
        System.out.println("Enter the text. Enter empty line to finish:");

        // Input the text until detect the empty line. Count the number of lines
        while(true){
            String input = sc.nextLine();
            if(input.isEmpty()) break;
            text[n] = input;
            n++;
        }
        System.out.println("You entered " + n + " lines.");
        System.out.println("Enter a character to find the line start with that character:");
        char ch = sc.next().charAt(0);

        // Find the line start from the character inputted and print
        for (int i=0; i<n; i++){
            if (text[i].charAt(0) == ch){
                System.out.println(i + ":" + text[i]);
            }
        }
        System.out.println("Enter a word you want to search:");
        String word = sc.next();

        // Find the line contains the word inputted
        for (int i=0; i<n; i++){
            if (text[i].contains(word)){
                System.out.println(i + ":" + text[i]);
            }
        }
    }
}
/*
Enter the text. Enter empty line to finish:
Hello
Today is January 28th 2019
Weather is good
Outside is full of white
Snow's white reflected by the sun

You entered 5 lines.
Enter a character to find the line start with that character:
W
2:Weather is good
Enter a word you want to search:
white
3:Outside is full of white
4:Snow's white reflected by the sun
 */