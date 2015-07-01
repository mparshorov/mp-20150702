package bcc.mp_20150702;

import bcc.mp_20150702.apps.impl.CalculatePermit;
import bcc.mp_20150702.factory.impl.AppFactoryImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private AppFactoryImpl factory;
	private CalculatePermit calculatePermitApp;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.factory = new AppFactoryImpl();
		this.calculatePermitApp = new CalculatePermit();
	}

	public void testFactory() {
		assertNull(factory.getAppForName("someapp"));
		assertNotNull(factory.getAppForName("CalculatePermit"));
	}

	public void testCalculatePermit() {
		assertNotSame("Overall permit price: £200\nPremiums: £50\n\nDiscounts: £25\nTotal: £225\n", calculatePermitApp.run(new String[]{"bs2","2"}));
		assertEquals("\nOverall permit price: £100\nTotal: £100\n", calculatePermitApp.run(new String[]{"bs14","1"}));
		assertNotNull(calculatePermitApp.run(new String[]{"bs14","1"}));
		assertEquals("There was an error with your request. Type 'help' to see usage.", calculatePermitApp.run(new String[]{"bs24","1"}));
		assertEquals("There was an error with your request. Type 'help' to see usage.", calculatePermitApp.run(new String[]{"bs4","4"}));
		assertEquals("\nOverall permit price: £300\nDiscounts: £50\nTotal: £250\n", calculatePermitApp.run(new String[]{"bs4","3"}));
	}
}
