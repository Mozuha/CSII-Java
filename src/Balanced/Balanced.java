/*
Mizuki Hashimoto
02/20/2019

This class gives function of checking bracket matching for BalancedCLI class.
 */
package com.company;

public class Balanced{
  protected String openSet;
  protected String closeSet;
  private char bracket = ' ';
  private int pos = 0;

  public Balanced(String openSet, String closeSet)
  // Preconditions: No character is contained more than once in the 
  //                combined openSet and closeSet strings.
  //                The size of openSet = the size of closeSet.
  {
    this.openSet = openSet;
    this.closeSet = closeSet;
  }

  public int test(String expression)
  // Returns 0 if expression is balanced.
  // Returns 1 if expression has unbalanced symbols.
  // Returns 2 if expression came to end prematurely.
  {
    char currChar;                   // current expression character being studied
    int  currCharIndex = 0;              // index of current character
    int  lastCharIndex = expression.length() - 1;              // index of last character in the expression
    int openIndex;                   // index of current character in openSet
    int closeIndex;                  // index of current character in closeSet
    boolean stillBalanced = true;    // true as long as expression is balanced
    StackInterface<Integer> stack = new ArrayListStack<Integer>();   // holds unmatched open symbols

    while (stillBalanced && (currCharIndex <= lastCharIndex)){
    // while expression still balanced and not at end of expression
      currChar = expression.charAt(currCharIndex);
      openIndex = openSet.indexOf(currChar);

      if(openIndex != -1){   // if the current character is in the openSet
        // Push the index onto the stack.
        stack.push(openIndex);
      }
        else{
          closeIndex = closeSet.indexOf(currChar);
          if(closeIndex != -1){     // if the current character is in the closeSet
            try{                    // try to pop an index off the stack
              openIndex = stack.top();
              stack.pop();     
              if (openIndex != closeIndex)   // if popped index doesn't match
                stillBalanced = false;         // then expression is not balanced
            }
            catch(StackUnderflowException e){ // if stack was empty
              stillBalanced = false;           // then expression is not balanced
            }
          }
        }
        currCharIndex++;             // set up processing of next character
      }

      if (!stillBalanced) {
        this.bracket = expression.charAt(currCharIndex - 1);
        this.pos = currCharIndex;
        return 1;             // unbalanced symbols
      }
      else if (!stack.isEmpty()) {
        this.bracket = openSet.charAt(stack.top());
        return 2;             // premature end of expression
      }
      else
        return 0;             // expression is balanced
  }
  public char getBracket(){
    return this.bracket;
  }
  public int getPos(){
    return this.pos;
  }
}
