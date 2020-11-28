//Traversing the upper triangular matrix
//You need two pointers for this approach one to maintain till which row we have to iterate and the other
//  to keep hold of from which column do we have to start
package TwoDimArrray;

import java.util.Scanner;

public class DiagonalTraversal {
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
        System.out.println("Diagonal Traversal: ");
        diagonalTraversal(arr);
    }

    private static void diagonalTraversal(int[][] arr) {
//        int endI = arr.length - 1, currJ = 0;
//        while (endI >=0 && currJ != arr.length+1) {
//            int i = 0, j = currJ;
//            while (i <= endI) {
//                System.out.print(arr[i][j] + " ");
//                i ++;
//                j ++;
//            }
//            currJ++;
//            endI --;
//        }
        for (int g = 0; g < arr.length; g++) {
            for (int i = 0, j = g; j < arr.length; i++, j ++) {
                System.out.print(arr[i][j] + " ");
            }
        }
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
