package com.algorithm.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * xiaOgang LeetCode #128
 */
public class SolutionLongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int result = 0;

        Set<Integer> hashSet = new HashSet<>();

        for (int num : nums)
            hashSet.add(num);

        for (int num : nums) {
            int currentNum = num;
            int currentLength = 1;

            if (hashSet.contains(currentNum - 1)) continue;

            while (hashSet.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }

            result = result >= currentLength ? result : currentLength;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(new SolutionLongestConsecutive().longestConsecutive(nums));
        System.out.println(new SolutionLongestConsecutive().longestConsecutive(nums1));
    }
}
