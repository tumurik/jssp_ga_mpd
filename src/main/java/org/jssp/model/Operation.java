package org.jssp.model;

/**
 * Each operation is part of a job
 */
public class Operation {
    private int jobId;
    private int operationId;
    private int machineId;
    private int processingTime;

    public Operation(int jobId, int operationId, int machineId, int processingTime) {
        this.jobId = jobId;
        this.operationId = operationId;
        this.machineId = machineId;
        this.processingTime = processingTime;
    }

    public int getJobId() {
        return jobId;
    }

    public int getOperationId() {
        return operationId;
    }

    public int getMachineId() {
        return machineId;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    @Override
    public String toString() {
        return "Operation{jobId= " + jobId + ", operationId= " + operationId + ", machineId= " + machineId +
                ", processingTime= " + processingTime +'}';
    }
}


