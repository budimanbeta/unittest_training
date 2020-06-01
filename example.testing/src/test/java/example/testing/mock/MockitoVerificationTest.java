package example.testing.mock;
import static org.mockito.Mockito.*;

import org.testng.annotations.Test;


public class MockitoVerificationTest {
	private Car myFerrari = mock(Car.class);

	@Test
	public void testVerification() {
		myFerrari.driveTo("Sweet home Alabama");
		myFerrari.needsFuel();
		
		verify(myFerrari).driveTo("Sweet home Alabama");
		verify(myFerrari).needsFuel();
	}
	
	@Test
	public void testVerificationFailure() {
		myFerrari.needsFuel();
		
		verify(myFerrari).getEngineTemperature();
	}
	
	@Test
	public void testVerificationFailureArguments() {
		myFerrari.driveTo("Sweet home Alabama");
		
		verify(myFerrari).driveTo("Sweet home Honolulu");
	}
}
