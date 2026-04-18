package th.ac.kmutt.cpe.algorithm.thanatip.Algorithm.Selection;

import java.util.*;

public class HistogramSelect {

    public float solve(List<Float> list, int k, int b) {
        return solveRucursive(list, k, b);
    }

    private float solveRucursive(List<Float> list, int k, int b) {
        List<List<Float>> allList = new ArrayList<>();
        float min = minValue(list);
        float max = maxValue(list);

        float width = (max - min) / b;
        float minRange = min;
        float maxRange = min + width;
        for (int i = 0; i < b; i++) {
            List<Float> bin = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (i + 1 == b) {
                    if (list.get(j) >= minRange && list.get(j) <= maxRange) {
                        bin.add(list.get(j));
                    }
                } else {
                    if (list.get(j) >= minRange && list.get(j) < maxRange) {
                        bin.add(list.get(j));
                    }
                }
            }
            allList.add(new ArrayList<>(bin));
            minRange = maxRange;
            maxRange = minRange + width;
        }

        int length = 0;
        int nList = 0;
        int lengthBefore = 0;
        for (List<Float> check : allList) {
            length = length + check.size();
            lengthBefore = lengthBefore + check.size();
            if (length == k) {
                return maxValue(check);
            } else if (length > k) {
                lengthBefore = lengthBefore - check.size();
                nList++;
                break;
            }
            nList++;
        }
        List<Float> newlist = new ArrayList<>(allList.get(nList - 1));

        return solve(newlist, k - lengthBefore, b);

    }

    private float minValue(List<Float> list) {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
        }
        return min;
    }

    private float maxValue(List<Float> list) {
        float max = Float.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        return max;
    }
}