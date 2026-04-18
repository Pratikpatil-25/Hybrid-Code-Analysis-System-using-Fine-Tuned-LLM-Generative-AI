package jihun.algorithm.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class _1935 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        double[] arrDouble = new double[n];

                for (int i = 0; i < arrDouble.length; i++) {
            arrDouble[i] = Double.parseDouble(br.readLine());
        }

        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

                        if (ch >= 65 && ch <= 90) {
                stack.push(arrDouble[ch - 'A']);
            } else {
                double result = 0.0;
                double a = stack.pop();
                double b = stack.pop();

                switch (ch) {
                    case '+':
                        result += b + a;
                        break;
                    case '*':
                        result += b * a;
                        break;
                    case '-':
                        result += b - a;
                        break;
                    case '/':
                        result += b / a;
                        break;
                }

                stack.push(result);
            }
        }

        System.out.printf("%.2f", stack.pop());
        br.close();
    }
}