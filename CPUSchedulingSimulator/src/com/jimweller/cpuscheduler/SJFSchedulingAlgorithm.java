/** SJFSchedulingAlgorithm.java
 * 
 * A shortest job first scheduling algorithm.
 *
 * @author: Kyle Benson
 * Winter 2013
  * Cesar Ramirez - 45406343
 * Richard Yao - 3776291
 */
package com.jimweller.cpuscheduler;

import java.util.*;


public class SJFSchedulingAlgorithm extends PrioritySchedulingAlgorithm implements OptionallyPreemptiveSchedulingAlgorithm {
    SJFSchedulingAlgorithm(){}
    @Override
    public Process findLowest()
    {   Process shortest= null;
    	Process process= null;
    	long time = 0;
    	long shortTime = 0;
        	for(int i =0; i <= jobs.size()-1; i++)
        	{
        		process = jobs.get(i);
        		time = process.getBurstTime();
        		if(i==0 || time < shortTime)
        		{
        			shortest = process;
        			shortTime = time;
        		}
        	}
        	activeJob = shortest;
        	return activeJob;
    }

    public String getName(){
	return "Shortest job first";
    }

}