public class Cpu {
    /** The queue of processes waiting for CPU */
    private Queue CpuQueue;
    /** The maximum time quant used by the RR algorithm. */
    private long maxCpuTime;
    /** A reference to the statistics collector */
    private Statistics statistics;

    /**
     * Creates a new CPU device with the given parameters.
     * @param CpuQueue	The CPU queue to be used.
     * @param maxCpuTime	The maximum time quant used by the RR algorithm.
     * @param statistics	A reference to the statistics collector.
     */
    public Cpu(Queue CpuQueue, long maxCpuTime, Statistics statistics) {
        this.CpuQueue = CpuQueue;
        this.maxCpuTime = maxCpuTime;
        this.statistics = statistics;
    }

    /**
     * This method is called when a discrete amount of time has passed.
     * @param timePassed	The amount of time that has passed since the last call to this method.
     */
    public void timePassed(long timePassed) {
        //TODO::Write
    }
}
