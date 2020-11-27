//Steps to Rotate an Array by k
//Step 1: resolve k  ==>   a) If k is negative then k = arr.length + k
//                         b) If k is greater than arr.length than k = k % arr.length
//Step 2: Reverse subarray from [0] to [arr.length - k - 1]
//Step 3: Reverse subarray from [arr.length - k] to [arr.length - 1]
//Step 4: Reverse the whole array

package Array_Basic;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        printRotatedArray(new int[]{1,2,3,4,5,6,7,8,9,10}, 4);
        printRotatedArray(new int[]{1,2,3,4,5,6,7,8,9,10}, 3);
        printRotatedArray(new int[]{1,2,3,4,5,6,7,8,9,10}, 6);
    }
    public static void printRotatedArray(int arr[], int k) {
        k = k % arr.length;
        if (k < 0) {
            k = k + arr.length;
        }
        int ptr1 = 0, ptr2 = arr.length - k - 1;
        while (ptr1 < ptr2) {
            int t = arr[ptr1];
            arr[ptr1] = arr[ptr2];
            arr[ptr2] = t;
            ptr1 ++; ptr2 --;
        }
        ptr1 = arr.length - k;
        ptr2 = arr.length - 1;
        while (ptr1 < ptr2) {
            int t = arr[ptr1];
            arr[ptr1] = arr[ptr2];
            arr[ptr2] = t;
            ptr1 ++; ptr2 --;
        }
        for (int i = 0; i < arr.length/2; i++) {
            int t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
        System.out.println(Arrays.toString(arr));
    }
}
