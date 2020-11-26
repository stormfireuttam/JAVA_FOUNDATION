package NumberSystem;

public class AnyBaseMultiplication {
    public static void main(String[] args) {
        System.out.println(multiply(52, 126, 10));
        System.out.println(multiply(76, 234, 8));
        System.out.println(multiply(31, 1220, 5));
    }
    public static int multiply(int a, int b, int base) {
        int result = 0;
        int carry = 0;
        int powA = 0;
        while(a > 0){
            int digitA = a % 10;
            int temp = b;
            int pow = 0;
            int pro = 0;
            while (temp > 0) {
                int digitB = temp % 10;
                int product = digitA * digitB + carry;
                pro = (int) (((product % base) * Math.pow(10, pow ++)) + pro);
                carry = product / base;
                temp/=10;
            }
            pro = (int) (((carry) * Math.pow(10, pow ++)) + pro);
            result = add(result, pro * (int)Math.pow(10, powA ++), base);
            a/= 10;
        }
        return result;
    }
    public static int add(int a, int b, int base) {
        int carry = 0;
        int result = 0;
        int p = 0;
        while(a > 0 || b > 0) {
            int d1 = a % 10, d2 = b % 10;
            result = (int) ((((d1 + d2) % base) * Math.pow(10, p++)) + result);
            carry = (d1 + d2) / base;
            a /= 10;
            b /= 10;
            a += carry;
        }
        return result;
    }
}
