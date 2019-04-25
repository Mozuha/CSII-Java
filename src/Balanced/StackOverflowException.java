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

public class StackOverflowException extends RuntimeException{
    public StackOverflowException(){
        super();
    }
    
    public StackOverflowException(String message){
        super(message);
    }
}