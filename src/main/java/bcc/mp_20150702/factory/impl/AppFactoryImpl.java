package bcc.mp_20150702.factory.impl;

import org.apache.commons.lang3.StringUtils;

import bcc.mp_20150702.apps.GenericApp;
import bcc.mp_20150702.apps.impl.CalculatePermit;
import bcc.mp_20150702.factory.AppFactory;

public class AppFactoryImpl implements AppFactory {
	
	private CalculatePermit permitCalc = new CalculatePermit();

	public GenericApp getAppForName(String name) {
		if(StringUtils.equalsIgnoreCase(name, "calculatepermit")){
			return permitCalc;
		}else{
			return null;
		}
	}

}
