package com.jimweller.cpuscheduler;

import java.util.Vector;

public class MultilevelPriority extends BaseSchedulingAlgorithm implements OptionallyPreemptiveSchedulingAlgorithm{

	
	private boolean preemptive;
	private Vector<Process> Q1, Q2, Q3, jobs;
	
	MultilevelPriority() {
		jobs = new Vector<Process>();
		Q1 = new Vector<Process>();
		Q2 = new Vector<Process>();
		Q3 = new Vector<Process>();
		activeJob = null;
		preemptive = isPreemptive();

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
			Q1.add(p);
		if(p.getPriorityWeight() >= 4 && p.getPriorityWeight() <= 6)
			Q2.add(p);
		if(p.getPriorityWeight() >= 7 && p.getPriorityWeight() <=9)
			Q3.add(p);
		
		jobs.add(p);
	}

	@Override
	public boolean removeJob(Process p) {
		if(p == activeJob)
			activeJob = null;
		jobs.remove(p);	
		return Q1.remove(p) || Q2.remove(p) || Q3.remove(p);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "Multilevel Priority";
	}

}
