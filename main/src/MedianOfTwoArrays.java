import java.util.Arrays;

//Approach 1: Naive Merging (Linear Time Complexity)
//Approach 2: Divide and Conquer (Logarithmic Time Complexity)
public class MedianOfTwoArrays {

    public static double findMedianNaive(int[] a, int[] b)
    {
        int[] merged = new int[a.length + b.length];
        System.arraycopy(a, 0, merged, 0, a.length);
        System.arraycopy(b, 0, merged, a.length, b.length);

        Arrays.sort(merged);

        int n = merged.length;
        if (n % 2 == 0) {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        } else {
            return merged[n / 2];
        }
    }

    public static double findMedianDivideConquer(int[] a, int[] b)
    {

        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int totalLength = a.length + b.length;
        int halfLength = (totalLength + 1) / 2;

        int low = 0;
        int high = a.length;

        while (low <= high)
        {
            int partitionA = (low + high) / 2;
            int partitionB = halfLength - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];
            int minRightA = (partitionA == a.length) ? Integer.MAX_VALUE : a[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
            int minRightB = (partitionB == b.length) ? Integer.MAX_VALUE : b[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA)
            {
                if (totalLength % 2 == 0) {
                    return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        int[] a1 = {-5, 3, 6, 12, 15};
        int[] b1 = {-12, -10, -6, -3, 4, 10};
        System.out.println("findMedianNaive: The median is: " + findMedianNaive(a1, b1));
        System.out.println("findMedianDivideConquer: The median is: " + findMedianDivideConquer(a1, b1));

        int[] a2 = {2, 3, 5, 8};
        int[] b2 = {10, 12, 14, 16, 18, 20};
        System.out.println("findMedianNaive: The median is: " + findMedianNaive(a2, b2));
        System.out.println("findMedianDivideConquer: The median is: " + findMedianDivideConquer(a2, b2));
    }

}
