package com.algorithm.greedy;

import java.util.HashMap;

/**
 * xiaOgang LeetCode #621
 */
public class SolutionLeastInterval {

    public int leastInterval(char[] tasks, int n) {

        int maxCount = 0;
        int maxNum = 0;

        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : tasks) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(c));
        }

        for (char c : countMap.keySet()) {
            if (countMap.get(c) == maxCount)
                maxNum++;
        }

        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxNum);

    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        System.out.println(new SolutionLeastInterval().leastInterval(tasks, n));
    }
}
