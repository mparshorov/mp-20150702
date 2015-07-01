package bcc.mp_20150702.factory;

import bcc.mp_20150702.apps.GenericApp;

public interface AppFactory {
	
	public GenericApp getAppForName(String name);

}
