package Sorting;

import java.util.Scanner;

public class SortDates {
    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }
    private static void sortDates(String[] arr) {
        countSort(arr, 1000000, 100, 32);   //dates
        countSort(arr, 10000, 100, 13);     //months
        countSort(arr, 1, 10000, 2501);     //years
    }
    private static void countSort(String[] arr, int div, int mod, int range) {
        String res[] = new String[arr.length];
        int count[] = new int[range];
        for (int i = 0; i < arr.length; i++) {
            int pos = Integer.parseInt(arr[i]) / div % mod;
            count[pos] ++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i --) {
            int pos = count[Integer.parseInt(arr[i]) / div % mod] - 1;
            res[pos] = arr[i];
            count[Integer.parseInt(arr[i]) / div % mod] --;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }
}
