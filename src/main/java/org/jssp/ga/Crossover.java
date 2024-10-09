package org.jssp.ga;

import org.jssp.model.Chromosome;
import org.jssp.model.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crossover {

    private static final Random random = new Random();

    public static List<Chromosome> performCrossover(List<Chromosome> parents) {
        List<Chromosome> offspring = new ArrayList<>();

        for (int i = 0; i < parents.size(); i += 2) {
            Chromosome parent1 = parents.get(i);
            Chromosome parent2 = parents.get((i + 1) % parents.size());

            // Perform crossover
            Chromosome child1 = onePointCrossover(parent1, parent2);
            Chromosome child2 = onePointCrossover(parent2, parent1);

            offspring.add(child1);
            offspring.add(child2);
        }

        return offspring;
    }

    /**
     * Performs one-point crossover between two parents
     *
     * @param parent1 parent1
     * @param parent2 parent2
     * @return The offspring chromosome
     */
    private static Chromosome onePointCrossover(Chromosome parent1, Chromosome parent2) {
        int point = random.nextInt(parent1.getSequence().size());

        List<Operation> childSequence = new ArrayList<>();
        childSequence.addAll(parent1.getSequence().subList(0, point));

        // Skipping duplicates
        for (Operation op : parent2.getSequence()) {
            if (!childSequence.contains(op)) {
                childSequence.add(op);
            }
        }

        Chromosome child = new Chromosome(childSequence);
        return child;
    }
}

