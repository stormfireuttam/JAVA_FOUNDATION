package Recursion.BackTracking;

import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int chess[][] = new int[n][n];
        printNQueens(chess, 0, "");
    }
    private static void printNQueens(int chess[][], int row, String pathSoFar) {
        if (row == chess.length)
        {
            System.out.println(pathSoFar);
            return;
        }
        for (int col = 0; col < chess.length; col ++) {
            if(isSafe(chess, row, col)){
                chess[row][col] = 1;
                printNQueens(chess, row + 1, pathSoFar + row + "-" + col + ", ");
                chess[row][col] = 0;
            }
        }
    }
    private static boolean isSafe(int[][] chess, int row, int col) {
        //Checking Vertically
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1)
                return false;
        }
        //Checking for Left Diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i --, j --) {
            if (chess[i][j] == 1)
                return false;
        }
        //Checking for Right Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i --, j ++) {
            if (chess[i][j] == 1)
                return false;
        }
        return true;
    }
}
