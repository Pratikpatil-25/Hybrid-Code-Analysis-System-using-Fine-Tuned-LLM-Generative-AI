package com.jiangc.workbook.algorithm.bitwise;



public class NonOperation {
    public static void main(String[] args) {
        int a = 2;

        System.out.println("a 的二进制 ：" + Integer.toBinaryString(a));

        System.out.println(" a  非的结果是 :" + (~a));

        System.out.println(" ~a 的二进制是 :" + Integer.toBinaryString(~a));
    }
}