package TwoDimArrray;

import java.util.Scanner;

public class ExitPointOfMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter m and n of 2d array: ");
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter array elements: ");
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("ARRAY : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        int currI = 0, currJ = 0, dir = 0;
        while (true) {
            dir = (dir + arr[currI][currJ]) % 4;
            //Go East
            if (dir == 0) {
                currJ ++;
            }
            //Go South
            else if (dir == 1) {
                currI ++;
            }
            //Go West
            else if (dir == 2) {
                currJ --;
            }
            //Go North
            else if(dir == 3) {
                currI --;
            }
            //Breaking Cases
            if (currI < 0) {
                currI ++; break;
            }
            if (currJ < 0) {
                currJ ++; break;
            }
            if (currI > m) {
                currI --; break;
            }
            if (currJ > n) {
                currJ --; break;
            }
        }

        System.out.println((currI + 1) + ", " + (currJ + 1));
    }
}
