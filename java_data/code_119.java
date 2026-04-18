package algorithm.tmop;

import java.util.LinkedList;
import java.util.List;


public class Solution004 {

    public static void main(String[] args) {
        final String input = "abc";
        List<String> answer = new LinkedList<>();


        permutation(input.toCharArray(), 0, input.length() - 1);
    }


    public static void dfs(List<String> answer, StringBuilder oneAnswer, String str, boolean[] choosed) {
        if (str.length() == oneAnswer.length()) {
            answer.add(oneAnswer.toString());
            return;
        }

        for (int i = 0; i < str.length(); ++i) {
            if (!choosed[i]) {
                oneAnswer.append(str.charAt(i));
                choosed[i] = true;
                dfs(answer, oneAnswer, str, choosed);
                choosed[i] = false;
                oneAnswer.deleteCharAt(oneAnswer.length() - 1);
            }
        }
    }

    
    public static void permutation(char[] array, int from, int to) {
        if (0 >= to) {
            return;
        }

        if (from == to) {
            for (int i = 0; i < array.length; ++i) {
                System.out.print(array[i]);
            }
            System.out.println();
        } else {
            for (int i = from; i <= to; ++i) {
                swap(array, from, i);
                permutation(array, from + 1, to);
                swap(array, i, from);
            }
        }
    }

    public static void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}