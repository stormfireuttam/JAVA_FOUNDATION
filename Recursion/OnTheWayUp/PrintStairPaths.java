package Recursion.OnTheWayUp;

import java.util.Scanner;

public class PrintStairPaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printStairPaths(n, "");
    }
    private static void printStairPaths(int n, String ans) {
        if (n == 0)
        {
            System.out.println(ans);
            return;
        }
        if (n < 0) {
            return;
        }
        printStairPaths(n - 1, ans + "1");
        printStairPaths(n - 2, ans + "2");
        printStairPaths(n - 3, ans + "3");
    }

}
