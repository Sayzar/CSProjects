/** RoundRobinSchedulingAlgorithm.java
 * 
 * A scheduling algorithm that randomly picks the next job to go.
 *
 * @author: Kyle Benson
 * Winter 2013
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

public class RoundRobinSchedulingAlgorithm extends BaseSchedulingAlgorithm {

    /** the timeslice each process gets */
    private int quantum;
    private int quantumCounter;
    private Vector<Process> jobs;
private int index;

    RoundRobinSchedulingAlgorithm() {
	activeJob = null;
	jobs = new Vector<Process>();
	index=0;
	quantumCounter = 0;
	quantum = 10;
    }

    /** Add the new job to the correct queue. */
    public void addJob(Process p) {
    	jobs.add(p);
    }

    /** Returns true if the job was present and was removed. */
    public boolean removeJob(Process p) {
    	if(p == activeJob)
    		activeJob = null;
    	return jobs.remove(p);
    }

    /** Transfer all the jobs in the queue of a SchedulingAlgorithm to another, such as
	when switching to another algorithm in the GUI */
    public void transferJobsTo(SchedulingAlgorithm otherAlg) {
    	for (int i = jobs.size()-1; i >= 0; i--) {
    	    Process job = jobs.firstElement();
    	    removeJob(job);
    	    otherAlg.addJob(job);
    	}
    }

    /**
     * Get the value of quantum.
     * 
     * @return Value of quantum.
     */
    public int getQuantum() {
	return quantum;
    }

    /**
     * Set the value of quantum.
     * 
     * @param v
     *            Value to assign to quantum.
     */
    public void setQuantum(int v) {
	this.quantum = v;
    }

    /**
     * Returns the next process that should be run by the CPU, null if none
     * available.
     */
    public Process getNextJob(long currentTime) {
    	quantumCounter++;
    	if (quantum <= quantumCounter|| isJobFinished()){
    		quantumCounter=0;
    		if (jobs.size()==0){
    			return null;
    	    	}
    		if (jobs.size()!=0){
    			if(!isJobFinished())
    				index++;
    			if(index>=jobs.size()){
    					index=0;}
    			activeJob = jobs.get(index);
    			return activeJob;	
    		}
    	}
    	if(quantum>quantumCounter){
    			return activeJob;
    	}
    		return null;
    }

    public String getName() {
	return "Round Robin";
    }
}
