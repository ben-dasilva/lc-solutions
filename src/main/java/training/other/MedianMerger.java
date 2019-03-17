package training.other;

import java.util.Arrays;

public class MedianMerger {
    public double simpleMedian(int[] list) {
        int size = list.length;

        int middle = size / 2;

        float m = size % 2 == 1 ? list[middle] : (list[middle - 1] + list[middle]) / 2f;
        // System.out.printf("    {size: %d, middle: %d, median: %2.1f, list:%s}\n", size, middle, m, Arrays.toString(list));
        return m;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays(0, 0, nums1.length, nums1, 0, nums2.length, nums2);
    }

    public double findMedianSortedArrays(int level, int[] nums1, int[] nums2) {
        return findMedianSortedArrays(0, 0, nums1.length, nums1, 0, nums2.length, nums2);
    }

    public double findMedianSortedArrays(int level, int start1, int end1, int[] nums1, int start2, int end2, int[] nums2) {
        if (level > 4) {
            System.out.println("ERROR -- infinite recursion");
            return -1;
        }

        if (nums1.length == 0) return simpleMedian(nums2);
        if (nums2.length == 0) return simpleMedian(nums1);

        double a = simpleMedian(nums1);
        double b = simpleMedian(nums2);

        if (a == b) return a;

        int[] left;
        int[] right;

        if (a < b) {
            left = nums1;
            right = nums2;
        } else {
            left = nums2;
            right = nums1;
        }

        // get subsets
        int leftSize = left.length;
        int rightSize = right.length;

        int[] shorterList;
        int[] longerList;

        if (leftSize < rightSize) {
            shorterList = left;
            longerList  = right;
        } else {
            shorterList = right;
            longerList  = left;
        }

        if (longerList.length == 2) {
            // merge and return median
            return simpleMedian(merge(shorterList, longerList));
        }

        if (shorterList.length <= 2) {
            // get core elements
            int llen = longerList.length;
            // we'll keep a core of 3 to 4 elements
            // even llen/2
            boolean isEven = llen % 2 == 0;

            int leftBound  = isEven ? llen / 2 - 2 : llen / 2 - 1;
            int rightBound = isEven ? llen / 2 + 2 : llen / 2 + 2;

            return simpleMedian(merge(shorterList, Arrays.copyOfRange(longerList, Math.max(0, leftBound), Math.min(llen, rightBound))));
        }

        int chopSize = Math.min((leftSize-1)/2, (rightSize-1)/2);

        int[] smallerLeft  = Arrays.copyOfRange(left, chopSize, leftSize);
        int[] smallerRight = Arrays.copyOfRange(right, 0, rightSize - chopSize);

        return findMedianSortedArrays(level + 1, 0, 0, smallerLeft, 0, 0, smallerRight);
    }

    private int[] merge(int[] a, int[] b) {
        int[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        Arrays.sort(result);

        return result;
    }
}