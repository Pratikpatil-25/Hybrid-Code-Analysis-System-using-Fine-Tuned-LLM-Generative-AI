package de.uni.passau.algorithms;

import java.util.ArrayList;

import de.uni.passau.algorithms.exception.ExtendMaxSetException;
import de.uni.passau.core.model.MaxSet;
import de.uni.passau.core.model.MaxSets;


public class ContractMaxSets {

    public static MaxSets run(
        MaxSets maxSets,
        MaxSets initialMaxSets,
        int lhsSize
    ) {
        try {
            final var algorithm = new ContractMaxSets(maxSets, initialMaxSets, lhsSize);
            return algorithm.innerRun();
        }
        catch (final Exception e) {
            throw ExtendMaxSetException.inner(e);
        }
    }

    private final MaxSets maxSets;
    private final MaxSets initialMaxSets;
    private final int lhsSize;

    private ContractMaxSets(MaxSets maxSets, MaxSets initialMaxSets, int lhsSize) {
        this.maxSets = maxSets;
        this.initialMaxSets = initialMaxSets;
        this.lhsSize = lhsSize;
    }

    private MaxSets innerRun() {
                        
        final MaxSets contractedMaxSets = new MaxSets(new ArrayList<>());

        for (final MaxSet original : maxSets.sets()) {
            if (original.isFinished()) {
                                contractedMaxSets.sets().add(original);
                continue;
            }

                        final MaxSet contracting = original.clone();

            contractMaxSet(contracting);

            if (iscontractedMaxSetFinished(contracting))
                contracting.setIsFinished(true);

            contractedMaxSets.sets().add(contracting);
        }

        return contractedMaxSets;
    }

    private void contractMaxSet(MaxSet contracting) {
        initialMaxSets.sets().get(contracting.forClass).elements()
                        .filter(initial -> initial.size() == lhsSize && contracting.hasConfirmed(initial))
            .forEach(initial -> contracting.moveConfirmedToCandidates(initial));
    }

    private boolean iscontractedMaxSetFinished(MaxSet contracting) {
                if (contracting.candidateCount() > 0)
            return false;

        for (final var initial : initialMaxSets.sets().get(contracting.forClass).confirmedElements())
            if (initial.size() <= lhsSize && contracting.hasConfirmed(initial))
                return false;

        return true;
    }

}