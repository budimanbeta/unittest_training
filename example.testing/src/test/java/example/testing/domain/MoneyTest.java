package example.testing.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

@Test
public class MoneyTest {

	public void constructorShoultSetAmountAndCurrency() {
		Money money = new Money(10,"USD");
		
		assertEquals(money.getAmount(), 10);
		assertEquals(money.getCurrency(), "USD");
	}
}
