// Input array:    {a, b, c}
// Output:         { {a}, {b}, {c}, {a,b}, {a,c}, {b,c}, {a,b,c}, null}
//So steps for creating a powerset of array:
// Step 1: Calculate the limit i.e. the number of permutations of our string
//         and that would simply be,
//         limit = Math.pow(2, n) wherein n is the length of the array
// Step 2: Iterate through an outer loop from 0 to limit
//         and  an inner loop from [n - 1] to [0]
// Step 3: At each iteration check if value of rem i.e. t % 2 == 0 and if so
//         add character to result string else add a hyphen(-)
package Array_Basic;

import java.util.Scanner;

public class SubsetOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String arr[] = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        String res;
        int limit = (int) Math.pow(2, n);
        for (int i = 0; i < limit; i++) {
            res = "";
            int t = i;
            for (int j = arr.length - 1; j >= 0; j --) {
                if(t % 2 != 0) {
                    res = arr[j] + res;
                }
                else {
                    res = "-" + res;
                }
                t /= 2;
            }
            System.out.println(res);
        }
    }
}
