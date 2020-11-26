package NumberSystem;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        System.out.println(convert(135, 2));
        System.out.println(convert(63, 8));
        System.out.println(convert(165, 16));
    }
    public static String convert(int n, int base) {
        String s = "";
        while(n > 0) {
            int rem = n % base;
            if(rem > 9) {
                s = getEquivalentHexa(rem) + s;
            }
            else
                s = rem + s;
            n /= base;
        }
        return s;
    }
    public static String getEquivalentHexa(int x) {
        switch (x) {
            case 10: return "A";
            case 11: return "B";
            case 12: return "C";
            case 13: return "D";
            case 14: return "E";
            case 15: return "F";
        }
        return "";
    }
}
