package example.testing.mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MockSpy {
	private List<String> mockList;
	private List<String> spyList = new ArrayList();

	@BeforeClass
	public void init() {
		mockList = mock(ArrayList.class);
		spyList = spy(ArrayList.class);
	}

	@Test
	public void testMockList() {
		// by default, calling the methods of mock object will do nothing
		mockList.add("test");
		assertNull(mockList.get(0));
	}

	@Test
	public void testSpyList() {
		// spy object will call the real method when not stub
		spyList.add("test");
		assertEquals(spyList.get(0), "test");
	}

	@Test
	public void testMockWithStub() {
		// try stubbing a method
		String expected = "Mock 100";
		when(mockList.get(100)).thenReturn(expected);

		assertEquals(mockList.get(100), expected);
	}

	@Test
	public void testSpyWithStub() {
		// stubbing a spy method will result the same as the mock object
		String expected = "Spy 100";
		// take note of using doReturn instead of when
		doReturn(expected).when(spyList).get(100);

		assertEquals(spyList.get(100), expected);
	}
}
