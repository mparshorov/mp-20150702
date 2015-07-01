package bcc.mp_20150702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class App 
{
	public static void main(String[] args) throws IOException {
		System.out.println("type 'quit' to exit\ntype 'help' if you want help");
		String query = readLine("%s%s: ", new String[]{"code","quantity"});
		while(!StringUtils.equalsIgnoreCase("quit", query)){
			if(StringUtils.equalsIgnoreCase(query, "help")){
				System.out.println("type quit to exit");
			}else{
				System.out.printf("Welcome, %1$s.", query);
				System.out.printf(fNEW_LINE);
//				System.out.printf(service.sayHello());
				System.out.printf(fNEW_LINE);
			}
			query = readLine("Query: ", null);
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
