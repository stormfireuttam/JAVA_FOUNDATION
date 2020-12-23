package DynamicProgramming;
//1. You are given a string str of digits. (will never start with a 0)
//        2. You are required to encode the str as per following rules
//        1 -> a
//        2 -> b
//        3 -> c
//        ..
//        25 -> y
//        26 -> z
//        3. You are required to calculate and print the count of encodings for the string str.
//
//        For 123 -> there are 3 encodings. abc, aw, lc
//        For 993 -> there is 1 encoding. iic
//        For 013 -> This is an invalid input. A string starting with 0 will not be passed.
//        For 103 -> there is 1 encoding. jc
//        For 303 -> there are 0 encodings. But such a string maybe passed. In this case
//        print 0.
//        Input Format
//        A string str
//        Output Format
//        count of encodings
//        Constraints
//        0 < str.length <= 10
//        Sample Input
//        123
//        Sample Output
//        3

import java.util.Scanner;

public class CountEncodings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toCharArray();
        int dp[] = new int[ch.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int chValue = ch[i] - '0';
            if (chValue != 0)
                dp[i] = dp[i - 1];
            int ch2Value = ch[i - 1] - '0';
            int value = ch2Value * 10 + chValue;
            if (value >= 10 && value <= 26) {
                if (i == 1) {
                    dp[i] ++;
                }
                else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
    }
}
