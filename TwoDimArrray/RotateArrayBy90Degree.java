// ARRAY :
//        1  2  3  4
//        5  6  7  8
//        9  10  11  12
//        13  14  15  16
// Transposed ARRAY :
//        1  5  9  13
//        2  6  10  14
//        3  7  11  15
//        4  8  12  16
// 90 degree Rotated ARRAY :
//        13  9  5  1
//        14  10  6  2
//        15  11  7  3
//        16  12  8  4
package TwoDimArrray;

import java.util.Scanner;

public class RotateArrayBy90Degree {
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        //Computing transpose
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int t = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = t;
            }
        }
        System.out.println("Transposed ARRAY : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        //Reversing the columns
        for (int i = 0; i < m; i++) {
            int lIndex = 0, rIndex = m - 1;
            while (lIndex < rIndex) {
                int t = arr[i][lIndex];
                arr[i][lIndex] = arr[i][rIndex];
                arr[i][rIndex] = t;
                lIndex ++; rIndex --;
            }
        }
        System.out.println("90 degree Rotated ARRAY : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
