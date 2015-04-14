
public class Cpu {

    /** The queue of processes waiting for cpuTime */
    private Queue cpuQueue;
    /** A reference to the statistics collector */
    private Statistics statistics;
    /**long to keep track of what is the maximum cpu-time */
    private long maxCPUTime;
    //	reference to the gui
    private Gui gui;
    //	reference to the currently active process
    private Process currentProcess;

    //	constructor
    public Cpu(Queue cpuQue, Statistics statistics, long maxCPUTime, Gui gui){
        this.cpuQueue = cpuQue;
        this.statistics = statistics;
        this.maxCPUTime = maxCPUTime;
        this.gui = gui;
    }

    public long getMaxCPUTime() {
        return maxCPUTime;
    }

    public void addProcess(Process p){
        cpuQueue.insert(p);
        statistics.maxCPUQueueSize = Math.max(cpuQueue.getQueueLength(), statistics.maxCPUQueueSize);
    }

    public Process stopCurrentProcess(){
        Process p = currentProcess;
        currentProcess = null;
        gui.setCpuActive(null);
        return p;
    }

//	public Process startNextProcess(){
//		if(!cpuQueue.isEmpty()){
//			curActProcess = (Process) cpuQueue.removeNext();
//			gui.setCpuActive(curActProcess);
//			return curActProcess;
//		}
//		this.curActProcess = null;
//		return null;
//	}

    public Process startNextProcess(){
        if(cpuQueue.isEmpty()){
            this.currentProcess = null;
            //gui.setCpuActive(null);
            return null;
        }
        currentProcess = (Process) cpuQueue.removeNext();
        gui.setCpuActive(currentProcess);
        return currentProcess;
    }


    public boolean isIdle(){
        return this.currentProcess == null;
    }

    public void timePassed(long time){
        statistics.totalTimeInCUPQueue += cpuQueue.getQueueLength() * time;
    }


}
