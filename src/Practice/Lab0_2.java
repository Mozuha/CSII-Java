/*
Mizuki Hashimoto

2. Input 3 numbers as double type numbers, compute and print their sum and average. (input, double types)
*/
package com.company;
import java.util.Scanner;

public class Lab0_2 {
    public static void main (String [] args) {
        double n1, n2, n3; // Three numbers
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three whole numbers:");
        n1 = sc.nextDouble();
        n2 = sc.nextDouble();
        n3 = sc.nextDouble();
        double total = n1 + n2 + n3; // Calculate the sum
        double ave = total / 3; // Calculate the average
        System.out.print("The sum of three numbers is " + total + ". The average is " + ave + ".");
    }
}
/*
Enter three whole numbers:
13
59
22
The sum of three numbers is 94.0. The average is 31.333333333333332.
 */