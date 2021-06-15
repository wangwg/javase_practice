package com.algorithm.binarysearch;

/**
 * xiaOgang
 */
class SolutionFindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int before = 0, after = slow;
        while (before != after) {
            before = nums[before];
            after = nums[after];
        }

        return before;
    }
}

public class FindDuplicate {
    public static void main(String[] args) {
        int[] input1 = {1, 3, 4, 2, 2};
        int[] input2 = {3, 1, 3, 4, 2};
        int[] input3 = {1, 1};
        int[] input4 = {1, 1, 2};

        System.out.println(new SolutionFindDuplicate().findDuplicate(input1));
        System.out.println(new SolutionFindDuplicate().findDuplicate(input2));
        System.out.println(new SolutionFindDuplicate().findDuplicate(input3));
        System.out.println(new SolutionFindDuplicate().findDuplicate(input4));

    }
}
