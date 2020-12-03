package String_Basic;

import java.util.Scanner;

public class StringPermutations {
    //Find permutations of a string
    public static void permutations(String s) {
        int fact = 1;
        for (int i = 2; i <= s.length(); i++) {
            fact *= i;
        }
        for (int i = 0; i < fact; i++) {
            int t = i;
            StringBuilder sb = new StringBuilder(s);
            for (int div = s.length(); div > 0; div --) {
                System.out.print(sb.charAt(t % div));
                sb.deleteCharAt(t % div);
                t = t / div;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        permutations(str);
    }
}
