package example.testing.behaviour;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import example.testing.domain.BankAccount;

@Test
public class BankAccountTest {
	private BankAccount account;

	@BeforeMethod
	public void setUp() {
		account = new BankAccount();
	}

	public void testBalance() {
		account.deposit(200);
		assertEquals(account.getBalance(), 200);
	}

	public void testDeposit() {
		account.deposit(100);
		assertEquals(account.getBalance(), 100);
		account.deposit(100);
		assertEquals(account.getBalance(), 200);
	}

	public void testWithdraw() {
		account.deposit(100);
		account.withdraw(30);
		assertEquals(account.getBalance(), 70);
		account.withdraw(20);
		assertEquals(account.getBalance(), 50);
	}
}
