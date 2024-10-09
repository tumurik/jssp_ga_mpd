package org.jssp.util;

import org.jssp.model.Job;
import org.jssp.model.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides sample data
 */
public class DataLoader {

    public static List<Operation> loadAllOperations() {
        List<Job> jobs = loadJobs();
        List<Operation> allOperations = new ArrayList<>();

        for (Job job : jobs) {
            allOperations.addAll(job.getOperations());
        }

        return allOperations;
    }

    public static List<Job> loadJobs() {
        List<Job> jobs = new ArrayList<>();

        // Define Job 1
        Job job1 = new Job(1);
        job1.addOperation(new Operation(1, 0, 1, 2)); // Machine 1, Processing time 2
        job1.addOperation(new Operation(1, 1, 2, 3)); // Machine 2, Processing time 3
        job1.addOperation(new Operation(1, 2, 3, 2)); // Machine 3, Processing time 2
        jobs.add(job1);

        // Define Job 2
        Job job2 = new Job(2);
        job2.addOperation(new Operation(2, 0, 2, 1));
        job2.addOperation(new Operation(2, 1, 3, 4));
        job2.addOperation(new Operation(2, 2, 1, 3));
        jobs.add(job2);

        // Define Job 3
        Job job3 = new Job(3);
        job3.addOperation(new Operation(3, 0, 3, 2));
        job3.addOperation(new Operation(3, 1, 1, 1));
        job3.addOperation(new Operation(3, 2, 2, 3));
        jobs.add(job3);

        return jobs;
    }
}
