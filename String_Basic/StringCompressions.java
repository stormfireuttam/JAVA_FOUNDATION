package String_Basic;

import java.util.Scanner;

public class StringCompressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(compression1(s));
        System.out.println(compression2(s));
    }

    private static String compression2(String s) {
        String res = "";
        res +=  s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i), prev = s.charAt(i - 1);
            if (curr != prev){
                res += count;
                res += s.charAt(i);
                count = 1;
            }
            else
                count ++;
        }
        res += count;
        return res;
    }

    private static String compression1(String s) {
        String res = "";
        res += s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i), prev = s.charAt(i - 1);
            if (curr != prev)
                res += s.charAt(i);
        }
        return res;
    }
}
