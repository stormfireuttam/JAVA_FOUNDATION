package Recursion.BackTracking;

import java.util.Scanner;

public class TargetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int targetSum = scanner.nextInt();
        printPossibleSet(arr, 0, "", 0, targetSum);
    }
    private static void printPossibleSet(int[] arr, int index, String setString, int setSum, int targetSum) {
        if (index == arr.length) {
            if (setSum == targetSum)
                System.out.println(setString);
            return;
        }
        printPossibleSet(arr, index + 1, setString + arr[index] + ", ", setSum + arr[index], targetSum);
        printPossibleSet(arr, index + 1, setString, setSum, targetSum);
    }
}
