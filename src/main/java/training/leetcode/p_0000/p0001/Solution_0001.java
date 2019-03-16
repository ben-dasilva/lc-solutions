package training.leetcode.p_0000.p0001;

import java.util.HashMap;
import java.util.Map;

/*
 * LC-0001: Two Sum
 *
 * Given an array of integers, return indices of the two numbers such
 * that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and
 * you may not use the same element twice.
 */
public class Solution_0001 {
    int findMatch(Map<Integer, Integer> numMap, int i, int diff) {
        Integer j = numMap.get(diff);

        return (j == null || j == i) ? -1 : j;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int j = findMatch(numMap, i, target - nums[i]);

            numMap.put(nums[i], i);

            if (j >= 0) return new int[] {j, i};
        }

        return new int[] {};
    }
}
