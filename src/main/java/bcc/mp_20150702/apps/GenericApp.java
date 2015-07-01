package bcc.mp_20150702.apps;

public abstract class GenericApp {
	
	public void getUsage(){
		System.out.println("help	display this help");
		System.out.println("quit	quit the program");
	};
	
	public abstract String run(String[] args);
	public abstract String sendError();

}
