package edu.cmu.tetrad.search.mb;

import edu.cmu.tetrad.graph.Node;
import edu.cmu.tetrad.search.IndependenceTest;
import edu.cmu.tetrad.search.MbSearch;

import java.util.LinkedList;
import java.util.List;


public class InterIamb implements MbSearch {

    
    private IndependenceTest independenceTest;

    
    private List<Node> variables;

    
    public InterIamb(IndependenceTest test) {
        if (test == null) {
            throw new NullPointerException();
        }

        this.independenceTest = test;
        this.variables = test.getVariables();
    }

    public List<Node> findMb(String targetName) {
        Node target = getVariableForName(targetName);
        List<Node> cmb = new LinkedList<Node>();
        boolean cont = true;

                while (cont) {
            cont = false;

            List<Node> remaining = new LinkedList<Node>(variables);
            remaining.removeAll(cmb);
            remaining.remove(target);

            double strength = Double.NEGATIVE_INFINITY;
            Node f = null;

            for (Node v : remaining) {
                if (v == target) {
                    continue;
                }

                double _strength = associationStrength(v, target, cmb);

                if (_strength > strength) {
                    strength = _strength;
                    f = v;
                }
            }

            if (f == null) {
                break;
            }

            if (!independenceTest.isIndependent(f, target, cmb)) {
                cmb.add(f);
                cont = true;
            }

                        for (Node _f : new LinkedList<Node>(cmb)) {
                cmb.remove(_f);

                if (independenceTest.isIndependent(_f, target, cmb)) {
                    continue;
                }

                cmb.add(_f);
            }

        }

        return cmb;
    }

    private double associationStrength(Node v, Node target, List<Node> cmb) {
        independenceTest.isIndependent(v, target, cmb);
        return 1.0 - independenceTest.getPValue();
    }

    public String getAlgorithmName() {
        return "InterIAMB";
    }

    public int getNumIndependenceTests() {
        return 0;
    }

    private Node getVariableForName(String targetName) {
        Node target = null;

        for (Node V : variables) {
            if (V.getName().equals(targetName)) {
                target = V;
                break;
            }
        }

        if (target == null) {
            throw new IllegalArgumentException(
                    "Target variable not in dataset: " + targetName);
        }

        return target;
    }
}