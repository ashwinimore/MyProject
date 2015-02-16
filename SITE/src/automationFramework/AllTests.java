package automationFramework;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Cypress.class, Direct_Transport.class, Qrda.class,
		Test_ccda.class, Test_DCDT.class, Test_PD.class })
public class AllTests {

}
