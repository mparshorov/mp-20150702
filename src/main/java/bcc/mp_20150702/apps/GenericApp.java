package bcc.mp_20150702.apps;

public abstract class GenericApp {
	
	private String usage;
	private String example;
	
	protected GenericApp(String usage, String example){
		this.usage = usage;
		this.example = example;
	};
	
	public String getUsage(){
		String help = "\nhelp	display this help\n";
		help+="quit	quit the program\n\n";
		for (AppsList app : AppsList.values()) {
			GenericApp gApp = app.getInstance();
			help += gApp.getClass().getName().substring(gApp.getClass().getName().lastIndexOf(".")+1)+":\n";
			help += "Usage: "+gApp.getHelpUsage()+"\n";
			help += "Example: "+gApp.getHelpExample()+"\n\n";
		}
		return help;
	};
	
	public String getHelpUsage(){
		return this.usage;
	}
	
	public String getHelpExample(){
		return this.example;
	}
	
	public abstract String run(String[] args);
	public abstract String sendError();

}
