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

    public int[] maxSlidingWindow(int[] nums, int k) {

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

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] maxSlidingWindow = new SolutionMaxSlidingWindow().maxSlidingWindow(nums, k);

        for (int i : maxSlidingWindow) {
            System.out.print(i + "\t");
        }

    }
}
