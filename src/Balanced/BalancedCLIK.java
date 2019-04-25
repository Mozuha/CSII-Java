/*
    Keita Nonaka, Koki Omori
    Program 4
    2/19/2018
////////////////////////////////////////////////////////////////////////////////
    We will enhance the bracket matching application from the text 
    so that it reports more information about the unbalanced string.  
    In particular we want the location and value of 
    the first unbalanced character.  
    To report character locations to the user, 
    we number the character positions starting with 1. 
*/
package com.company;

import java.util.Scanner;
import java.util.*;
import java.io.*;
/*
public class BalancedCLIK{
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);    
        Balanced bal = new Balanced("([{", ")]}");
        int result = 0; // 0 = balanced, 1 = unbalanced, 2 = premature end
        String expression = null;    // expression to be evaluated
        final String STOP = "X";     // indicates end of input
        boolean error = false;      // error
        
        do{ // ask until user provide valid file name
            System.out.print("Enter filename: ");
            String dataFileName = cin.nextLine();
            
            try{
                Scanner conIn = new Scanner(new File(dataFileName));
                while (!STOP.equals(expression)){
                    System.out.print("Expression (" + STOP + " to stop): ");
                    expression = conIn.nextLine();
                    if (!STOP.equals(expression)){      
                        result = bal.test(expression);
                        if (result == 1){ // unbalanced
                            System.out.print("Unbalanced ");
                            System.out.print("Symbol \"" + bal.getBra() + "\"");
                            System.out.println(" found at location " + bal.getPos() + "\n");
                        }
                        else if (result == 2){ // premature
                            System.out.print("Premature end of expression ");
                            System.out.println("Unmatched symbol \"" + bal.getBra() + "\"\n");
                        }
                        else // result == 0, balanced
                            System.out.println("Balanced \n");
                    }
                }
                error = false;
                System.out.println("found 'X', the END");
            } catch (Exception e){ // catch 
                System.out.println("invalid file name");
                error = true;
            }
        }while(error == true);
        System.out.println("\nDone!");
    }
}

/* ------------------output------------------
Enter filename: a
invalid file name
Enter filename: fds
invalid file name
Enter filename: bra.txt
Expression (X to stop): Balanced

Expression (X to stop): Balanced

Expression (X to stop): Balanced

Expression (X to stop): Balanced

Expression (X to stop): Premature end of expression Unmatched symbol "("

Expression (X to stop): Unbalanced Symbol "}" found at location 11

Expression (X to stop): Unbalanced Symbol ")" found at location 23

Expression (X to stop): Unbalanced Symbol "]" found at location 16

Expression (X to stop): Balanced

Expression (X to stop): Balanced

Expression (X to stop): found 'X', the END

Done!

 */