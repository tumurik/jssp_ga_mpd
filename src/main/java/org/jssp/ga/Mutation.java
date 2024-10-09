package org.jssp.ga;

import org.jssp.model.Chromosome;
import org.jssp.model.Operation;

import java.util.List;
import java.util.Random;

public class Mutation {

    private static final Random random = new Random();

    /**
     * Performs mutation on chromosomes based on mutation rate.
     *
     * @param chromosomes list of muta-chromosomes
     * @param mutationRate mutation rate
     */
    public static void performMutation(List<Chromosome> chromosomes, double mutationRate) {
        for (Chromosome chromosome : chromosomes) {
            if (random.nextDouble() < mutationRate) {
                mutate(chromosome);
            }
        }
    }

    /**
     * Mutates a chromosome by swapping two operations.
     *
     * @param chromosome muta-chromosome
     */
    private static void mutate(Chromosome chromosome) {
        List<Operation> sequence = chromosome.getSequence();
        int idx1 = random.nextInt(sequence.size());
        int idx2 = random.nextInt(sequence.size());

        // Swap operations
        Operation temp = sequence.get(idx1);
        sequence.set(idx1, sequence.get(idx2));
        sequence.set(idx2, temp);
    }
}
