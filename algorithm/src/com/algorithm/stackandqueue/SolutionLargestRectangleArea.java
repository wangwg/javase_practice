package com.algorithm.stackandqueue;

import java.util.Stack;

/**
 * xiaOgang LeetCode #84
 */
public class SolutionLargestRectangleArea {

    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        int largestArea = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            lefts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rights[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int currArea = (rights[i] - lefts[i] - 1) * heights[i];
            largestArea = currArea > largestArea ? currArea : largestArea;
        }
        return largestArea;

    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        int largestArea = 0;

        for (int i = 0; i < rights.length; i++) {
            rights[i] = n;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                rights[stack.peek()] = i;
                stack.pop();
            }
            lefts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int currArea = (rights[i] - lefts[i] - 1) * heights[i];
            largestArea = currArea > largestArea ? currArea : largestArea;
        }
        return largestArea;
    }

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(new SolutionLargestRectangleArea().largestRectangleArea(heights));

    }
}
