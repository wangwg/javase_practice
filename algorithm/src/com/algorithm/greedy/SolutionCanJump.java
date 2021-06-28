package com.algorithm.greedy;

/**
 * xiaOgang LeetCode #55
 */
public class SolutionCanJump {

    public boolean canJump(int[] nums) {

        int fastest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i <= fastest) {
                fastest = Math.max(fastest, i + nums[i]);
                if (fastest >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};
        System.out.println(new SolutionCanJump().canJump(nums));
        System.out.println(new SolutionCanJump().canJump(nums1));
    }
}
