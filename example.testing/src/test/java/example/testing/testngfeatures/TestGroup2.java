package example.testing.testngfeatures;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestGroup2 {
	
	
	@Test(groups = "database")
	public void testConnectOracle() {
		System.out.println("testConnectOracle()  --- 2");
	}

	
	@Test(groups= "selenium-test")
	public void runSelenium1() {
		System.out.println("runSelenium()1  --- 2");
	}

}
