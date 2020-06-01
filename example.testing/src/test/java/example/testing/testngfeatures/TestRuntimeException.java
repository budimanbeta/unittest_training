package example.testing.testngfeatures;

import org.testng.annotations.Test;

public class TestRuntimeException {

	@Test(expectedExceptions = ArithmeticException.class)
	public void divisionByZeroException() {
		int i = 1/0;
	}
}
