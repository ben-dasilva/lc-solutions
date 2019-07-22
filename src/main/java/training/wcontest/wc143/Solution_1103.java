package training.wcontest.wc143;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1103 {
    public int[] distributeCandies(int candies, int num_people) {
        return seq(candies, num_people);
    }

    private static long maxForRow(int r, int n) {
        long maxRowSum = (long) n * (long) (n + 1) / 2;

        return maxRowSum*(r+1) + r*(n*n);
    }

    private static int rows(int candies, int n) {
        for (int i = 0; i < 100000; i++) {
            long mfr = maxForRow(i, n);
            if (mfr >= candies) return i+1;
        }
        return -1;
    }

    private static int[] seq(int candies, int n) {
        int r = rows(candies, n);

        int first = (r-1)*n + 1;

        int[] list = new int[n];

        // fill previous row
        if (r > 1) {
            int firstPrev = (r-2)*n + 1;

            for (int pos = 0; pos < n; pos++) {
                 int thisPerson = Math.min(candies, firstPrev);
                 candies -= thisPerson;
                 list[pos] = (thisPerson);
                 firstPrev++;
            }
        }

        System.out.println("intermediate list = " + Arrays.toString(list));
        System.out.println("candies left = " + candies);

        for (int pos = 0; pos < n; pos++) {
            int thisPerson = Math.min(candies, list[pos] + pos + 1 + n);
            candies -= thisPerson;
            list[pos] += thisPerson;
            System.out.println("candies left = " + candies);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution_1103 s = new Solution_1103();

        int rows = rows(60, 4);
        System.out.println("rows = " + rows);
        System.out.println(Arrays.toString(seq(60, 4)));
    }
}
