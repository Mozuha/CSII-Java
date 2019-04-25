/*
Mizuki Hashimoto
03/04/2019

Utilise PostFixEvaluator to calculate entered equation.Stop when the user entered "X".
 */
// package ch02.apps;

package Postfix;

import java.util.Scanner;
// import ch02.postfix.*;

public class PFixCLI 
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);

    String expression = null;    // expression to be evaluated
    final String STOP = "X";     // indicates end of input
    int result;                  // result of evaluation

    while (!STOP.equals(expression))
    {
      // Get next expression to be processed.
      System.out.print("\nPostfix Expression (" + STOP + " to stop): ");
      expression = scan.nextLine();
      
      if (!STOP.equals(expression))
      {      
         // Obtain and output result of expression evaluation.
         try
         {
           result = PostFixEvaluator.evaluate(expression);
   
           // Output result.
           System.out.println("Result = " + result);
         }
         catch (PostFixException error)
         {        
           // Output error message.
           System.out.println("Error in expression - " + error.getMessage());
         }
      }
    }
  }
}

/*
> run PFixCLI

Postfix Expression (X to stop):  1
Result = 1 

Postfix Expression (X to stop):  999
Result = 999 

Postfix Expression (X to stop):  1 99 +
Result = 100 

Postfix Expression (X to stop):  2 3 4 + * 5 -
Result = 9 

Postfix Expression (X to stop):  5 7 + 6 2 - *
Result = 48 

Postfix Expression (X to stop):  12 3 / 5 /
Result = 0 

Postfix Expression (X to stop):  23 5 %
Result = 3 

Postfix Expression (X to stop):  1 2 3 +
Error in expression - Too many operands-operands left over 

Postfix Expression (X to stop):  1 2 3 + + +
Error in expression - Not enough operands-stack underflow 

Postfix Expression (X to stop):  5 3 2 1 + - /
Error in expression - illegal divide by zero 

Postfix Expression (X to stop):  4 $ 3 $ +
Result = 25 

Postfix Expression (X to stop):  4 9 - ~ 7 *
Result = 35 

Postfix Expression (X to stop):  2 6 ^
Result = 64 

Postfix Expression (X to stop):  40 3 5 * - 1 +
Result = 26 

Postfix Expression (X to stop):  4 5 7 2 + - *
Result = -16 

Postfix Expression (X to stop):  5 4 3 * % 5 +
Result = 10 

Postfix Expression (X to stop):  X
> 
 */
