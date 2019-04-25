/*
Mizuki Hashimoto
02/20/2019

Bracket matching programme tells if the bracket is balanced or not.
Also tells what symbol in where is unmatching if the bracket is unbalanced.
 */
package com.company;

import java.util.*;
import java.io.*;

public class BalancedCLI{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Balanced bal = new Balanced("([{", ")]}");
    int result = 0; // 0 = balanced, 1 = unbalanced, 2 = premature end
    String expression = null;    // expression to be evaluated
    final String STOP = "X";     // indicates end of input
    boolean error = false;

    do {
      System.out.print("Enter filename: ");
      String dataFileName = sc.nextLine();
      try {
        BufferedReader dataFile = new BufferedReader(new FileReader(dataFileName));
        Scanner conIn = new Scanner(dataFile); //replacing the text's Scanner object declaration
        while (!STOP.equals(expression)) { // Get next expression to be processed.
          System.out.print("Expression (" + STOP + " to stop): ");
          expression = conIn.nextLine();
          if (!STOP.equals(expression)) { // Obtain and output result of balanced testing.
            result = bal.test(expression);
            if (result == 1) {
              System.out.print("Unbalanced. ");
              System.out.print("Symbol \"" + bal.getBracket() + "\"");
              System.out.println(" found at location " + bal.getPos() + ".\n");
            } else if (result == 2) {
              System.out.print("Premature end of expression. ");
              System.out.println("Unmatched symbol \"" + bal.getBracket() + "\".\n");
            } else
              System.out.println("Balanced \n");
          }
        }
      } catch (Exception e) {
        System.out.println("Invalid file.");
        error = true;
      }
    } while (error == true);
    System.out.println("Done.");
  }
}