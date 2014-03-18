package com.jimweller.cpuscheduler;
/**
* Cesar Ramirez - 45406343
* Richard Yao - 3776291
**/
import java.util.Vector;

public class MultilevelPriority extends BaseSchedulingAlgorithm implements OptionallyPreemptiveSchedulingAlgorithm{

	
	private boolean preemptive;
	private Vector<Process> jobs;
	private RoundRobinSchedulingAlgorithm r1, r2;
	private FCFSSchedulingAlgorithm fcfs;
	private int quantum = 10;
	private Process currentJob;
	MultilevelPriority() {
		currentJob = null;
		jobs = new Vector<Process>();
		preemptive = isPreemptive();
		r1 = new RoundRobinSchedulingAlgorithm();
		r1.setQuantum(quantum);
		r2 = new RoundRobinSchedulingAlgorithm();
		r2.setQuantum(quantum*2);
		fcfs = new FCFSSchedulingAlgorithm();
		
	}
	@Override
	public boolean isPreemptive() {
		return preemptive;
	}

	@Override
	public void setPreemptive(boolean v) {
		preemptive = v;
	}

	@Override
	public void addJob(Process p) {
		if(p.getPriorityWeight() <= 3)
			r1.addJob(p);
		if(p.getPriorityWeight() >= 4 && p.getPriorityWeight() <= 6)
			r2.addJob(p);
		if(p.getPriorityWeight() >= 7 && p.getPriorityWeight() <=9)
			fcfs.addJob(p);
		
		jobs.add(p);
	}

	@Override
	public boolean removeJob(Process p) {
		if(p == activeJob)
			activeJob = null;
		jobs.remove(p);	
		return r1.removeJob(p) || r2.removeJob(p) || fcfs.removeJob(p);
	}

	@Override
	public void transferJobsTo(SchedulingAlgorithm otherAlg) {
		for (int i = jobs.size()-1; i >= 0; i--) {
    	    Process job = jobs.firstElement();
    	    removeJob(job);
    	    otherAlg.addJob(job);
    	}
		
	}

	@Override
	public Process getNextJob(long currentTime) {
		if(!isJobFinished() && !isPreemptive())
			return currentJob;

		if(!r1.isEmpty() && r2.isJobFinished()|| !r1.isEmpty() && isPreemptive()){
			currentJob = r1.getNextJob(currentTime);
			return currentJob;
		}
		else if(!r2.isEmpty())
		{
			currentJob = r2.getNextJob(currentTime);
			return currentJob;
		}
		else if(!fcfs.isEmpty())
		{
			currentJob = fcfs.getNextJob(currentTime);
			return currentJob;
		}

		return null;
	}
	@Override
	public String getName() {
		return "Multilevel Priority";
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
}
