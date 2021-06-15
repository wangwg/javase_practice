package com.algorithm.binarysearch;

/**
 * xiaOgang
 */

class SolutionSearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        boolean result = false;

        int x = matrix.length;
        if (x == 0) return false;
        int y = matrix[0].length;

        int start = 0;
        int end = x * y - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            int midElement = matrix[mid / y][mid % y];
            if (target < midElement)
                end = mid - 1;
            else if (target > midElement)
                start = mid + 1;
            else {
                result = true;
                break;
            }

        }
        return result;

    }
}

public class SearchMatrix {

    public static void main(String[] args) {

        int[][] input = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("Result: " + new SolutionSearchMatrix().searchMatrix(input, 21));

    }
}
