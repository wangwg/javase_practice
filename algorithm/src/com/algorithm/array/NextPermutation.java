package com.algorithm.array;

/**
 * xiaOgang
 */
class SolutionNextPermutation {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int ascIndex = length - 2;

        while (ascIndex >= 0 && nums[ascIndex] >= nums[ascIndex + 1])
            ascIndex--;

//        if (ascIndex < 0) {
//            Arrays.sort(nums);
//            return;
//        }

        if (ascIndex >= 0) {
            int moreIndex = length - 1;
            while (nums[moreIndex] <= nums[ascIndex])
                moreIndex--;

            int temp = nums[ascIndex];
            nums[ascIndex] = nums[moreIndex];
            nums[moreIndex] = temp;
        }

        int start = ascIndex + 1;
        int end = length - 1;

        while (start < end && nums[start] > nums[end]) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}

public class NextPermutation {
    public static void main(String[] args) {
        int[] input = {1, 3, 2};
        new SolutionNextPermutation().nextPermutation(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "\t");
        }
    }
}
