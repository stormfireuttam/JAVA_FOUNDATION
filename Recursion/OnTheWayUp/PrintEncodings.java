package Recursion.OnTheWayUp;

import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();
        printEncodings(code, "");
    }
    private static void printEncodings(String ques, String ans) {
        //If ques string becomes empty print return
        if(ques.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        //If ques string length is 1
        else if(ques.length() == 1)
        {
            char ch = ques.charAt(0);
            //If char is zero simply return
            if (ch == '0'){
                return;
            }
            //Else print out the answer
            else {
                int chValue = ch - '0';
                char chCode = (char)('a' + chValue - 1);
                System.out.println(ans + chCode);
            }
        }
        else {
            //Extracting 1st char
            char ch = ques.charAt(0);
            if (ch == '0') return;
            int chValue = ch - '0';
            char chCode = (char)('a' + chValue - 1);
            printEncodings(ques.substring(1), ans + chCode);
            //Extracting the first two characters
            String firstTwo = ques.substring(0,2);
            chValue = Integer.parseInt(firstTwo);
            //Call for printEncodings only if chValue is greater than zero and less than 26
            if (chValue > 0 && chValue <= 26) {
                chCode = (char)('a' + chValue - 1);
                printEncodings(ques.substring(2), ans + chCode);
            }
        }
    }
}
