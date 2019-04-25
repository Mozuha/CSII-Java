/*--------------------------------------------------
Mizuki Hashimoto
03/28/2019

This is the class to be used in PrefixEval class to perform the calculation of prefix expression with recursion.
--------------------------------------------------*/

package Prefix;

import java.util.*;

public class Prefix {
    private Scanner line;

    public Prefix(Scanner s){ // digits strings
        line = s;
    }

    public double result () {
        String token;
        double a; // variable 1
        double b; // variable 2

        if(line.hasNext()) {
            token = line.next();
        }else {
            throw new IllegalArgumentException("Invalid expression");
        }  //exception

        if(token.equals("+")){ // addition
            a = result();
            b = result();
            return a + b;
        } else if(token.equals("-")){ // subtraction
            a = result();
            b = result();
            return a - b;
        } else if(token.equals("*")){ //multiplication
            a = result();
            b = result();
            return a * b;
        } else if(token.equals("/")){ // division
            a = result();
            b = result();
            if(b == 0)
                throw new IllegalArgumentException("Illegal divide by 0"); // throw error when divided by 0
            return a / b;
        } else { // then it's a constant in the expression
            // return  digit's value in double type or throw exception if string is null or not contain parsable float
            return Double.parseDouble(token);
        }
    }
}