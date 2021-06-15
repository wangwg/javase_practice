package com.algorithm.binarysearch;

/**
 * xiaog
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int resultIndex = -1;

        while (start <= end) {

            if (target < array[start] || target > array[end])
                break;

            int mid = (start + end) / 2;

            if (target < array[mid])
                end = mid - 1;
            else if (target > array[mid])
                start = mid + 1;
            else {
                resultIndex = mid;
                break;
            }

        }

        return resultIndex;
    }

    public static int binarySearch(int[] array, int target, int from, int to) {
        int resultIndex = -1;

        if (target < array[from] || target > array[to] || from > to)
            return -1;

        int mid = (from + to) / 2;

        if (target < array[mid]) {
            return binarySearch(array, target, from, mid - 1);
        } else if (target > array[mid]) {
            return binarySearch(array, target, mid + 1, to);
        } else {
            resultIndex = mid;
        }

        return resultIndex;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(input, 9));
        System.out.println(binarySearch(input, 10, 0, input.length - 1));
    }
}
