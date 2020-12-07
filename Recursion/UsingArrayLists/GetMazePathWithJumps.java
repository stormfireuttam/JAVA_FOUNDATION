package Recursion.UsingArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathWithJumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(getMazePathWithJumps(1, 1, m, n));
    }

    private static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc) {
        if (sr == dr && dc == sc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        if (sr > dr || sc > dc) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        ArrayList<String> myResult = new ArrayList<>();

        //Horizontal Moves
        for (int ms = 1; ms <= dc - sc; ms++) {
            ArrayList<String> hPaths = getMazePathWithJumps(sr, sc+ ms, dr, dc);
            for (String hPath : hPaths) {
                myResult.add("h"+ms+hPath);
            }
        }
        //Vertical Moves
        for (int ms = 1; ms <= dr - sr; ms++) {
            ArrayList<String> vPaths = getMazePathWithJumps(sr + ms, sc, dr, dc);
            for (String vPath : vPaths) {
                myResult.add("v"+ms+vPath);
            }
        }
        //Diagonal Moves
        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            ArrayList<String> dPaths = getMazePathWithJumps(sr + ms, sc + ms, dr, dc);
            for(String dPath : dPaths) {
                myResult.add("d"+ms+dPath);
            }
        }
        return myResult;
    }
}
