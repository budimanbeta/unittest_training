package example.testing.mock;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.mockito.Mockito;
import org.testng.annotations.Test;



@Test
public class FirstMockitoTest {
	private Car myFerrari = Mockito.mock(Car.class);

	public void testIfCarIsACar() {
		assertTrue(myFerrari instanceof Car);
	}

	@Test
	public void testDefaultBehaviourOfTestDouble() {
		assertFalse(myFerrari.needsFuel(), "new test double should by default return false as boolean");
		assertEquals(myFerrari.getEngineTemperature(), 0.0, "new test double should by default return 0.0 as double");
	}
}
