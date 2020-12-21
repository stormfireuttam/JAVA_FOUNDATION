package DynamicProgramming;

import java.util.Scanner;

public class BuildingArrangements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // There are two lanes around the road
        // Each lane can have any permutation but no two buildings must appear together
        // The final result would be the square of possible ways of one lane
        int countBuildings = 1;
        int countSpaces = 1;
        for(int i = 2; i <= n; i ++) {
            int currB = countSpaces;
            int currS = countSpaces + countBuildings;
            countSpaces = currS;
            countBuildings = currB;
        }
        int total = countSpaces + countBuildings;
        System.out.println(total * total);
    }
}
