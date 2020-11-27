package Array_Basic;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        printFirstAndLastIndexOfArrayElement(new int[]{10, 10, 10, 20, 20, 20, 20, 30, 40, 40}, 20);
        printFirstAndLastIndexOfArrayElement(new int[]{10, 10, 10, 20, 20, 20, 20, 30, 40, 40}, 40);
    }
    public static void printFirstAndLastIndexOfArrayElement(int arr[], int x) {
        int candIndex = 0;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                candIndex = mid;
                low = mid + 1;
            }
            else if (arr[mid] > x) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        int lastIndex = candIndex, firstIndex;
        while (candIndex >= 0 && arr[candIndex] == x) {
            candIndex --;
        }
        firstIndex = candIndex + 1;
        System.out.println(firstIndex + " " + lastIndex);
    }
}
