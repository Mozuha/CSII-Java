/*--------------------------------------------------------
Mizuki Hashimoto
03/20/2019

Recursion programme which returns the floor function of calculated logb(n) value where b is base and both b and n are
inputted integer.
---------------------------------------------------------- */

import java.util.Scanner;

public class RecursionI2 {
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        int n = 0;  // input limit
        int base = 0; // base value
        String line = "";
        System.out.print("Enter n: ");
        while (!kb.hasNextInt()) {
            line = kb.next();
            System.out.println("Please enter an integer: ");
        }
        n = kb.nextInt();
        System.out.print("Enter base: ");
        while (!kb.hasNextInt()) {
            line = kb.next();
            System.out.println("Please enter an integer: ");
        }
        base = kb.nextInt();

        System.out.println("\n***Result of value returned by recursion: "
                + logar(n, base));

        System.out.println("\n***End of recursive demo***");
    }

    // return the calculated value of log2(n)
    static int logar(int n, int base) {
        //base case
        if (base > 0) {
            if (n < base) {
                return 0;
            } else {
                return logar((n / base), base) + 1;
            }
        } return 0;
    }
}

/*------------------------------------------------------
Enter n: 8
Enter base: 2

***Result of value returned by recursion: 3

***End of recursive demo***
--------------------------------------------------------
Enter n: 2
Enter base: 8

***Result of value returned by recursion: 0

***End of recursive demo***
--------------------------------------------------------
Enter n: y
Please enter an integer:
156
Enter base: f
Please enter an integer:
13

***Result of value returned by recursion: 1

***End of recursive demo***
-------------------------------------------------------- */