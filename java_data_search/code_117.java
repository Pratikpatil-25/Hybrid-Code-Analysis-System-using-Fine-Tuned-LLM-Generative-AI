package weka.attributeSelection;

import weka.core.Instances;

import java.util.stream.IntStream;


public class FixedTabuSearch extends TabuSearch {
    @Override
    public int[] search(ASEvaluation ASEval, Instances data) throws Exception {
        int[] selectedAttributes = super.search(ASEval, data);
        return IntStream.of(selectedAttributes)
                .filter(i -> i != data.classIndex())
                .toArray();
    }
}