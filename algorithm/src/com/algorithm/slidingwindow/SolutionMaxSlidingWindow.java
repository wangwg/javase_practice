package com.algorithm.slidingwindow;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * xiaOgang
 */
public class SolutionMaxSlidingWindow {

    public int[] maxSlidingWindow1(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        result[0] = maxHeap.peek();

        for (int i = 1; i <= nums.length - k; i++) {
            maxHeap.remove(nums[i - 1]);
            maxHeap.add(nums[i + k - 1]);
            result[i] = maxHeap.peek();
        }

        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 初始化双向队列
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        result[0] = nums[deque.getFirst()];

        // 遍历数组
        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            result[i - k + 1] = nums[deque.getFirst()];
        }

        return result;

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;

        int[] result = new int[nums.length - k + 1];

        int[] left = new int[length];
        int[] right = new int[length];

        for (int i = 0; i < length; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (i % k == k - 1 || i == length - 1) {
                right[i] = nums[i];
            } else {
                right[i] = Math.max(right[i + 1], nums[i]);
            }
        }
        printArray(left);
        printArray(right);


        for (int i = 0; i < length - k + 1; i++) {
            result[i] = Math.max(right[i], left[i + k - 1]);
        }
        return result;

    }

    private void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {-9361,
                -750, -8435, -5590, -5835, 2958, -3942, -8209, -8241, -9307, 7999, 9777, -6045, 1362, -4022, 7045, -1351, 9610, -4192, -267, -2120, 6657, -9405, -7549, 8074, 3222, -5563, 204, 2999, 3961, -6798, -53, 2349, -6533, -223, 1033, 7369, -6896, -1756, -127, 6161, -7878, 9644, 2595, -1269, 8314, 8815, -7448, 9973, 9797, 1802, -6681, 6742, -2199, 795, 6579, 2676, 9505, -3383, -4465, 6993, 1317, 6608, -8496, -512, -100, 5136, 686, -2667, 1892, -2416, 4272, 1011, -6260, 5780, -2764, -7807, 3267, 833, -8811, -4751, 7541, -2562, 5043, -7245, -2427, -6331, 147, -2974, 759, -2200, -9467, 6092, 9013, -6563, 3810, -4710, -9420, -9173, -7326, 1120, -5794, 3928, 7327, 3017, -8873, 6524, -7972, -769, -1121, 3126, -1586, -2184, -6868, 6536, -3325, -9561, -7140, -9483, 2271, -6239, -128, 6595, -6159, 3560, -6865, -8249, 1165, 5062, -7508, 3492, -1801, 9877, 4857, 6104, -7193, 9776};
        int k = 3;

        int[] maxSlidingWindow = new SolutionMaxSlidingWindow().maxSlidingWindow(nums, k);

        for (int i : maxSlidingWindow) {
            System.out.print(i + "\t");
        }

    }
}
