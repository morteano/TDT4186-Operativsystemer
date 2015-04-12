public class Io {

    private Queue ioQueue;

    private Statistics statistics;

    private long avgIoTime;

    public boolean busy;

    public Io(Queue ioQueue, long avgIoTime, Statistics statistics) {
        this.ioQueue = ioQueue;
        this.avgIoTime = avgIoTime;
        this.statistics = statistics;
        this.busy = false;
    }

    public void addProcessToQueue(Process process) {
        ioQueue.insert(process);
    }

    public Process getNextProcess() {
        if(!ioQueue.isEmpty()) {
            return (Process) ioQueue.getNext();
        }
        return null;
    }
    public void execute(Process p) {
        //TODO::
    }
    public long getAvgIoTime() {
        return avgIoTime;
    }
}
