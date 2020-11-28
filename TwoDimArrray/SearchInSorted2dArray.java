package TwoDimArrray;

import java.util.Scanner;

public class SearchInSorted2dArray {
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

        findIndex(arr, Integer.parseInt(scanner.nextLine()));
    }

    private static void findIndex(int[][] arr, int x) {
        int currI = 0, currJ = arr[0].length - 1;
        boolean found = false;
        while ((currI >= 0 && currI < arr.length) & (currJ >= 0 && currJ < arr[0].length)) {
            if (x == arr[currI][currJ]) {
                found = true;
                break;
            }
            else if (x > arr[currI][currJ]) {
                currI ++;
            }
            else {
                currJ --;
            }
        }
        if (found) {
            System.out.println(currI + 1 + ", " + (currJ + 1));
        }
        else
            System.out.println("Not Found");
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
