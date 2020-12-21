package DynamicProgramming;

import java.util.Scanner;

public class BinaryStringsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Count Binary Strings with no consecutive zeros
        int countZeros = 1;
        int countOnes = 1;
        for (int i = 2; i <= n; i++) {
            int currZeros = countOnes;
            int currOnes = countZeros + countOnes;
            countZeros = currZeros;
            countOnes = currOnes;
        }
        System.out.println("Binary String with no consecutive zeros: " + (countZeros + countOnes));
        //Count Binary Strings with no consecutive ones
        countOnes = 1;
        countZeros = 1;
        for (int i = 2; i <= n; i++) {
            int currZeros = countOnes + countZeros;
            int currOnes = countZeros;
            countZeros = currZeros;
            countOnes = currOnes;
        }
        System.out.println("Binary Strings with no consecutive ones: " + (countZeros + countOnes));
    }
}
