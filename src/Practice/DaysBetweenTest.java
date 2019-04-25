/*
Mizuki Hashimoto
02/01/2019

1.1:7
Think about how you might test the DaysBetween application.
What type of input should give a result of 0? Of 1? Of 7? Of 365? Of 366?
Try out the test cases that you identified.
 */
package com.company;
import java.util.Scanner;

public class DaysBetweenTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int day, month, year;

        System.out.println("Enter two 'modern' dates: month day year");
        System.out.println("For example, January 21, 1939, would be: 1 21 1939");
        System.out.println();
        System.out.println("Modern dates are not before " + Date.MINYEAR + ".");
        System.out.println();

        System.out.println("Enter the first date:");
        month = scan.nextInt(); day = scan.nextInt(); year = scan.nextInt();
        Date d1 = new Date(month, day, year);

        System.out.println("Enter the second date:");
        month = scan.nextInt(); day = scan.nextInt(); year = scan.nextInt();
        Date d2 = new Date(month, day, year);

        if ((d1.getYear() <= Date.MINYEAR) || (d2.getYear() <= Date.MINYEAR))
            System.out.println("You entered a 'pre-modern' date.");
        else
        {
            System.out.println("The number of days between");
            System.out.print(d1 + " and " + d2 + " is ");
            System.out.println(Math.abs(d1.lilian() - d2.lilian()));
        }
    }
}
/*
Enter two 'modern' dates: month day year
For example, January 21, 1939, would be: 1 21 1939

Modern dates are not before 1583.

Enter the first date:
1 21 1939
Enter the second date:
1 21 1939
The number of days between
1/21/1939 and 1/21/1939 is 0



Enter two 'modern' dates: month day year
For example, January 21, 1939, would be: 1 21 1939

Modern dates are not before 1583.

Enter the first date:
1 21 1939
Enter the second date:
1 22 1939
The number of days between
1/21/1939 and 1/22/1939 is 1



Enter two 'modern' dates: month day year
For example, January 21, 1939, would be: 1 21 1939

Modern dates are not before 1583.

Enter the first date:
1 21 1939
Enter the second date:
1 28 1939
The number of days between
1/21/1939 and 1/28/1939 is 7



Enter two 'modern' dates: month day year
For example, January 21, 1939, would be: 1 21 1939

Modern dates are not before 1583.

Enter the first date:
1 21 1939
Enter the second date:
1 21 1940
The number of days between
1/21/1939 and 1/21/1940 is 365



Enter two 'modern' dates: month day year
For example, January 21, 1939, would be: 1 21 1939

Modern dates are not before 1583.

Enter the first date:
1 21 1939
Enter the second date:
1 22 1940
The number of days between
1/21/1939 and 1/22/1940 is 366
 */