package Sorting;

import java.util.Scanner;

public class QuickSelect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        quickSelect(arr, k);
    }
    private static void quickSelect(int[] arr, int k) {
        System.out.println(quickSelectHelper(arr, 0, arr.length - 1, k - 1));
    }
    private static int quickSelectHelper(int[] arr, int low, int high, int k) {
        int pivot = arr[high];
        int partition = getPartition(arr, low, high, pivot);
        if (partition > k) {
            quickSelectHelper(arr, low, partition - 1, k);
        } else if(partition < k) {
            quickSelectHelper(arr, partition + 1, high, k);
        }
        return pivot;
    }
    private static int getPartition(int[] arr, int low, int high, int pivot) {
        int i = low, j = low;
        while (i <= high) {
            if (arr[i] > pivot) {
                i ++;
            }
            else {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i ++;
                j ++;
            }
        }
        return j - 1;
    }
}
