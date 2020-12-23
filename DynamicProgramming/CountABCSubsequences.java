/*
1. You are given a string str.
2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
 */
package DynamicProgramming;

import java.util.Scanner;

public class CountABCSubsequences {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // We keep track of the count of a, count of ab, count of abc
        // For a the formula would be   =>   a = 2 * a + 1
        // For ab the formula would be  =>   ab = 2 * ab + a
        // For abc the formula would be =>   abc = 2 * abc + ab
        int counta = 0, countab = 0, countabc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                counta = 2 * counta + 1;
            }
            else if (s.charAt(i) == 'b') {
                countab = 2 * countab + counta;
            }
            else if (s.charAt(i) == 'c') {
                countabc = 2 * countabc + countab;
            }
        }
        System.out.println(countabc);
    }
}
