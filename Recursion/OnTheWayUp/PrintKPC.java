package Recursion.OnTheWayUp;

import java.util.Scanner;

public class PrintKPC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printKPC(input, "");
    }
    public static String codes[] = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKPC(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        for (int i = 0; i < codes[ch - '0'].length(); i++) {
            char chCode = codes[ch - '0'].charAt(i);
            printKPC(roq, ans + chCode);
        }
    }
}
