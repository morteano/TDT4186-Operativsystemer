public class Cpu {
	
	private Queue cpuQueue;
	
	private Statistics statistics;
	
	private long cpuTimeSlice;
	
	public boolean busy;
	
	public Cpu(Queue cpuQueue, long cpuTimeSlice, Statistics statistics) {
		this.cpuQueue = cpuQueue;
		this.cpuTimeSlice = cpuTimeSlice;
		this.statistics = statistics;
		this.busy = false;
	}
	
	public void insertProcess(Process process) {
		cpuQueue.insert(process);
	}

	public Process getNextProcess() {
		if(!cpuQueue.isEmpty()) {
			return (Process) cpuQueue.getNext();
		}
		return null;
	}
	public void execute(Process p) {
		cpuQueue.removeNext();
		p.execute(cpuTimeSlice);
	}
	public long getCpuTimeSlice() {
		return cpuTimeSlice;
	}
}
