package Array_Basic;

public class SumTwoArrays {
    public static void main(String[] args) {
        sum(new int[]{3, 1, 0, 7, 5}, new int[]{1, 1, 1, 1, 1, 1});
    }
    public static void sum(int a[], int b[]) {
        int carry = 0, sum;
        int first = a.length - 1, second = b.length - 1;
        String output = "";
        while(true) {
            if(first >= 0 && second >= 0) {
                sum = a[first--] + b[second--] + carry;
                output = (sum % 10) + "\n" + output;
                carry = sum / 10;
            }
            else if(first >= 0) {
                sum = a[first--] + carry;
                output = (sum % 10)  + "\n" + output;
                carry = sum / 10;
            }
            else if(second >= 0) {
                sum = b[second --] + carry;
                output = (sum % 10) + "\n" + output;
                carry = sum / 10;
            }
            else {
                break;
            }
        }
        System.out.println(output);
    }
}
