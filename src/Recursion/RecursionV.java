/*--------------------------------------------------------
Mizuki Hashimoto
03/20/2019

Recursion programme which returns the inputted integer's digits in reversed order.
---------------------------------------------------------- */
package Recursion;

import java.util.Scanner;

public class RecursionV {
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        int n = 0;  // input limit
        String line = "";
        System.out.print("Enter n: ");
        while(!kb.hasNextInt()){
            System.out.print("Enter an integer: ");
            line = kb.next();
        }
        n = kb.nextInt();

        revIntPrint(n);

        System.out.println("\n***End of recursive demo***");
    }

    // print an integer's digits in reversed order
    static void revIntPrint(int n){
        //base case
        if (n <= 9){
            System.out.print(n+" ");
            return;
        }

        //recursion case
        System.out.print(n%10+" ");
        revIntPrint(n/10);
    }
}

/*-----------------------------------------
Enter n: 9
9
***End of recursive demo***
-------------------------------------------
Enter n: 12345
5 4 3 2 1
***End of recursive demo***
-------------------------------------------
Enter n: 892734163
3 6 1 4 3 7 2 9 8
***End of recursive demo***
-------------------------------------------
Enter n: 03782
2 8 7 3
***End of recursive demo***
------------------------------------------- */