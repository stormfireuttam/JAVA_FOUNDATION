package Array_Basic;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        printReverse(new int[]{1,2,3,4,5});
        printReverse(new int[]{1,2,3,4});
    }
    public static void printReverse(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
        System.out.println(Arrays.toString(arr));
    }
}
