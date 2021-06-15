package com.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * xiaOgang
 */
class SolutionThreeNums {
    public List<List<Integer>> threeSum(int[] nums) {

        final int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {

            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0)
                    left++;
                else
                    right--;
            }

        }

        return result;

    }
}

public class ThreeNums {
    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};

        List result = new SolutionThreeNums().threeSum(input);

        System.out.println(result);
    }
}
