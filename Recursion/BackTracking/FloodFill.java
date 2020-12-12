package Recursion.BackTracking;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean visited[][] = new boolean[m][n];
        floodFill(arr, 0, 0, "", visited);
    }
    private static void floodFill(int[][] arr, int row, int col, String pathSoFar, boolean[][] visited) {
        if (row < 0 || col < 0 || row == arr.length || col == arr[0].length || arr[row][col] == 1 || visited[row][col] == true){
            return;
        }
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.println(pathSoFar);
            return;
        }
        visited[row][col] = true;
        floodFill(arr, row - 1, col, pathSoFar + "t", visited);
        floodFill(arr, row + 1, col, pathSoFar + "d", visited);
        floodFill(arr, row, col - 1, pathSoFar + "l", visited);
        floodFill(arr, row, col + 1, pathSoFar + "r", visited);
        visited[row][col] = false;
    }

}
