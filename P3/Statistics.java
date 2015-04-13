/**
 * This class contains a lot of public variables that can be updated
 * by other classes during a simulation, to collect information about
 * the run.
 */
public class Statistics
{
	/** The number of processes that have exited the system */
	public long nofCompletedProcesses = 0;
	/** The number of processes that have entered the system */
	public long nofCreatedProcesses = 0;
	/** The total time that all completed processes have spent waiting for memory */
	public long totalTimeSpentWaitingForMemory = 0;
	/** The time-weighted length of the memory queue, divide this number by the total time to get average queue length */
	public long memoryQueueLengthTime = 0;
	/** The largest memory queue length that has occured */
	public long memoryQueueLargestLength = 0;
	/** The number of forced process switches in the system */
	public long nofSwitchedProcesses = 0;
	/** The number of processed I/O operations in the system */
	public long nofIOProcesses = 0;
    /** Total CPU time spent processing */
    public long totalTimeSpentInCpu = 0;
    /** Total CPU time spent waiting */
    public long totalTimeSpentWaitingCpu = 0;
    /** Largest occuring cpu queue length */
    public long cpuQueueLargestLength = 0;
    /** Largest occuring I/O queue length */
    public long ioQueueLargestLength = 0;
    /** The time-weighted length of the cpu queue, divide this number by the total time to get average queue length */
    public long cpuQueueLengthTime = 0;
    /** The time-weighted length of the io queue, divide this number by the total time to get average queue length */
    public long ioQueueLengthTime;
    /** Total I/O time spent waiting */
    public long totalTimeSpentWaitingForIo;



	/**
	 * Prints out a report summarizing all collected data about the simulation.
	 * @param simulationLength	The number of milliseconds that the simulation covered.
	 */
	public void printReport(long simulationLength) {
		System.out.println();
		System.out.println("Simulation statistics:");
		System.out.println();
		System.out.println("Number of completed processes:                              "+nofCompletedProcesses);
		System.out.println("Number of created processes:                                "+nofCreatedProcesses);
        System.out.println("Number of (forced) process switches:                        "+nofSwitchedProcesses);
        System.out.println("Number of processed I/O operations:                         "+nofIOProcesses);
        System.out.println("Average throughput (processes per second):                  "+(float)(nofCompletedProcesses)/(simulationLength/1000));
        System.out.println();
        System.out.println("Total CPU time spent processing:                            "+totalTimeSpentInCpu);
        System.out.println("Fraction of CPU time spent processing:                      "+(float)100*totalTimeSpentInCpu/(simulationLength)+"%");
        System.out.println("Total CPU time spent waiting:                               "+totalTimeSpentWaitingCpu);
        System.out.println("Fraction of CPU time spent waiting:                         "+(float)100*totalTimeSpentInCpu/(simulationLength)+"%");
        System.out.println();
        System.out.println("Largest occuring memory queue length:                       "+memoryQueueLargestLength);
        System.out.println("Average memory queue length:                                "+(float)memoryQueueLengthTime/simulationLength);
        System.out.println("Largest occuring cpu queue length:                          "+cpuQueueLargestLength);
        System.out.println("Average cpu queue length:                                   "+(float)cpuQueueLengthTime/simulationLength);
        System.out.println("Largest occuring I/O queue length:                          "+ioQueueLargestLength);
        System.out.println("Average I/O queue length:                                   "+(float)ioQueueLengthTime/simulationLength);
        if(nofCompletedProcesses > 0) {
			System.out.println("Average # of times a process has been placed in memory queue:   "+1);
            System.out.println("Average # of times a process has been placed in cpu queue:      "+1);
            System.out.println("Average # of times a process has been placed in I/O queue:      "+1);
            System.out.println();
            System.out.println("Average time spent in system per process:               "+simulationLength/nofCompletedProcesses+" ms");
            System.out.println("Average time spent waiting for memory per process:      "+totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
            System.out.println("Average time spent waiting for cpu per process:         "+totalTimeSpentWaitingCpu/nofCompletedProcesses+" ms");
            System.out.println("Average time spent processing per process:              "+"TODO");
            System.out.println("Average time spent waiting for I/O per process:         "+totalTimeSpentWaitingForIo/nofCompletedProcesses+" ms");
            System.out.println("Average time spent in I/O per process:                  "+"TODO");
        }
	}
}
