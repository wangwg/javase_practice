package com.algorithm.sort;

/**
 * xiaog
 */
public class SolutionSortColors {

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = left;

        while (left < right && i <= right) {
            while (i <= right && nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0};
        new SolutionSortColors().sortColors(colors);
        for (int i = 0; i < colors.length; i++)
            System.out.print(colors[i] + "\t");
    }
}
