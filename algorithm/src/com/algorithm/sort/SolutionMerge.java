package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * xiaOgang LeetCode #56
 */
public class SolutionMerge {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (result.size() == 0 || left > result.get(result.size() - 1)[1]) {
                result.add(intervals[i]);
            } else {
                int mergeLeft = result.get(result.size() - 1)[0];
                int mergeRight = Math.max(result.get(result.size() - 1)[1], right);
                result.set(result.size() - 1, new int[]{mergeLeft, mergeRight});
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = new SolutionMerge().merge(intervals);
        for (int[] row : result) {
            for (int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }
}
