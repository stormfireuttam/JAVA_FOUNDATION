package String_Basic;
import java.util.ArrayList;
import java.util.Scanner;

public class StringSubsequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(subsequences(s));
    }

    private static ArrayList<String> subsequences(String s) {
        if (s.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add(" ");
            return res;
        }
        char ch = s.charAt(0);
        String remStr = s.substring(1);
        ArrayList<String> rres = subsequences(remStr);

        ArrayList<String> finalRes = new ArrayList<>();
        for (String rStr: rres) {
            finalRes.add(rStr);
            finalRes.add(ch + rStr);
        }
        return finalRes;
    }

}
