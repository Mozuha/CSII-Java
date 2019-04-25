/*-------------------------------------------
Mizuki Hashimoto
03/28/2019

This is the programme to calculate prefix expression by using recursion.
-------------------------------------------*/

package Prefix;

import java.util.*;

public class PrefixEval {
    public static void main(String argv[]) {
        Scanner lineInput = new Scanner(System.in);
        System.out.print("Prefix Expression: ");

        while (lineInput.hasNextLine()) {
            String line = lineInput.nextLine();
            // set up scanning of the line
            Scanner expr = new Scanner(line);
            Prefix p = new Prefix(expr);

            //display results
            try {
                double r = p.result();
                if (expr.hasNext())
                    throw new IllegalArgumentException("Invalid expression");
                System.out.println(line + " = " + r);
            } catch (Exception e) {
                System.out.println("Error with input: " + line + " ERROR = " + e.getMessage());
            } main(argv);
        }
    }
}

/*-------------------------------------------------
Prefix Expression: + 3 4
+ 3 4 = 7.0
Prefix Expression: - 9 4
- 9 4 = 5.0
Prefix Expression: -596
-596 = -596.0
Prefix Expression: - 4 9
- 4 9 = -5.0
Prefix Expression: / * 15 4 + 5 1
/ * 15 4 + 5 1 = 10.0
Prefix Expression: - + + 9 8 7 6
- + + 9 8 7 6 = 18.0
Prefix Expression: + * 2 -3 * -4 15
+ * 2 -3 * -4 15 = -66.0
Prefix Expression: / * 309 3 * + 23 9 - 8 3
/ * 309 3 * + 23 9 - 8 3 = 5.79375
Prefix Expression: / 6 - 4 * 2 2
Error with input: / 6 - 4 * 2 2 ERROR = Illegal divide by 0
Prefix Expression: + 4
Error with input: + 4 ERROR = Invalid expression
Prefix Expression: + 1 2 3
Error with input: + 1 2 3 ERROR = Invalid expression
Prefix Expression: & 1 2
Error with input: & 1 2 ERROR = For input string: "&"
Prefix Expression: + 3 * 4
Error with input: + 3 * 4 ERROR = Invalid expression
Prefix Expression: / 4 - 5 5
Error with input: / 4 - 5 5 ERROR = Illegal divide by 0
Prefix Expression: * 3 oops
Error with input: * 3 oops ERROR = For input string: "oops"
Prefix Expression: / * 2 2 + 3 7
/ * 2 2 + 3 7 = 0.4
Prefix Expression: - -891 6 - 27 10
Error with input: - -891 6 - 27 10 ERROR = Invalid expression
Prefix Expression: * - -142 18 * / 32 18 - 89 143*
* - -142 18 * / 32 18 - 89 143 = 15360.0
Prefix Expression: prefix
Error with input: prefix ERROR = For input string: "prefix"
-----------------------------------------------------*/