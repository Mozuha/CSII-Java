/*
Mizuki Hashimoto

5. Revise # 3 by now saving the data in an array of doubles, allocated to hold n numbers.
   (basic numeric array manipulations).
a. input the list of numbers into the array.
b. after the array is filled, print the sum and average of the array
c. find the largest number in the array and print it
d. count the number of numbers larger than the average and print that count.
*/
package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class Lab0_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers to calculate sum and average:");
        int n = sc.nextInt(); // Input amount of numbers to calculate
        double [] num = new double[n]; // Array of double to hold n numbers inputted
        double result = 0; // Sum
        int larger_count = 0; // Amount of numbers larger than the average
        System.out.println("Enter " + n + " numbers:");

        // Input numbers to calculate and add them
        for (int i=0; i<n; i++){
            num[i] = sc.nextDouble(); // Input numbers to calculate
            result += num[i]; // Adding
        }
        double ave = result / n; // Average
        double max = Arrays.stream(num).max().getAsDouble(); // Find the max value among the array

        // Count the number if that number is bigger than the average
        for (double i : num){
            if (i > ave){
                larger_count++; // Count amount of numbers larger than the average
            }
        }
        System.out.println("Sum = " + result); // Sum
        System.out.println("Average = " + ave); // Average
        System.out.println("The largest number among you entered is " + max + "."); // Max number
        System.out.println(+ larger_count + " numbers were bigger than the average.");
        // Amount of numbers bigger than the average
    }
}
/*
Enter how many numbers to calculate sum and average:
3
Enter 3 numbers:
21
3.2
48
Sum = 72.2
Average = 24.066666666666666
The largest number among you entered is 48.0.
1 numbers were bigger than the average.
 */