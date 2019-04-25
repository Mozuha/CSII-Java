/*
Mizuki Hashimoto

3. Input an integer n, then in a for loop input n numbers (double type again),
   computing the sum/subtotal as each number is entered, at the end of the loop, print the average.
   Use nextDouble() (integer and double types, for loop)
*/
package com.company;
import java.util.Scanner;

public class Lab0_3 {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter how many numbers to calculate sum and average:");
        int n = sc.nextInt(); // Input the amount of numbers to calculate
        double result = 0; // Sum
        System.out.println("Enter " + n + " numbers:");

        // Input the numbers to calculate, add them, and print the current sum
        for (int i=0; i<n; i++){
            double num = sc.nextDouble(); // Input numbers to calculate
            result += num; // Adding
            System.out.println("Current sum is " + result + "."); // Printing the sum as each numbers is entered
        }
        System.out.println("Total sum = " + result); // Total sum
        System.out.println("Average = " + result / n); // Average
    }
}
/*
Enter how many numbers to calculate sum and average:
5
Enter 5 numbers:
32
Current sum is 32.0.
44.2
Current sum is 76.2.
12.5
Current sum is 88.7.
87
Current sum is 175.7.
2
Current sum is 177.7.
Total sum = 177.7
Average = 35.54
 */