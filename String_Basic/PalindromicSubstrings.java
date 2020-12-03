package String_Basic;

import java.util.Scanner;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length() ; j++) {
                String sb = s.substring(i, j);
                if (isPalindrome(sb)) {
                    System.out.println(sb);
                }
            }
        }
    }

    private static boolean isPalindrome(String sb) {
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r))
                return false;
            l ++; r --;
        }
        return true;
    }
}
