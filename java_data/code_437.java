package algorithm.inflearn2.section1list;

import java.util.LinkedList;
import java.util.List;

public class ReverseToArray {

    public int[] solution(long a) {
        List<Integer> list = new LinkedList<>();
        while (a > 0) {
            list.add((int) (a % 10));
            a /= 10;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}