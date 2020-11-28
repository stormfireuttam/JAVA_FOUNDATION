//Saddle Point is a point which has the least value in the row whereas max value in the column
package TwoDimArrray;
import java.util.Scanner;

public class SaddlePoint {
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
        findSaddlePoint(arr);
    }

    private static void findSaddlePoint(int[][] arr) {
        boolean isSaddlePoint = true;
            int x;
            for (int i = 0; i < arr.length; i++) {
                x = arr[i][0];
                int potentialCandidateIndex = 0;
                for (int j = 1; j < arr[0].length; j++) {
                    if (arr[i][j] < x) {
                        x = arr[i][j];
                        potentialCandidateIndex = j;
                    }
                }
                isSaddlePoint = true;

                for (int j = 0; j < arr.length ; j++) {
                    if (arr[j][potentialCandidateIndex] > x) {
                        isSaddlePoint = false;
                        break;
                    }
                }
                if(isSaddlePoint == true) {
                    System.out.println(x + " at " + i + ", " + potentialCandidateIndex);
                    break;
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
