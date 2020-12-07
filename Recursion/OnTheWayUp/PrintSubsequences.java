package Recursion.OnTheWayUp;

import java.util.Scanner;

public class PrintSubsequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printSubseqs(input, "");
    }
    //abc
    private static void printSubseqs(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);       //a
        String roq = ques.substring(1); //bc
        printSubseqs(roq, ans + "");    //subsequences where ch didn't accept to be a part of the answer
        printSubseqs(roq, ans + ch);    //subsequences where ch accepted to be a part of the answer
    }
}
