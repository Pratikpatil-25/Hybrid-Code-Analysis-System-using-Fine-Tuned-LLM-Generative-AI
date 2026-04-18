package com.jake.algorithm.programmers.lv1;


class P12934 {
    public long solution(long n) {
        if (n == 1) {
            return 4;
        }
        for (long i = 2; i < n; i++) {
            if (Math.sqrt((double) n) == i) {
                return (long) Math.pow(i + 1, 2);
            }
        }
        return -1;
    }

        public long solution2(long n) {
        if (Math.pow((int) Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }
        return -1;
    }

        public long solution3(long n) {
        long answer = 0;
        double x = Math.sqrt(n);
        if(x == (int) x) {
            answer = (long) Math.pow(x + 1, 2);
        } else {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        P12934 problem = new P12934();
        System.out.println(problem.solution(1));
    }
}