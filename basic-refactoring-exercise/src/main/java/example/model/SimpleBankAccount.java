package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;

    private final double withdrawalFee = 1;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (!checkUser(userID)) {
            return;
        }
        if (amount >= 0) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
            this.balance -= this.withdrawalFee;
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        final double amountWithFee = amount + this.withdrawalFee;
        return this.balance >= amountWithFee && amountWithFee >= 0;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
