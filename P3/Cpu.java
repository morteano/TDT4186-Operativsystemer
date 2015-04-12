package p3;

public class Cpu {
	
	private Queue cpuQueue;
	
	private Statistics statistics;
	
	private long cpuTimeSlice;
	
	private boolean busy;
	
	public Cpu(Queue cpuQueue, long cpuTimeSlice, Statistics statistics) {
		this.cpuQueue = cpuQueue;
		this.cpuTimeSlice = cpuTimeSlice;
		this.statistics = statistics;
		this.busy = false;
	}
	
	public void addProcessToQueue(Process process) {
		cpuQueue.insert(process);
	}
	
	public Process checkCpu(long clock) {
		if(!cpuQueue.isEmpty()) { 
			Process nextProcess = (Process)cpuQueue.getNext();
			if(nextProcess.getCpuTimeNeeded() > 0) {
				if (!busy) {
					// execute process in CPU
					nextProcess.leftCpuQueue(clock);
					cpuQueue.removeNext();
					return nextProcess;
				}
			}
		}
		return null;
	}
	
	public void moveBackInQueue(Process process) {
		
	}
}
