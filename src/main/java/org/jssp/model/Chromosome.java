package org.jssp.model;

import java.util.*;

/**
 * Chromosome is a potential solution, represented by a sequence of operations.
 */
public class Chromosome {
    private List<Operation> sequence;  // Sequence of operations genes)
    private int fitness;               // Fitness or makespan

    public Chromosome(List<Operation> sequence) {
        this.sequence = new ArrayList<>(sequence);
        this.fitness = Integer.MAX_VALUE; // Initial fitness is set to max value
    }

    /**
     * Creates a random chromosome by shuffling list of operations.
     *
     * @param allOperations The complete list of operations from all jobs.
     * @return Chromosome with a random sequence of operations.
     */
    public static Chromosome createRandomChromosome(List<Operation> allOperations) {
        List<Operation> shuffledOperations = new ArrayList<>(allOperations);
        Collections.shuffle(shuffledOperations);
        return new Chromosome(shuffledOperations);
    }

    public int calculateFitness() {
        this.fitness = simulateSchedule();
        return fitness;
    }

    /**
     * Simulates the schedule represented by the chromosome to calculate the makespan.
     *
     * @return The makespan of the schedule.
     */
    private int simulateSchedule() {
        // Initialize maps to keep track of the completion times of machines and jobs
        Map<Integer, Integer> machineAvailableTime = new HashMap<>(); // Machine ID -> Time when machine vailable
        Map<Integer, Integer> jobNextAvailableTime = new HashMap<>(); // Job ID -> Time when new operation can start
        Map<Operation, Integer> operationCompletionTime = new HashMap<>(); // Operation -> Finish time

        int operationCount = 0;

        for (Operation op : sequence) {
            int jobId = op.getJobId();
            int operationId = op.getOperationId();
            int machineId = op.getMachineId();
            int processingTime = op.getProcessingTime();

            int earliestStartTime = Math.max(
                    machineAvailableTime.getOrDefault(machineId, 0),
                    jobNextAvailableTime.getOrDefault(jobId, 0)
            );

            int finishTime = earliestStartTime + processingTime;

            // Update machine and job availablity
            machineAvailableTime.put(machineId, finishTime);
            jobNextAvailableTime.put(jobId, finishTime);
            operationCompletionTime.put(op, finishTime);

            operationCount++;
        }

        if (operationCount == 0) {
            return Integer.MAX_VALUE;
        }

        // The makespan is the max time of all operations
        int makespan = 0;
        for (Integer completionTime : operationCompletionTime.values()) {
            if (completionTime > makespan) {
                makespan = completionTime;
            }
        }

        return makespan;
    }

    public List<Operation> getSequence() {
        return sequence;
    }

    public void setSequence(List<Operation> sequence) {
        this.sequence = sequence;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        return "Chromosome{sequence= " + sequence + ", fitness= " + fitness +'}';
    }
}