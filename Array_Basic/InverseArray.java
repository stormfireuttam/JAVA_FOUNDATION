package Array_Basic;

import java.util.Arrays;

// If array is zero indexed for example   indexes ->  0  1  2  3  4
//                                        values  ->  3  4  1  2  0
//After inversing the array the output would be:     indexes ->  0 1 2 3 4
//                                                   values  ->  4 2 3 0 1
public class InverseArray {
    public static void main(String[] args) {
        printInverse(new int[]{3,4,1,2,0}, 5);
    }
    public static void printInverse(int arr[], int n) {
        int inv[] = new int[n];
        for (int i = 0; i < n; i++) {
            int v = arr[i];
            inv[v] = i;
        }
        System.out.println(Arrays.toString(inv));
    }
}
