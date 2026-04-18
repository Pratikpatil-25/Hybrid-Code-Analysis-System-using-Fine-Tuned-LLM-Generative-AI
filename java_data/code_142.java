package java01.algorithm.search;

import java.util.Arrays;


public class Greedy_Coin {
    public static void main(String[] args) {
        int[] coinTypes = {500, 100, 50, 10};
        int change = 1260;
        int count = 0;

        count = solution1(coinTypes, change);
        System.out.println("=====================================");


    }
    public static int solution1(int[] coins, int amount) {
        Arrays.sort(coins);         Arrays.stream(coins).forEach(System.out::println);

        int count = 0;         for (int i = coins.length - 1; i >= 0; i--) {             int coin = coins[i];
            int used = amount / coin;             amount -= used * coin;             count += used; 
            System.out.println(coin + "원 동전 " + used + "개 사용");
        }

        System.out.println("총 사용된 동전의 개수: " + count);
        return count;
    }


    public static int solution2(int[] coinTypes, int change) {
        int count = 0;

        for (int i = 0; i < coinTypes.length; i++) {
            count += change / coinTypes[i];
            change %= coinTypes[i];
        }

        return count;
    }
}