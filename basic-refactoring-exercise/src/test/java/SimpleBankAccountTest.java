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

    private static final int HUNDRED_DOLLARS = 100;
    private static final int FIFTY_DOLLARS = 50;
    private static final int SEVENTY_DOLLARS = 70;
    private static final int WITHDRAWAL_FEE = 1;
    private static final int WRONG_ID = 2;

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
        bankAccount.deposit(accountHolder.getId(), HUNDRED_DOLLARS);
        assertEquals(HUNDRED_DOLLARS, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), HUNDRED_DOLLARS);
        bankAccount.deposit(WRONG_ID, FIFTY_DOLLARS);
        assertEquals(HUNDRED_DOLLARS, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final int expectedBalance = HUNDRED_DOLLARS - SEVENTY_DOLLARS - WITHDRAWAL_FEE;

        bankAccount.deposit(accountHolder.getId(), HUNDRED_DOLLARS);
        bankAccount.withdraw(accountHolder.getId(), SEVENTY_DOLLARS);
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), HUNDRED_DOLLARS);
        bankAccount.withdraw(WRONG_ID, SEVENTY_DOLLARS);
        assertEquals(HUNDRED_DOLLARS, bankAccount.getBalance());
    }

    @Test
    void testNegativeWithdraw() {
        bankAccount.deposit(accountHolder.getId(), HUNDRED_DOLLARS);
        bankAccount.withdraw(accountHolder.getId(), -SEVENTY_DOLLARS);
        assertEquals(HUNDRED_DOLLARS, bankAccount.getBalance());
    }

    @Test
    void testNegativeDeposit() {
        bankAccount.deposit(accountHolder.getId(), HUNDRED_DOLLARS);
        bankAccount.deposit(accountHolder.getId(), -SEVENTY_DOLLARS);
        assertEquals(HUNDRED_DOLLARS, bankAccount.getBalance());
    }

    @Test
    void testNotEnoughMoneyFeeWithdrawal() {
        bankAccount.deposit(accountHolder.getId(), HUNDRED_DOLLARS);
        bankAccount.withdraw(accountHolder.getId(), HUNDRED_DOLLARS);
        assertEquals(HUNDRED_DOLLARS, bankAccount.getBalance());
    }
}
