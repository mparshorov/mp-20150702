package bcc.mp_20150702.apps;

import bcc.mp_20150702.apps.impl.CalculatePermit;

public enum AppsList {
	
	CALCULATEPERMIT(new CalculatePermit());
	
	private GenericApp app;
	
	private AppsList(GenericApp app){
		this.app = app;
	}
	
	public GenericApp getInstance(){
		return this.app;
	}

}
