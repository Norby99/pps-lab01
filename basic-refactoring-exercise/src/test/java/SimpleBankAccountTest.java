import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        final String accountHolderName = "Mario";
        final String accountHolderSurname = "Rossi";
        final int accountHolderId = 1;

        final int initialBalance = 0;

        accountHolder = new AccountHolder(  accountHolderName,
                                            accountHolderSurname,
                                            accountHolderId);
        bankAccount = new SimpleBankAccount(accountHolder, initialBalance);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        final int deposit = 100;

        bankAccount.deposit(accountHolder.getId(), deposit);
        assertEquals(deposit, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        final int deposit1 = 100;
        final int deposit2 = 50;
        final int userId = 2;

        bankAccount.deposit(accountHolder.getId(), deposit1);
        bankAccount.deposit(userId, deposit2);
        assertEquals(deposit2, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final int deposit = 100;
        final int withdraw = 70;
        final int expectedBalance = deposit - withdraw;

        bankAccount.deposit(accountHolder.getId(), deposit);
        bankAccount.withdraw(accountHolder.getId(), withdraw);
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        final int deposit = 100;
        final int withdraw = 70;
        final int userId = 2;
        final int expectedBalance = 100;

        bankAccount.deposit(accountHolder.getId(), deposit);
        bankAccount.withdraw(userId, withdraw);
        assertEquals(expectedBalance, bankAccount.getBalance());
    }
}
