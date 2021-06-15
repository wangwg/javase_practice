package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * xiaOgang
 */
class SolutionTwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {0, 0};
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) && i != map.get(another)) {
                result[0] = i;
                result[1] = map.get(another);
            }
        }

        return result;
    }

}

public class TwoSum {
    public static void main(String[] args) {
        SolutionTwoSum solution = new SolutionTwoSum();
        int[] nums = {3, 3};
        int[] result = solution.twoSum(nums, 6);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }
}
