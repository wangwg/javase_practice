package com.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * xiaOgang
 */
public class SolutionMinWindow {

    public String minWindow1(String s, String t) {
        String result = "";
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = target.getOrDefault(c, 0);
            target.put(c, count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char begin = s.charAt(i);
            if (!target.containsKey(begin)) continue;
            for (int j = i + t.length() - 1; j < s.length(); j++) {
                char end = s.charAt(j);
                if (!target.containsKey(end)) continue;
                String sub = s.substring(i, j + 1);
                if (checkMinWindow(target, sub)) {
                    if (result.equals("")) result = sub;
                    if (sub.length() < result.length()) {
                        result = sub;
                    }
                }
            }
        }

        return result;
    }

    private boolean checkMinWindow(Map<Character, Integer> target, String sub) {

        boolean result = true;
        Map<Character, Integer> subMap = new HashMap<>();
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            int count = subMap.getOrDefault(c, 0);
            subMap.put(c, count + 1);
        }

        for (Character c : target.keySet()) {
            if (!subMap.containsKey(c)) {
                result = false;
                break;
            }
            if (target.get(c) < subMap.get(c)) {
                result = false;
                break;
            }
        }
        return result;

    }

    public String minWindow(String s, String t) {
        String minSubString = "";
        HashMap<Character, Integer> tCharFrequency = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = tCharFrequency.getOrDefault(c, 0);
            tCharFrequency.put(c, count + 1);
        }
        HashMap<Character, Integer> subStrCharFrequency = new HashMap<>();
        int lp = 0, rp = 1;
        while (rp <= s.length()) {
            char newChar = s.charAt(rp - 1);
            if (tCharFrequency.containsKey(newChar)) {
                subStrCharFrequency.put(newChar, subStrCharFrequency.getOrDefault(newChar, 0) + 1);
            }
            while (check(tCharFrequency, subStrCharFrequency) && lp < rp) {
                if (minSubString.equals("") || rp - lp < minSubString.length()) {
                    minSubString = s.substring(lp, rp);
                }
                char removedChar = s.charAt(lp);
                if (tCharFrequency.containsKey(removedChar)) {
                    subStrCharFrequency.put(removedChar, subStrCharFrequency.getOrDefault(removedChar, 0) - 1);
                }
                lp++;
            }
            rp++;
        }
        return minSubString;

    }

    // 提炼一个方法，用于检查当前子串是否是一个覆盖t的子串
    public boolean check(HashMap<Character, Integer> tFreq, HashMap<Character, Integer> subStrFreq) {
        // 遍历t中每个字符的频次，与subStr进行比较
        for (char c : tFreq.keySet()) {
            if (subStrFreq.getOrDefault(c, 0) < tFreq.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String s = "ADOBECODEBANC", t = "ABC";
        String s = "bbaa", t = "aba";
        System.out.println(new SolutionMinWindow().minWindow(s, t));
    }
}
