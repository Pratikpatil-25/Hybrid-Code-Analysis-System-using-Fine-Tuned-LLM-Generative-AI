package com.fengtin.LeetCode;


public class D_394 {
    
    public String decodeString(String s) {
        return recursion(s,0,s.length() - 1);
    }

    private String recursion(String s, int start,int end ) {
        StringBuilder ans = new StringBuilder();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int copy = 0;
                while (Character.isDigit(s.charAt(i))){
                    copy *= 10;
                    copy += s.charAt(i) - '0';
                    i++;
                }
                int balance = 0,index = i;
                for (int j = i; j <= end; j++) {
                    if(s.charAt(j) =='['){
                        balance++;
                    }
                    if(s.charAt(j) == ']'){
                        balance--;
                    }
                    if(balance == 0){
                        index = j;
                        break;
                    }
                }
                String sub = recursion(s,i + 1,index - 1);
                    while (copy > 0){
                    ans.append(sub);
                    copy--;
                 }
                i = index;
            }
            else{
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        new D_394().decodeString("100[leetcode]");
    }
}