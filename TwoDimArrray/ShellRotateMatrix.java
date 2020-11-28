//Steps to Shell Rotate your matrix:
//Step 1: Extract the Shell
//Step 2: Rotate the extracted shell by k
//Step 3: Insert the extracted shell back to our matrix

package TwoDimArrray;

import java.util.Arrays;
import java.util.Scanner;

public class ShellRotateMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter m of m*m array: ");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter array elements: ");
        int arr[][] = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("ARRAY : ");
        display(arr);
        int s = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        shellRotateMatrix(arr, s, k);
    }

    private static void shellRotateMatrix(int arr[][], int s, int k) {
        int oneDArray[] = getOneDArray(arr, s);
        System.out.println("Extracted 1-D Array: " + Arrays.toString(oneDArray));
        rotate(oneDArray, k);
        System.out.println("Rotated 1-D Array: " + Arrays.toString(oneDArray));
        fillTwoDimArray(arr, oneDArray, s);
        System.out.println("Shell Sorted 2d Array: ");
        display(arr);
    }

    private static int[][] fillTwoDimArray(int[][] arr, int[] oneDArray, int s) {
        int k = 0;
        for(int i = s-1; i <= arr.length - s; i ++) {
            arr[i][s-1] = oneDArray[k ++];
        }
        for (int i = s; i <= arr[0].length - s; i++) {
            arr[arr.length - s][i] = oneDArray[k ++];
        }
        for(int i = arr.length - s - 1; i >= s - 1; i --) {
            arr[i][arr[0].length-s] = oneDArray[k ++];
        }
        for (int i = arr[0].length-s-1; i >= s ; i --) {
            arr[s-1][i] = oneDArray[k ++];
        }
        return arr;
    }

    private static int[] rotate(int[] oneDArray, int k) {
        if (k < 0) {
            k = oneDArray.length + k;
        }
        k = k % oneDArray.length;
        int leftPtr = oneDArray.length - k, rightPtr = oneDArray.length - 1;
        reverse(oneDArray, leftPtr, rightPtr);
        leftPtr = 0; rightPtr = oneDArray.length - k - 1;
        reverse(oneDArray, leftPtr, rightPtr);
        leftPtr = 0; rightPtr = oneDArray.length - 1;
        reverse(oneDArray, leftPtr, rightPtr);
        return oneDArray;
    }

    private static int[] reverse(int[] oneDArray, int leftPtr, int rightPtr) {
        while (leftPtr < rightPtr) {
            int t = oneDArray[leftPtr];
            oneDArray[leftPtr] = oneDArray[rightPtr];
            oneDArray[rightPtr] = t;
            leftPtr ++;
            rightPtr --;
        }
        return oneDArray;
    }

    private static int[] getOneDArray(int[][] arr, int s) {
        int a[] = new int[(arr.length + arr[0].length) * 2];
        int k = 0;
        for(int i = s-1; i <= arr.length - s; i ++) {
            a[k++] = arr[i][s-1];
        }
        for (int i = s; i <= arr[0].length - s; i++) {
            a[k++] = arr[arr.length - s][i];
        }
        for(int i = arr.length - s - 1; i >= s - 1; i --) {
            a[k++] = arr[i][arr[0].length-s];
        }
        for (int i = arr[0].length-s-1; i >= s ; i --) {
            a[k++] = arr[s-1][i];
        }
        return Arrays.copyOfRange(a, 0, k);
    }

    public static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
