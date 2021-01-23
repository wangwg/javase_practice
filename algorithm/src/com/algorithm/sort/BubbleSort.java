package com.algorithm.sort;

/**
 * xiaOgang
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {

        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = TestTool.generateRandomArray(maxSize, maxValue);
            int[] arr2 = TestTool.copyArray(arr1);
            bubbleSort(arr1);
            TestTool.comparator(arr2);
            if (!TestTool.isEqual(arr1, arr2)) {
                succeed = false;
                TestTool.printArray(arr1);
                TestTool.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
