package report;

public class ExecutionTime {

	long startTime;
	long endTime;
	long totalTime;
	
	
	public ExecutionTime() {
		startTime = System.currentTimeMillis();
	}
	
	public String endTime() {
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		return "Execution time: "+totalTime/1000.0 + "s";
	}
}
