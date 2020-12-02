package PatternPrinting;
import java.util.Scanner;

public class FibonacciTriangularPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int fib[] = new int[ (n*n)/2 + n/2 + 1];
        fib[0] = 0; fib[1] = 1;
        for (int i = 2; i < (n*n)/2+ n/2 + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(fib[k] + "\t");
                k ++;
            }
            System.out.println();
        }
    }
}
