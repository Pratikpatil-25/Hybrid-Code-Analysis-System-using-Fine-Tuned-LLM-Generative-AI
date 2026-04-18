package ch4_sort.bubble_sort;

import java.io.*;
import java.util.*;

public class BOJ_1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<mData> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new mData(i, Integer.parseInt(br.readLine())));
        }

        list.sort((o1, o2) -> {
            int first_value = o1.value;
            int second_value = o2.value;

            return first_value - second_value;
        });
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            int originalIdx = list.get(i).idx;
            if (max < originalIdx - i) {
                max = originalIdx - i;
            }
        }

        System.out.println(max + 1);
    }

    static class mData {
        int idx;
        int value;

        public mData(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}