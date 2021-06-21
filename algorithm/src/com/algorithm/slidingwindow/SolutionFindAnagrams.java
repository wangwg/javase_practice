package com.algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * xiaOgang
 */
public class SolutionFindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int[] pCharCounts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCharCounts[p.charAt(i) - 'a']++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        // 定义左右指针
        int lp = 0, rp = 1;
        int[] subStrCharCounts = new int[26];
        while (rp <= s.length()) {
            char newChar = s.charAt(rp - 1);
            subStrCharCounts[newChar - 'a']++;
            while (subStrCharCounts[newChar - 'a'] > pCharCounts[newChar - 'a'] && lp < rp) {
                char removedChar = s.charAt(lp);
                subStrCharCounts[removedChar - 'a']--;
                lp++;
            }
            if (rp - lp == p.length())
                result.add(lp);
            rp++;
        }
        return result;
    }


    public static void main(String[] args) {
        //String s = "cbaebabacd";
        //String p = "abc";
        String s = "abab";
        String p = "ab";

        List<Integer> list = new SolutionFindAnagrams().findAnagrams(s, p);
        System.out.println(list);
    }
}
