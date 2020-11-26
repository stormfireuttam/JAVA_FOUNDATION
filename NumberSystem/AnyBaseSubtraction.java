package NumberSystem;

public class AnyBaseSubtraction {
    public static void main(String[] args) {
        System.out.println(subtract(326, 540, 10));
        System.out.println(subtract(236, 1212, 8));
        System.out.println(subtract(256, 1212, 8));
        System.out.println(subtract(21, 202, 7));
    }
    public static String subtract(int a, int b, int base) {
        String result = "";
        int borrow = 0;
        while (a > 0 || b > 0) {
            int digitB = b % 10, digitA = a % 10;
            if(digitB < digitA) {
                result = (base + digitB - digitA) + result;
                b /= 10;
                a /= 10;
                b --;
            }
            else
            {
                result = (digitB - digitA) + result;
                b /= 10;
                a /= 10;
            }
        }
        return result;
    }
}
