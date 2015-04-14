
public class Io {

    /** The queue of processes waiting IO time */
    private Queue ioQueue;
    /** A reference to the statistics collector */
    private Statistics statistics;
    /** The average process time */
    private long avgIOTime;
    /** A reference to the gui, so we can animate stuff */
    private Gui gui;
    /** A reference to the currently active process,
     * it will need to occasionally be set to "null" so the
     * rest of the program knows the IO device is free.
     */
    private Process currentProcess;

    public Io(Queue ioQueue, Statistics statistics, long avgIOTime, Gui gui){
        this.ioQueue = ioQueue;
        this.statistics = statistics;
        this.avgIOTime = avgIOTime;
        this.gui = gui;
    }

    public long getIoTime() {
        return (long) (Math.random() * (avgIOTime * 2) + (long)(Math.floor(avgIOTime/ 2)));
    }

    public Process stopCurrentProcess(){
        Process p = currentProcess;
        currentProcess = null;
        gui.setIoActive(null);
        return p;
    }

    public void timePassed(long time){
        statistics.totalTimeInIOQueue += ioQueue.getQueueLength() * time;
    }



    public boolean addProcess(Process p){
        ioQueue.insert(p);
        statistics.maxIOQueueSize = Math.max(statistics.maxIOQueueSize, ioQueue.getQueueLength());
        if(currentProcess == null){
            startProcess();
            return true;
        }
        return false;

    }

    public Process startProcess() {
        if (ioQueue.isEmpty()) {
            currentProcess = null;
            gui.setIoActive(null);
            return null;
        }
        currentProcess = (Process) ioQueue.removeNext();
        gui.setIoActive(currentProcess);
        return currentProcess;
    }
}
