package PatternPrinting;

public class BarChart {
    public static void main(String[] args) {
        printBarChart(5, new int[]{2,1,3,4,5});
        printBarChart(5, new int[]{3, 1, 0, 7, 5});
    }
    public static void printBarChart(int n, int arr[]) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
        }
        for (int i = max; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (arr[j] >= i) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
