package com.kururu.skillup.algorithm.problems.codility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Codility4 extends AbstractCodility {

    private final Map<String, Integer> inputMap = Collections.unmodifiableMap(new HashMap<String, Integer>() {
        {
            put("X", 10);
            put("Y", 85);
            put("D", 30);
        }
    });

    private int result = 0;

    @Override
    public void process() {
        int x = inputMap.get("X");
        int y = inputMap.get("Y");
        int d = inputMap.get("D");

        if ((x > y) ||
                checkRange(new int[]{x, y, d}, 1000000000)) {
            return;
        }

        if ((y - x) % d > 0) {
            result = ((y - x) / d) + 1;
        } else {
            result = ((y - x) / d);
        }

    }

    @Override
    protected String getInputData() {
        return inputMap.toString();
    }

    @Override
    protected String getOutputData() {
        return String.valueOf(result);
    }

    @Override
    protected String getExpectedResult() {
        return "3";
    }

    private boolean checkRange(int[] targets, int to) {
        for (int target : targets) {
            return target < 1 || target > to;
        }
        return true;
    }
}