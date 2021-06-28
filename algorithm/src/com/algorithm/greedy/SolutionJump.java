package com.algorithm.greedy;

/**
 * xiaOgang #LeetCode #45
 */
public class SolutionJump {
    public int jump(int[] nums) {

        int steps = 0;

        int fastest = 0;
        int nextFastest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextFastest = Math.max(nextFastest, i + nums[i]);

            if (i == fastest) {
                fastest = nextFastest;
                steps++;

            }

        }


        return steps;

    }

    public static void main(String[] args) {

    }
}
