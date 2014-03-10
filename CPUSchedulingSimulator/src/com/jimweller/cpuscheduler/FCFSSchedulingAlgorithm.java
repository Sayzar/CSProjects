/** FCFSSchedulingAlgorithm.java
 * 
 * A first-come first-served scheduling algorithm.
 *
 * @author: Kyle Benson
 * 
 * Cesar Ramirez - 45406343
 * Richard Yao - 
 * Winter 2013
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

public class FCFSSchedulingAlgorithm extends BaseSchedulingAlgorithm {

	private Vector<Process> jobs;
	
    FCFSSchedulingAlgorithm(){
    	activeJob = null;
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


    public boolean shouldPreempt(long currentTime){
    	return isJobFinished();
    }

    /** Returns the next process that should be run by the CPU, null if none available.*/
    public Process getNextJob(long currentTime){
    	Process earlyProcess = null;
    	Process process = null;
    	long arrivalTime = 0;
    	long time = 0;
    	for(int i = 0; i <= jobs.size()-1; i++)
    	{
    		process = jobs.get(i);
    		arrivalTime = process.getArrivalTime();
    		//checks to see which got first or sets base times
    		if(i == 0 || arrivalTime < time)
    		{
    			time = arrivalTime;
    			earlyProcess = process;
    		}
    	}
    	activeJob = earlyProcess;
    	return activeJob;
    }

    public String getName(){
	return "First-come first-served";
    }
}