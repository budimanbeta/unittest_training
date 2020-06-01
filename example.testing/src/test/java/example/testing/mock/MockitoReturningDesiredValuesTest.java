package example.testing.mock;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.testng.annotations.Test;



public class MockitoReturningDesiredValuesTest {
	private Car myFerrari = Mockito.mock(Car.class);

	@Test
	public void testStubbing() {
		assertFalse(myFerrari.needsFuel(), "new test double should return false as boolean");
		when(myFerrari.needsFuel()).thenReturn(true);
		assertTrue(myFerrari.needsFuel(), "after instructed, test double should return what we want");
	}
}
