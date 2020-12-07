package Recursion.OnTheWayUp;

import java.util.Scanner;

public class PrintMazePaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        printMazePath(1, 1, m, n, "");
    }
    private static void printMazePath(int startRow, int startCol, int desRow, int desCol, String ans) {
        if (startCol == desCol && startRow == desRow) {
            System.out.println(ans);
            return;
        }
        if (startCol > desCol || startRow > desRow) {
            return;
        }
        //Horizontal Moves
        printMazePath(startRow, startCol + 1, desRow, desCol, ans + "h");
        //Vertical Moves
        printMazePath(startRow + 1, startCol, desRow, desCol, ans + "v");
        //Diagonal Moves
        printMazePath(startRow + 1, startCol + 1, desRow, desCol, ans + "d");
    }
}
