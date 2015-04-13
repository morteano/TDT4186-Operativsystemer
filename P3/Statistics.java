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
    //	the largest CPU-queue that has occurred
    public long maxCPUQueueSize = 0;
    //	number of processes that has been removed by force from the cpu
    public long nofForcedSwitchesFromCPU = 0;
    //	total time the CPU has been active
    public long totalTimeInCPU = 0;
    //	total amount of time the processes has spent in CPU Queue
    public long totalTimeInCUPQueue = 0;
    //	total amount of time spent in IO
    public long totalTimeInIO = 0;
    //	total amount of time spent waiting for IO (time spent in IO queue)
    public long totalTimeInIOQueue = 0;
    //	total number of times a process has been added to the CPU queue
    public long totalNumberOfTimesPlacedInCPUQueue = 0;
    //	total number of times a process has been added to the IO queue
    public long totalNumberOfTimesPlacedInIOQueue = 0;
    //	total number of processed IO's
    public long totalNumberOfIOProcessings = 0;
    //	the largest IO queue that has occurred
    public long maxIOQueueSize = 0;

    DecimalFormat df = new DecimalFormat("#.####");

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
        System.out.println("Number of processed I/O operations:                           "+totalNumberOfIOProcessings);
        System.out.println("Average throughput (processes per second):                    "+df.format((double)nofCompletedProcesses/(simulationLength/1000)));
        System.out.println();
        System.out.println("Total CPU-time spent processing:                              "+totalTimeInCPU + " ms");
        System.out.println("Fraction of CPU-time of total time:                           "+df.format(((double)totalTimeInCPU/simulationLength)*100.0)+" %");
        System.out.println("Total CPU-time spent waiting:                                 "+(simulationLength-totalTimeInCPU) + " ms");
        System.out.println("Fraction of CPU-time spent waiting:                           "+df.format((100.0 - ((double)totalTimeInCPU/simulationLength)*100))+" %");
        System.out.println();
        System.out.println("Largest occuring memory queue length:                         "+memoryQueueLargestLength);
        System.out.println("Average memory queue length:                                  "+df.format((double)memoryQueueLengthTime/simulationLength));
        System.out.println("Largest occuring CPU queue length:                            "+maxCPUQueueSize);
        System.out.println("Average CPU queue length:                                     "+df.format((double)totalTimeInCUPQueue/simulationLength));
        System.out.println();
        System.out.println("Largest occuring I/O queue length:                            "+maxIOQueueSize);
        System.out.println("Average I/O queue length:                                     "+df.format((double)totalTimeInIOQueue/simulationLength));
        if(nofCompletedProcesses > 0) {
            System.out.println("Average # of times a process has been placed in memory queue: "+1);
            System.out.println("Average # of times a process has been placed in CPU queue:    "+df.format((double)totalNumberOfTimesPlacedInCPUQueue/nofCompletedProcesses));
            System.out.println("Average # of times a process has been placed in I/O queue:    "+df.format((double)totalNumberOfTimesPlacedInIOQueue/nofCompletedProcesses));
            System.out.println();
            System.out.println("Average time spent in system per process:                     "+df.format(((double)totalTimeSpentWaitingForMemory+totalTimeInCPU+totalTimeInCUPQueue+totalTimeInIO+totalTimeInIOQueue)/nofCompletedProcesses)+" ms");
            System.out.println("Average time spent waiting for memory per process:            "+
                    df.format((double)totalTimeSpentWaitingForMemory/nofCompletedProcesses)+" ms");
            System.out.println("Average time spent waiting for CPU per process:               "+df.format((double)totalTimeInCUPQueue/nofCompletedProcesses) + " ms");
            System.out.println("Average time spent processing per process:                    "+df.format((double)totalTimeInCPU/nofCompletedProcesses) + " ms");
            System.out.println("Average time spent waiting for I/O per process:               "+df.format((double)totalTimeInIOQueue/nofCompletedProcesses) + " ms");
            System.out.println("Average time spent in I/O per process:                        "+df.format((double)totalTimeInIO/nofCompletedProcesses) + " ms");
        }
    }
}
