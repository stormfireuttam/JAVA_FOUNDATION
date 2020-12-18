package DynamicProgramming;

import java.util.Scanner;

public class FibonacciDp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacciMemoiz(n, new int[n + 1]));
    }
    private static int fibonacciMemoiz(int n, int[] qbank) {
        if (n == 0 || n == 1) {
            qbank[n] = n;
            return n;
        }
        if (qbank[n] != 0) {
            return qbank[n];
        }
        return fibonacciMemoiz(n - 1, qbank) + fibonacciMemoiz(n - 2, qbank);
    }

}