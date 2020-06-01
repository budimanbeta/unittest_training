package example.testing.behaviour;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import example.testing.domain.BankAccount;
import example.testing.exception.InvalidAmountException;
import example.testing.exception.NotEnoughMoneyException;

@Test
public class BankAccountTestBehaviour {
	private BankAccount account;

	@BeforeMethod
	public void setUp() {
		account = new BankAccount();
	}

	public void shouldBeEmptyAfterCreation() {
		assertEquals(account.getBalance(), 0);
	}

	public void shouldAllowToDepositMoney() {
		account.deposit(100);
		assertEquals(account.getBalance(), 100);
		account.deposit(100);
		assertEquals(account.getBalance(), 200);
	}

	public void shouldAllowToWithdrawMoney() {
		account.deposit(100);
		account.withdraw(30);
		assertEquals(account.getBalance(), 70);
		account.withdraw(20);
		assertEquals(account.getBalance(), 50);
	}

	@Test(expectedExceptions = NotEnoughMoneyException.class)
	public void shouldNotAllowToWithdrawFromEmptyAccount() {
		// implementation omitted
	}

	@Test(expectedExceptions = InvalidAmountException.class)
	public void shouldNotAllowToUseNegativeAmountForWithdraw() {
		// implementation omitted
	}

	@Test(expectedExceptions = InvalidAmountException.class)
	public void shouldNotAllowToUseNegativeAmountForDeposit() {
		// implementation omitted
	}
}
