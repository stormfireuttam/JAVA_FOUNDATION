package NumberSystem;

public class AnyBaseAddition {
    public static void main(String[] args) {
        System.out.println(add(346, 777, 8));
        System.out.println(add(320, 57, 10));
        System.out.println(add(1010, 101, 2));
    }
    public static String add(int a, int b, int base) {
        int carry = 0;
        String result = "";
        while(a > 0 || b > 0) {
            int d1 = a % 10, d2 = b % 10;
            result = ((d1 + d2) % base) + result;
            carry = (d1 + d2) / base;
            a /= 10;
            b /= 10;
            a += carry;
        }
        return result;
    }
}
