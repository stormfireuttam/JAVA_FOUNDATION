package Recursion.OnTheWayUp;

import java.util.Scanner;

public class PrintMazePathWithJumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        printMazePathsWithJumps(1, 1, m, n, "");
    }
    private static void printMazePathsWithJumps(int startRow, int startCol, int desRow, int desCol, String ans) {
        if (startCol == desCol && startRow == desRow) {
            System.out.println(ans);
            return;
        }
        if (startRow > desRow || startCol > desCol) {
            return;
        }
        //Horizontal Moves
        for (int move = 1; move <= desCol - startCol; move++) {
            printMazePathsWithJumps(startRow, startCol + move, desRow, desCol, ans + "h" + move);
        }
        //Vertical Moves
        for (int move = 1; move <= desRow - startRow; move ++) {
            printMazePathsWithJumps(startRow + move, startCol, desRow, desCol, ans + "v" + move);
        }
        //Diagonal Moves
        for (int move = 1; move <= desRow - startRow && move <= desCol - startCol ; move++) {
            printMazePathsWithJumps(startRow + move, startCol + move, desRow, desCol, ans + "d" + move);
        }
    }
}
