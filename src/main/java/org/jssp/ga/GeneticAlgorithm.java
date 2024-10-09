package org.jssp.ga;

import org.jssp.model.Chromosome;
import org.jssp.model.Operation;
import org.jssp.util.DataLoader;

import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm {
    private int populationSize;
    private int generations;
    private double mutationRate;
    private List<Chromosome> population;
    private List<Operation> allOperations;


    public GeneticAlgorithm(int populationSize, int generations, double mutationRate) {
        this.populationSize = populationSize;
        this.generations = generations;
        this.mutationRate = mutationRate;
        this.population = new ArrayList<>();
        this.allOperations = DataLoader.loadAllOperations();
    }

    public void initializePopulation() {
        for (int i = 0; i < populationSize; i++) {
            Chromosome chromosome = Chromosome.createRandomChromosome(allOperations);
            population.add(chromosome);
        }
    }

    public Chromosome run() {
        initializePopulation();

        for (int gen = 0; gen < generations; gen++) {
            // Evaluate fitness of each chromosome
            for (Chromosome chromosome : population) {
                chromosome.calculateFitness();
            }

            // Selection
            List<Chromosome> selectedChromosomes = Selection.select(population);

            // Crossover
            List<Chromosome> offspring = Crossover.performCrossover(selectedChromosomes);

            // Mutation
            Mutation.performMutation(offspring, mutationRate);

            // Repair
            Repair.repairChromosomes(offspring);

            // Create new population
            population = new ArrayList<>(offspring);

            Chromosome bestChromosome = getBestChromosome();
            System.out.println("Generation " + gen + " - Best Fitness: " + bestChromosome.getFitness());
        }

        return getBestChromosome();
    }

    private Chromosome getBestChromosome() {
        Chromosome best = population.get(0);
        for (Chromosome chromosome : population) {
            if (chromosome.getFitness() < best.getFitness()) {
                best = chromosome;
            }
        }
        return best;
    }
}
