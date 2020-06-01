package example.testing.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

public class StringUtilsConcateTest {
	@Test
    public void testConcateTwoString() {
        String result = StringUtils.concatenate("one", "two");

        assertEquals(result,"onetwo");

    }
	
	@Test
	public void testConcateStringWithNull() {
		 String result = StringUtils.concatenate("one", null);
		 
		 assertEquals(result, "one");
		 
	}
	
	
	@Test
    public void testConcateTwoString2() {
        String result = StringUtils.concatenate("This is ", "String");
        
        assertThat(result, equalTo("This is String"));
        assertThat("one", is(new String("one")));
    }
	
}
