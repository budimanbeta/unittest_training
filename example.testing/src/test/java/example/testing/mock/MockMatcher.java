package example.testing.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.mockito.Mockito;

public class MockMatcher {
	
	public void testList_Argument_Matchers() {  
		  
		List<String> mocklist = mock(List.class);  
  
        when(mocklist.get(Mockito.anyInt())).thenReturn("Mockito");  
          
        assertEquals(mocklist.get(0),"Mockito");  
        assertEquals(mocklist.get(1), "Mockito");   
                        assertEquals( mocklist.get(2),"Mockito");  
    }  
	
	//ArgumentCaptor<Contact> argument = ArgumentCaptor.forClass(Contact.class);
//	stack.add("Java Code Geeks");
//	Mockito.verify(stack).add(argumentCaptor.capture());
//	assertEquals("Java Code Geeks", argumentCaptor.getValue());


}
