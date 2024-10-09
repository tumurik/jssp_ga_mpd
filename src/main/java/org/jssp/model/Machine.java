package org.jssp.model;

/**
 * Machine that process one operation at a time.
 */
public class Machine {
    private int machineId;
    private int availableTime;

    public Machine(int machineId) {
        this.machineId = machineId;
        this.availableTime = 0; // Initial time 0
    }

    public int getMachineId() {
        return machineId;
    }

    public int getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    @Override
    public String toString() {
        return "Machine{ machineId=" + machineId +", availableTime= " + availableTime + '}';
    }
}
