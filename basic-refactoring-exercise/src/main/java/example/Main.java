package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static void main(String[] args) {
        final String accountHolderName = "Mario";
        final String accountHolderSurname = "Rossi";
        final int accountHolderId = 1;

        final int initialBalance = 0;

        final AccountHolder accountHolder = new AccountHolder(  accountHolderName,
                                                                accountHolderSurname,
                                                                accountHolderId);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, initialBalance);

        final int withdraw = 30;
        final int deposit1 = 100;
        final int deposit2 = 80;

        bankAccount.deposit(accountHolder.getId(), deposit1);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), withdraw);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), deposit2);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
