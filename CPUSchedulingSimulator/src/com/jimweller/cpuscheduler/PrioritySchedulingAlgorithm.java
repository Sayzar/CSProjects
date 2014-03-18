/** PrioritySchedulingAlgorithm.java
 * 
 * A single-queue priority scheduling algorithm.
 *
 * @author: Kyle Benson
 * Winter 2013
 * Cesar Ramirez - 45406343
 * Richard Yao - 3776291
 */
package com.jimweller.cpuscheduler;

import java.util.Vector;

public class PrioritySchedulingAlgorithm extends BaseSchedulingAlgorithm implements OptionallyPreemptiveSchedulingAlgorithm {
    public boolean preemptive;
    public Vector<Process> jobs;
    
    PrioritySchedulingAlgorithm(){
    	activeJob = null;
    	preemptive = isPreemptive();
    	jobs = new Vector<Process>();
    }

    /** Add the new job to the correct queue.*/
    public void addJob(Process p){
    	jobs.add(p);
    }
    
    /** Returns true if the job was present and was removed. */
    public boolean removeJob(Process p){
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


    /** Returns the next process that should be run by the CPU, null if none available.*/
    public Process getNextJob(long currentTime){
    	if (!isJobFinished() && !isPreemptive())
    	    return activeJob; 	
    	activeJob = findLowest();
    	return activeJob;
    }

 /** helper method*/   
    public Process findLowest()
    {
    	Process highPrior= null;
    	Process process= null;
    	long highest = 0;
    	long priority = 0;
    	for(int i = 0; i <= jobs.size()-1; i++)
    	{
    		process = jobs.get(i);
    		priority = process.getPriorityWeight();
    		
    		if(i == 0 || priority < highest)
    		{
    			highest = priority;
    			highPrior = process;
    		}
    	}  	
    	return highPrior;
    }
    public String getName(){
	return "Single-queue Priority";
    }

    /**
     * @return Value of preemptive.
     */
    public boolean isPreemptive(){
	return preemptive;
    }
    
    /**
     * @param v  Value to assign to preemptive.
     */
    public void setPreemptive(boolean  v){
	preemptive = v;
    }
    
}