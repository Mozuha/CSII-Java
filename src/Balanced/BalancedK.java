package com.company;

public class BalancedK {
    protected String openSet;
    protected String closeSet;
    private char bra = ' '; // bracket
    private int pos = 0; // position of error bracket

    public BalancedK(String openSet, String closeSet){
        this.openSet = openSet;
        this.closeSet = closeSet;
    }

    public int test(String expression){
        char currChar;
        int  currCharIndex = 0;
        int  lastCharIndex = expression.length() - 1;
        int openIndex;
        int closeIndex;
        boolean stillBalanced = true;
        StackInterface<Integer> stack = new ArrayListStack<Integer>();
        
        while (stillBalanced && (currCharIndex <= lastCharIndex)){
            // while expression still balanced and not at end of expression
            currChar = expression.charAt(currCharIndex);
            openIndex = openSet.indexOf(currChar);
            
            if(openIndex != -1){
                // if the current character is in the openSet
                // Push the index onto the stack.
                stack.push(openIndex);
            }
            else{
                closeIndex = closeSet.indexOf(currChar);
                if(closeIndex != -1){
                    // if the current character is in the closeSet 
                    try{
                        // try to pop an index off the stack
                        openIndex = stack.top();
                        stack.pop();
                        if (openIndex != closeIndex) {   // if popped index doesn't match
                            stillBalanced = false;         // then expression is not balanced
                        }
                    }
                    catch(StackUnderflowException e){
                        // if stack was empty
                        stillBalanced = false;           // then expression is not balanced
                    }
                }
            }
            currCharIndex++;             // set up processing of next character
        }
        if (!stillBalanced){ // unbalanced symbols
            this.bra = expression.charAt(currCharIndex - 1); 
            this.pos = currCharIndex;
            return 1;             
        }
        else if (!stack.isEmpty()){ // premature end of expression
            this.bra = openSet.charAt(stack.top());
            return 2;             
        }
        else  // expression is balanced
            return 0;             
    }
    
    public char getBra(){ // getter of unnecessary bracket
        return this.bra;
    }
    
    public int getPos(){ // getter of position of unnecessary bracket
        return this.pos;
    }
}
