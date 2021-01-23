package com.algorithm.sort;

/**
 * xiaOgang
 */
public class SelectionSort {

    public static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        // i ~ N-1
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            // (i + 1) ~ N 的区间和i进行比较，找出最小值位置
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            swap(array, i, minIndex);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;

//        int[] arr = TestTool.generateRandomArray(maxSize, maxValue);
//        TestTool.printArray(arr);
//        selectionSort(arr);
//        TestTool.printArray(arr);

        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = TestTool.generateRandomArray(maxSize, maxValue);
            int[] arr2 = TestTool.copyArray(arr1);
            selectionSort(arr1);
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
