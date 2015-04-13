
public class Io {

    /** The queue of processes waiting IO time */
    private Queue ioQueue;
    /** A reference to the statistics collector */
    private Statistics stats;
    /** The average process time */
    private long avgIOTime;
    /** A reference to the gui, so we can animate stuff */
    private Gui gui;
    /** A reference to the currently active process,
     * it will need to occasionally be set to "null" so the
     * rest of the program knows the IO device is free.
     */
    private Process curActProcess;

    public Io(Queue ioQueue, Statistics stats, long avgIOTime, Gui gui){
        this.ioQueue = ioQueue;
        this.stats = stats;
        this.avgIOTime = avgIOTime;
        this.gui = gui;
    }

    public long getIoTime() {
//		return avgIOTime;
        return (long) (Math.random() * (avgIOTime * 2) + (long)(Math.floor(avgIOTime/ 2)));
    }

    public Process stopCurActProcess(){
        Process p = curActProcess;
        curActProcess = null;
        gui.setIoActive(null);
        return p;
    }

    public void timePassed(long time){
        stats.totalTimeInIOQueue += ioQueue.getQueueLength() * time;
    }



    public boolean addProcess(Process p){
        ioQueue.insert(p);
        stats.maxIOQueueSize = Math.max(stats.maxIOQueueSize, ioQueue.getQueueLength());
        if(curActProcess == null){
            startProcess();
            return true;
        }
        return false;

    }

    public Process startProcess() {
        if (ioQueue.isEmpty()) {
            curActProcess = null;
            gui.setIoActive(null);
            return null;
        }
        curActProcess = (Process) ioQueue.removeNext();
        gui.setIoActive(curActProcess);
        return curActProcess;
    }










}
