package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;


public class D_17 {
    
    private static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<String>();
        int n = digits.length();
        if (n == 0) {
            return answer;
        }
        String[] info = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedBlockingDeque<>();
        String s = info[digits.charAt(0) - 50];
        int digit = s.length();
        for (int j = 0; j < digit; j++) {
            queue.add("" + s.charAt(j));
        }
        if (n == 1) {
            while (!queue.isEmpty()) {
                answer.add(queue.remove());
            }
            return answer;
        }
        StringBuffer sb;

        for (int i = 1; i < n; i++) {
            while (!queue.isEmpty() && queue.peek().length() == i) {
                sb = new StringBuffer(queue.remove());
                s = info[digits.charAt(i) - 50];
                digit = s.length();
                for (int j = 0; j < digit; j++) {
                    sb.append(s.charAt(j));
                    if (i == n - 1) {
                        answer.add(sb.toString());
                    } else {
                        queue.add(sb.toString());
                    }
                    sb.delete(i, i + 1);
                }
            }
        }
        return answer;
    }

    
    private static List<String> letterCombinationsCopy1(String digits) {
        List<String> answer = new ArrayList<String>();
        if (digits.length() == 0) {
            return answer;
        }
        String[] info = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        recursion(0, digits, new StringBuffer(), (ArrayList<String>) answer, info);
        return answer;
    }

    private static void recursion(int temp, String digits, StringBuffer sb, ArrayList<String> ans, String[] info) {
        if (temp == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String s = info[digits.charAt(temp) - 50];
        for (int j = 0; j < s.length(); j++) {
            sb.append(s.charAt(j));
            recursion(temp + 1, digits, sb, ans, info);
            sb.delete(temp, temp + 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = letterCombinationsCopy1("237");
        for (String s : list
        ) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}