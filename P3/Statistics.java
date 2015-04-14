import java.text.DecimalFormat;

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
    /**	The largest CPU queue that has occurred */
    public long maxCPUQueueSize = 0;
    /**	The number of processes that has been removed from the cpu before being done*/
    public long nofForcedSwitchesFromCPU = 0;
    /**	Total time the CPU has been active */
    public long totalTimeInCPU = 0;
    /**	Total amount of time the processes has spent in CPU Queue */
    public long totalTimeInCUPQueue = 0;
    /**	Total amount of time spent in IO */
    public long totalTimeInIO = 0;
    /**	Total amount of time spent waiting for IO (time spent in IO queue) */
    public long totalTimeInIOQueue = 0;
    /**	Total number of times a process has been added to the CPU queue */
    public long totalNumberOfTimesPlacedInCPUQueue = 0;
    /**	Total number of times a process has been added to the IO queue */
    public long totalNumberOfTimesPlacedInIOQueue = 0;
    /**	Total number of processed IO's */
    public long totalNumberOfIOProcesses = 0;
    /**	The largest IO queue that has occurred */
    public long maxIOQueueSize = 0;

    /**
     * Prints out a report summarizing all collected data about the simulation.
     * @param simulationLength	The number of milliseconds that the simulation covered.
     */
    public void printReport(long simulationLength) {
        System.out.println();
        System.out.println("Simulation statistics:");
        System.out.println();
        System.out.println("Number of completed processes:                                "+nofCompletedProcesses);
        System.out.println("Number of created processes:                                  "+nofCreatedProcesses);
        System.out.println("Number of (forced) process switches:                          "+nofForcedSwitchesFromCPU);
        System.out.println("Number of processed I/O operations:                           "+totalNumberOfIOProcesses);
        System.out.println("Average throughput (processes per second):                    "+(float)nofCompletedProcesses/simulationLength*1000);
        System.out.println();
        System.out.println("Total CPU-time spent processing:                              "+totalTimeInCPU + " ms");
        System.out.println("Fraction of CPU-time of total time:                           "+(float)totalTimeInCPU/simulationLength*100+" %");
        System.out.println("Total CPU-time spent waiting:                                 "+(simulationLength-totalTimeInCPU) + " ms");
        System.out.println("Fraction of CPU-time spent waiting:                           "+(float)(simulationLength-totalTimeInCPU)/simulationLength*100+" %");
        System.out.println();
        System.out.println("Largest occuring memory queue length:                         "+memoryQueueLargestLength);
        System.out.println("Average memory queue length:                                  "+(float)memoryQueueLengthTime/simulationLength);
        System.out.println("Largest occuring CPU queue length:                            "+maxCPUQueueSize);
        System.out.println("Average CPU queue length:                                     "+(float)totalTimeInCUPQueue/simulationLength);
        System.out.println("Largest occuring I/O queue length:                            "+maxIOQueueSize);
        System.out.println("Average I/O queue length:                                     "+(float)totalTimeInIOQueue/simulationLength);
        if(nofCompletedProcesses > 0) {
            System.out.println("Average # of times a process has been placed in memory queue: "+1);
            System.out.println("Average # of times a process has been placed in CPU queue:    "+(float)totalNumberOfTimesPlacedInCPUQueue/nofCompletedProcesses);
            System.out.println("Average # of times a process has been placed in I/O queue:    "+(float)totalNumberOfTimesPlacedInIOQueue/nofCompletedProcesses);
            System.out.println();
            System.out.println("Average time spent in system per process:                     "+(float)(totalTimeSpentWaitingForMemory+totalTimeInCPU+totalTimeInCUPQueue+totalTimeInIO+totalTimeInIOQueue)/nofCompletedProcesses+" ms");
            System.out.println("Average time spent waiting for memory per process:            "+(float)totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
            System.out.println("Average time spent waiting for CPU per process:               "+(float)totalTimeInCUPQueue/nofCompletedProcesses + " ms");
            System.out.println("Average time spent processing per process:                    "+(float)totalTimeInCPU/nofCompletedProcesses + " ms");
            System.out.println("Average time spent waiting for I/O per process:               "+(float)totalTimeInIOQueue/nofCompletedProcesses + " ms");
            System.out.println("Average time spent in I/O per process:                        "+(float)totalTimeInIO/nofCompletedProcesses + " ms");
        }
    }
}
