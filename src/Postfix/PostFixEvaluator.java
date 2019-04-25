/*
Mizuki Hashimoto
03/04/2019

Added some functions to PostFixEvaluator. Enable to calculate modulus, raise to power, negation, and square. 
Throw "illegal divide by zero" message when entered equation cause divide by zero.
 */

// package ch02.postfix;

// import ch02.stacks.*;

package Postfix;

import java.util.Scanner;

public class PostFixEvaluator
{
  public static int evaluate(String expression)
  {
    Scanner tokenizer = new Scanner(expression);
    StackInterface<Integer> stack = new ArrayBoundedStack<Integer>(50);  

    int value;
    String operator;
    int operand1, operand2;
    int result = 1;

    while (tokenizer.hasNext())
    {
      if (tokenizer.hasNextInt())
      {
        // Process operand.
        value = tokenizer.nextInt();
        if (stack.isFull())
          throw new PostFixException("Too many operands-stack overflow");
        stack.push(value);
      }
      else
      {
        // Process operator.
        operator = tokenizer.next();
        
        // Check for illegal symbol
        if (!(operator.equals("/") || operator.equals("*") ||
              operator.equals("+") || operator.equals("-") ||
              operator.equals("%") || operator.equals("^") ||
              operator.equals("~") || operator.equals("$")))
          throw new PostFixException("Illegal symbol: " + operator);
  
        // Obtain second operand from stack.
        if (stack.isEmpty())
          throw new PostFixException("Not enough operands-stack underflow");
        operand2 = stack.top();
        stack.pop();

        if(operator.equals("~") || operator.equals("$")){
          if(operator.equals("~"))
            result = -operand2;
          else if(operator.equals("$"))
            result = operand2 * operand2;
        }
        else{
        // Obtain first operand from stack.
        if (stack.isEmpty())
          throw new PostFixException("Not enough operands-stack underflow");
        operand1 = stack.top();
        stack.pop();

        // Perform operation.
        if (operator.equals("/")) {
          if(operand2 == 0){
            throw new PostFixException("illegal divide by zero"); // throw exception when divide by zero happened
          }
          result = operand1 / operand2;
        }
        else if(operator.equals("*")) {
          result = operand1 * operand2;
        }
        else if(operator.equals("+")) {
          result = operand1 + operand2;
        }
        else if(operator.equals("-")) {
          result = operand1 - operand2;
        }
        else if(operator.equals("%")) { // operation of modulus
          result = operand1 % operand2;
        }
        else if(operator.equals("^")) { // operation of raising to power
          while(operand2 != 0){
            result *= operand1;
            --operand2;
          }
        }
        } 
        // Push result of operation onto stack.
        stack.push(result);
      }
    }

    // Obtain final result from stack. 
    if (stack.isEmpty())
      throw new PostFixException("Not enough operands-stack underflow");
    result = stack.top();
    stack.pop();

    // Stack should now be empty.
    if (!stack.isEmpty())
      throw new PostFixException("Too many operands-operands left over");

    // Return the final.
    return result;
  }
}