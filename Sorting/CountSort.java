package Sorting;
import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int count[] = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i] - min] ++;
        }
        int res[] = new int[n];
        int i = 0, j = 0;
        while (i < count.length) {
            while (count[i] > 0) {
                res[j ++] = min + i;
                count[i] --;
            }
            i ++;
        }
        System.out.println(Arrays.toString(res));
    }
}
