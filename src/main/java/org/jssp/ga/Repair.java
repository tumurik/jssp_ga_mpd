package org.jssp.ga;

import org.jssp.model.Chromosome;
import org.jssp.model.Job;
import org.jssp.model.Operation;
import org.jssp.util.DataLoader;

import java.util.*;

/**
 * Repairs chromosomes to ensure they represent valid solutions.
 */
public class Repair {


    public static void repairChromosomes(List<Chromosome> chromosomes) {
        for (Chromosome chromosome : chromosomes) {
            repairChromosome(chromosome);
        }
    }

    public static void repairChromosome(Chromosome chromosome) {
        List<Operation> sequence = chromosome.getSequence();

        // Create a map to hold operations per job, sorted by operationId
        Map<Integer, List<Operation>> jobOperationsMap = new HashMap<>();

        for (Operation op : sequence) {
            jobOperationsMap.computeIfAbsent(op.getJobId(), k -> new ArrayList<>()).add(op);
        }

        // Sort the operations by operationId
        for (List<Operation> ops : jobOperationsMap.values()) {
            ops.sort(Comparator.comparingInt(Operation::getOperationId));
        }

        List<Operation> repairedSequence = new ArrayList<>();
        Map<Integer, Integer> jobIndices = new HashMap<>();

        boolean added;
        do {
            added = false;
            for (Integer jobId : jobOperationsMap.keySet()) {
                List<Operation> ops = jobOperationsMap.get(jobId);
                int idx = jobIndices.getOrDefault(jobId, 0);
                if (idx < ops.size()) {
                    repairedSequence.add(ops.get(idx));
                    jobIndices.put(jobId, idx + 1);
                    added = true;
                }
            }
        } while (added);

        // Update the chromosome's sequence
        chromosome.setSequence(repairedSequence);
    }
}
