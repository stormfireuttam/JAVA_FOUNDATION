package Recursion.UsingArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class KeypadCombinations {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<String> words = getKPC(input);
        System.out.println(words);
    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tu", "vwx", "yz"};
    private static ArrayList<String> getKPC(String input) {
        if (input.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        //If string 573
        char ch = input.charAt(0);  //5
        String remStr = input.substring(1); //73
        ArrayList<String> recResRemStr = getKPC(remStr); // 6 words
        ArrayList<String> result = new ArrayList<>();   // 18 words
        for (int i = 0; i < codes[ch - '0'].length(); i++) {
            char chofCode = codes[ch - '0'].charAt(i);
            for (String rStr: recResRemStr) {
                result.add(chofCode+rStr);
            }
        }
        return result;
    }
}
