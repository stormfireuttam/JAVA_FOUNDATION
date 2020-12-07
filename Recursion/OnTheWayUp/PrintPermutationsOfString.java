package Recursion.OnTheWayUp;

import java.util.Scanner;

public class PrintPermutationsOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        printPermutations(s, "");
    }
    private static void printPermutations(String ques, String ans) {
        if (ques.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            printPermutations(ques.substring(0, i) + ques.substring( i + 1, ques.length()), ans + ch);
        }
    }
}
