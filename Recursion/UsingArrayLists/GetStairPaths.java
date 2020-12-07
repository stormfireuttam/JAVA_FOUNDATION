package Recursion.UsingArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        ArrayList<String> getStairs = getPath(n);
        System.out.println(getStairs);
    }
    private static ArrayList<String> getPath(int n) {
        if (n == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        if (n < 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            return baseRes;
        }
        ArrayList<String> paths1 = getPath(n - 1);
        ArrayList<String> paths2 = getPath(n - 2);
        ArrayList<String> paths3 = getPath(n - 3);

        ArrayList<String> result = new ArrayList<>();
        for (String path: paths1) {
            result.add(1 + path);
        }
        for (String path: paths2) {
            result.add(2 + path);
        }
        for (String path: paths3) {
            result.add(3 + path);
        }
        return result;
    }
}
