package Array_Basic;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(isFoundIterative(new int[] {1,2,3,45,34,5,23,43}, 21));
        System.out.println(isFoundIterative(new int[] {1,2,3,45,34,5,23,43}, 34));
        System.out.println(binarySearchRecursive(new int[] {1,2,3,45,34,5,23,43}, 21, 0, 8));
        System.out.println(binarySearchRecursive(new int[] {1,2,3,45,34,5,23,43}, 45, 0, 8));
    }
    public static boolean isFoundIterative(int []arr, int x) {
        int f = 0, l = arr.length - 1;
        while (f < l) {
            int mid = f + (l - f) / 2;
            if (arr[mid] == x){
                return true;
            }
            else if(arr[mid] > x) {
                l = mid - 1;
            }
            else {
                f = mid + 1;
            }
        }
        return false;
    }
    public static int binarySearchRecursive(int []arr, int x, int f, int l) {
        l --;
        if(l >= f) {
            int mid = f + (l - f) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                return binarySearchRecursive(arr, x, f, mid - 1);
            else
                return binarySearchRecursive(arr, x, mid + 1, l);
        }
        return -1;
    }
}
