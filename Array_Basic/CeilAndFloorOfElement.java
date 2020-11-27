package Array_Basic;

public class CeilAndFloorOfElement {
    public static void main(String[] args) {
        computeCeilAndFloor(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, 33);
        System.out.println();
        computeCeilAndFloor(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}, 50);
    }
    public static void computeCeilAndFloor(int arr[], int x) {
        int ceil = 0, floor = 0;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }
            else if (arr[mid] > x) {
                high = mid - 1;
                ceil = arr[mid];
            }
            else {
                low = mid + 1;
                floor = arr[mid];
            }
        }
        System.out.println("Ceil: " + ceil + "\n" +
                "Floor: " + floor);
    }
}
