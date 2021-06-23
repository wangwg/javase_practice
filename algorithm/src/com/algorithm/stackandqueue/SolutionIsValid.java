package com.algorithm.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * xiaOgang LeetCode #20
 */
public class SolutionIsValid {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else {
                if (stack.isEmpty())
                    return false;
                if (c != stack.pop())
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
