package bcc.mp_20150702.factory.impl;

import org.apache.commons.lang3.StringUtils;

import bcc.mp_20150702.apps.AppsList;
import bcc.mp_20150702.apps.GenericApp;
import bcc.mp_20150702.apps.impl.CalculatePermit;
import bcc.mp_20150702.factory.AppFactory;

public class AppFactoryImpl implements AppFactory {
	
	public GenericApp getAppForName(String name) {
		for (AppsList app : AppsList.values()) {
			if(StringUtils.equalsIgnoreCase(name, app.name())){
				return app.getInstance();
			}
		}
		return null;
	}

}
