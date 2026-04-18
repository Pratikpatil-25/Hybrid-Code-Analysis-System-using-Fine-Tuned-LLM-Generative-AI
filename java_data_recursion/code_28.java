package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_22 {
    private static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if (n == 0) {
            return ans;
        }
        recursion(0, (ArrayList<String>) ans, new char[2 * n]);
        return ans;
    }

    private static void recursion(int temp, ArrayList<String> answer, char[] current) {
        if (temp == current.length) {
            if (isRight(new String(current))) {
                answer.add(new String(current));
            }
            return;
        }
        current[temp] = '(';
        recursion(temp + 1, answer, current);
        current[temp] = ')';
        recursion(temp + 1, answer, current);
    }

    private static boolean isRight(String s) {
        int balance = 0;
        for (char c : s.toCharArray()
        ) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
                System.out.println(generateParenthesis(3));
    }
}