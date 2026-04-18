package com.hello.suripu.algorithm.hmm;


public interface HiddenMarkovModelInterface {
    HmmDecodedResult decode(double[][] observations, Integer[] possibleEndStates, double minTransitionLikelihood);
    int getNumberOfStates();
}