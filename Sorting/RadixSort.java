package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        for (int divFactor = 1; divFactor <= max; divFactor *= 10) {
            countSort(arr, divFactor);
        }
    }
    private static void countSort(int[] arr, int divFactor) {
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] / divFactor % 10] ++;
        }
        int res[] = new int[arr.length];
        // Convert count array into prefix sum array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // Filling the result array
        for (int i = 0; i < arr.length; i++) {
            int pos = count[arr[i] / divFactor % 10] - 1;
            res[pos] = arr[i];
            count[arr[i] / divFactor % 100] --;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }
}
