package example.testing.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
public class MoneyTest2 {
	@DataProvider
	private static final Object[][] getMoney(){
		return new Object[][] {{10,"USD"},{20,"EUR"}};
	}

	@Test(dataProvider = "getMoney")
	public void constructorShoultSetAmountAndCurrency(int amount, String currency) {
		Money money = new Money(amount,currency);
		
		assertEquals(money.getAmount(), amount);
		assertEquals(money.getCurrency(), currency);
	}
}
