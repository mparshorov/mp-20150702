package bcc.mp_20150702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import bcc.mp_20150702.apps.GenericApp;
import bcc.mp_20150702.factory.AppFactory;
import bcc.mp_20150702.factory.impl.AppFactoryImpl;

public class App 
{
	public static void main(String[] args) throws IOException {
		AppFactory factory = new AppFactoryImpl();
		System.out.println("type 'quit' to exit\ntype 'help' if you want help");
		String query = readLine("> ", null);
		while(!StringUtils.equalsIgnoreCase("quit", query)){
			if(StringUtils.equalsIgnoreCase(query, "help")){
				factory.getAppForName("calculatepermit").getUsage();
			}else{
				String[] querySplit = query.split("(\\t|\\s)");
				GenericApp app = factory.getAppForName(querySplit[0]);
				if(app != null){
					String result = app.run(Arrays.copyOfRange(querySplit, 1, querySplit.length));
					System.out.println(result);
				}else{
					System.out.println("The command '"+querySplit[0]+"' doesn't exist. Type 'help' to see all options.");
				}
			}
			query = readLine("> ", null);
		}
		System.out.printf("Bye.");
		System.out.printf(fNEW_LINE);
	}
	
	private static final String fNEW_LINE = System.getProperty("line.separator");
	
	private static String readLine(String format, Object[] args) throws IOException {
	    if (System.console() != null) {
	        return System.console().readLine(format, args);
	    }
	    System.out.print(String.format(format, args));
	    BufferedReader reader = new BufferedReader(new InputStreamReader(
	            System.in));
	    return reader.readLine();
	}
}
