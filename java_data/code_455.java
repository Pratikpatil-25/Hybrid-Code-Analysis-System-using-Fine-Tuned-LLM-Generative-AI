package com.hrishikeshmishra.ns.mixed;


public class TinyUrl {

    private final String characterMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int charBase = characterMap.length();

    public String covertToCharacter(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(characterMap.charAt(num % charBase));
            num /= charBase;
        }

        return sb.reverse().toString();
    }

    public int covertToInteger(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++)
            num += characterMap.indexOf(str.charAt(i)) * Math.pow(charBase, (str.length() - (i + 1)));

        return num;
    }
}

class TinyUrlTest {

    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        int num = 122312215;
        String url = tinyUrl.covertToCharacter(num);
        System.out.println("Tiny url:  " + url);
        System.out.println("Id: " + tinyUrl.covertToInteger(url));
    }
}