package Recursion.UsingArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(getMazePaths(1, 1, n, m));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        if (sr > dr || sc > dc) {
            ArrayList<String> baseRes = new ArrayList<>();
            return baseRes;
        }

        ArrayList<String> horizontalPaths = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> verticalPaths = getMazePaths(sr + 1, sc, dr, dc);

        ArrayList<String> result = new ArrayList<>();
        for (String path: horizontalPaths) {
            result.add("h"+path);
        }
        for (String path: verticalPaths) {
            result.add("v"+path);
        }
        return result;
    }
}
