package org.jssp.main;

import org.jssp.ga.GeneticAlgorithm;
import org.jssp.model.Chromosome;

public class Main {
    public static void main(String[] args) {
        // GA parameters
        int populationSize = 10;
        int generations = 50;
        double mutationRate = 0.1;

        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize, generations, mutationRate);
        Chromosome bestChromosome = ga.run();

        // Display the best schedule and its makespan
        System.out.println("Best Schedule: " + bestChromosome.getSequence());
        System.out.println("Best Makespan (Fitness): " + bestChromosome.getFitness());
    }
}
