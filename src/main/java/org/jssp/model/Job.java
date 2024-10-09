package org.jssp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Job consists of a sequence of operations that need to be processed in order.
 */
public class Job {
    private int jobId;
    private List<Operation> operations;

    public Job(int jobId) {
        this.jobId = jobId;
        this.operations = new ArrayList<>();
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public int getJobId() {
        return jobId;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Job{jobId= " + jobId +", operations= " + operations +'}';
    }
}
