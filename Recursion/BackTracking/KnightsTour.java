package Recursion.BackTracking;

import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int chess[][] = new int[n][n];
        knightsTour(chess, r, c, 1);
    }
    private static void knightsTour(int[][] chess, int row, int col, int move) {
        if (row < 0 || row >= chess.length || col < 0 || col >= chess.length || chess[row][col] != 0) {
            return;
        }
        else if (move == chess.length * chess.length) {
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        chess[row][col] = move;
        knightsTour(chess, row - 2, col + 1, move + 1);
        knightsTour(chess, row - 1, col + 2, move + 1);
        knightsTour(chess, row + 1, col + 2, move + 1);
        knightsTour(chess, row + 2, col + 1, move + 1);
        knightsTour(chess, row + 2, col - 1, move + 1);
        knightsTour(chess, row + 1, col - 2, move + 1);
        knightsTour(chess, row - 1, col - 2, move + 1);
        knightsTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    private static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i ++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
