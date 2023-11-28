import java.util.Arrays;

public class FindMedian {
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int i = arr1.length;
        int j = arr2.length;

        int[] arr3 = new int[i + j];

        // Merge both arrays into one array
        System.arraycopy(arr1, 0, arr3, 0, i);
        System.arraycopy(arr2, 0, arr3, i, j);

        // Sort the merged array
        Arrays.sort(arr3);

        // Find the median
        int n = arr3.length;
        if (n % 2 == 0) { // If the length is even
            int mid = n / 2;

            return (arr3[mid] + arr3[mid - 1]) / 2.0;
        } else { // If the length is odd

            return arr3[n / 2]; // Median calculation
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };

        double median = findMedianSortedArrays(arr1, arr2);
        System.out.println("Median = " + median);
    }
}
