package com.algorithm.string;

import java.util.*;

/**
 * xiaOgang
 */
public class SolutionRemoveDuplicateLetters {

    public String removeDuplicateLetters1(String s) {

        if (s.length() == 0) return "";

        int[] lettersCount = new int[26];

        for (int i = 0; i < s.length(); i++)
            lettersCount[s.charAt(i) - 'a']++;

        int position = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(position))
                position = i;

            if (--lettersCount[s.charAt(i) - 'a'] == 0)
                break;
        }

        return s.charAt(position) + removeDuplicateLetters1(s.substring(position + 1).replaceAll(s.charAt(position) + "", ""));
    }

    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        HashSet<Character> isExist = new HashSet<>();
        HashMap<Character, Integer> lastPosition = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            lastPosition.put(s.charAt(i), i);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isExist.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && lastPosition.get(stack.peek()) > i) {
                    isExist.remove(stack.pop());
                }

                isExist.add(c);
                stack.push(c);
            }

        }

        StringBuilder result = new StringBuilder();
        for (Character c : stack)
            result.append(c.charValue());

        return result.toString();

    }

    public static void main(String[] args) {
        String s1 = "bcabc";
        String s2 = "cbacdcbc";
        System.out.println(new SolutionRemoveDuplicateLetters().removeDuplicateLetters(s1));
        System.out.println(new SolutionRemoveDuplicateLetters().removeDuplicateLetters(s2));
    }
}
