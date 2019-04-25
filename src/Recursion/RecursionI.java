/*--------------------------------------------------------
Mizuki Hashimoto
03/20/2019

Recursion programme which returns the floor function of calculated log2(n) value where n is inputted integer.
---------------------------------------------------------- */

import java.util.Scanner;

public class RecursionI {
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        int n = 0;  // input limit
        String line = "";
        System.out.print("Enter n: ");
        while(!kb.hasNextInt()){
            line = kb.next();
            System.out.println("Please enter an integer: ");
        }
        n = kb.nextInt();

        System.out.println("\n***Result of value returned by recursion: "
                + log2(n));

        System.out.println("\n***End of recursive demo***");
    }

    // return the calculated value of log2(n)
    static int log2(int n){
        //base case
        if(n < 2){
            return 0;
        }

        //recursion case
        return log2(n / 2) + 1;
    }
}

/*------------------------------------------------------
Enter n: 1

***Result of value returned by recursion: 0

***End of recursive demo***
--------------------------------------------------------
Enter n: 8

***Result of value returned by recursion: 3

***End of recursive demo***
--------------------------------------------------------
Enter n: y
Please enter an integer:
98

***Result of value returned by recursion: 6
-------------------------------------------------------- */