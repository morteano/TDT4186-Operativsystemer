
public class Cpu {

    /** The queue of processes waiting for cpuTime */
    private Queue cpuQueue;
    /** A reference to the statistics collector */
    private Statistics stats;
    /**long to keep track of what is the maximum cpu-time */
    private long maxCPUTime;
    //	reference to the gui
    private Gui gui;
    //	reference to the currently active process
    private Process curActProcess;

    //	constructor
    public Cpu(Queue cpuQue, Statistics stats, long maxCPUTime, Gui gui){
        this.cpuQueue = cpuQue;
        this.stats = stats;
        this.maxCPUTime = maxCPUTime;
        this.gui = gui;
    }

    public long getMaxCPUTime() {
        return maxCPUTime;
    }

    public void addProcess(Process p){
        cpuQueue.insert(p);
        stats.maxCPUQueueSize = Math.max(cpuQueue.getQueueLength(), stats.maxCPUQueueSize);
    }

    public Process stopCurActProcess(){
        Process p = curActProcess;
        curActProcess = null;
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
            this.curActProcess = null;
            //gui.setCpuActive(null);
            return null;
        }
        curActProcess = (Process) cpuQueue.removeNext();
        gui.setCpuActive(curActProcess);
        return curActProcess;
    }


    public boolean isIdle(){
        return this.curActProcess == null;
    }

    public void timePassed(long time){
        stats.totalTimeInCUPQueue += cpuQueue.getQueueLength() * time;
    }


}
