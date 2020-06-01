package example.testing.mock;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;



import static org.mockito.Mockito.*;

public class MockitoThrowingDesiredExceptionsTest {
	private Car myFerrari = mock(Car.class);

	@Test(expectedExceptions = RuntimeException.class)
	public void throwException() {
		when(myFerrari.needsFuel()).thenThrow(new RuntimeException());
		myFerrari.needsFuel();
	}
}
