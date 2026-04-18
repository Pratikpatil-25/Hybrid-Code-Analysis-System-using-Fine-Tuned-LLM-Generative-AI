import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int citiesNum;
    static long remainDistToDest, oilPriceSum = 0, remainOil = 0;
    static List<Long> distances, oilPrices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j;
        long d, s, longToken;

        String[] tokens;

        citiesNum = Integer.parseInt(br.readLine());

        distances = new ArrayList<>();
        distances.add(0L);
        tokens = br.readLine().split(" ");

        s = 0;
        for (i = 1; i < citiesNum; i++) {
            d = Long.parseLong(tokens[i - 1]);
            s += d;
                                    distances.add(d);
        }
        remainDistToDest = s;

        oilPrices = new ArrayList<>();
        tokens = br.readLine().split(" ");
        for (i = 0; i < citiesNum; i++) {
            longToken = Long.parseLong(tokens[i]);
                                    oilPrices.add(longToken);
        }

        recursion(0);

        System.out.println(oilPriceSum);
        br.close();
    }

    static void recursion(int idx) {
        int j;
        long distanceToNext;
        remainOil -= distances.get(idx);
        remainDistToDest -= distances.get(idx);
        if (remainOil == 0) {
            j = idx + 1;
            while (j < oilPrices.size() - 1 && (oilPrices.get(idx) <= oilPrices.get(j))) {
                distanceToNext = distances.get(j + 1);
                remainOil += distanceToNext;
                oilPriceSum += oilPrices.get(idx) * distanceToNext;
                j++;
            }
            if (j < oilPrices.size() - 1) {
                recursion(j);
            }
        } else
            recursion(idx + 1);
    }
}