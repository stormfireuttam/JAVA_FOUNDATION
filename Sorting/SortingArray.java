package Sorting;

import java.util.Arrays;

public class SortingArray {
//    static int numberOfSwaps = 0;
    public static void swap(int arr[], int i, int j) {
//        numberOfSwaps ++;
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static boolean isSmaller(int arr[], int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] > arr[j])
            return false;
        else
            return true;
    }
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (isSmaller(arr, j + 1, j))
                    swap(arr, j, j + 1);
            }
        }
    }
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (isSmaller(arr, j, minIndex))
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isSmaller(arr, j + 1, j))
                    swap(arr, j + 1, j);
                else
                    break;
            }
        }
    }
    public static int[] merge(int a[], int b[]) {
        int res[] = new int[a.length + b.length];
        int k = 0, aPtr = 0, bPtr = 0;
        while (aPtr < a.length && bPtr < b.length) {
            if (a[aPtr] > b[bPtr]) {
                res[k ++] = b[bPtr];
                bPtr ++;
            }
            else {
                res[k ++] = a[aPtr];
                aPtr ++;
            }
        }
        while (aPtr < a.length) {
            res[k ++] = a[aPtr];
            aPtr ++;
        }
        while (bPtr < b.length) {
            res[k ++] = b[bPtr];
            bPtr ++;
        }
        return res;
    }

    public static int[] mergeSort(int a[]) {
        return mergeSortHelper(a, 0, a.length - 1);
    }
    private static int[] mergeSortHelper(int[] a, int low, int high) {
        if (low == high)
            return new int[]{a[low]};
        int mid = low + (high - low) / 2;
        return merge(mergeSortHelper(a, low, mid), mergeSortHelper(a, mid + 1, high));
    }
    public static void partition(int arr[], int pivot) {
        // 0 to j-1    <= pivot
        // j to i-1     > pivot
        // i to end     unknown
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] > pivot) {
                i ++;
            } else {
                swap(arr, i, j);
                i ++;
                j ++;
            }
        }
    }

    public static void quickSort(int arr[]) {
        quickSortHelper(arr, 0, arr.length - 1);
    }
    private static int partition(int arr[], int low, int high, int pivot) {
        int i = low, j = low;
        while (i <= high) {
            if (arr[i] > pivot)
                i ++;
            else {
                swap(arr, i, j);
                i ++;
                j ++;
            }
        }
        return j - 1;
    }
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = arr[high];
        int partition = partition(arr, low, high, pivot);
        quickSortHelper(arr, low, partition - 1);
        quickSortHelper(arr, partition + 1, high);
    }

    public static void main(String[] args) {
        int arr[] = {32, 46, 11, 32, 34, 21, 32, 12, 1, 43, 53};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
//        int a[] = {1,3,5,7,9}, b[] = {2,3,4,6,8};
//        int res[] = merge(a, b);
//        System.out.println(Arrays.toString(res));
//        int arr2[] = {7, 9, 8, 4, 3, 6, 2, 1};
//        System.out.println(Arrays.toString(arr2));
//        partition(arr2, 5);
//        System.out.println(Arrays.toString(arr2));
    }
}
