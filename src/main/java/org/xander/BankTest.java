package org.xander;

public class BankTest {
    public static void main(String[] args) {
        try {
            Bank bank = new Bank();

            BankAccount account1 = bank.createAccount("Juan Xandor", 1000);
            BankAccount account2 = bank.createAccount("Pes Patron", 500);

            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 200);
            System.out.println("After transfer:\n" + account1.getAccountSummary() + "\n" + account2.getAccountSummary());

            try {
                bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 1000);
            } catch (InsufficientFundsException e) {
                System.out.println("Insufficient funds: " + e.getMessage());
            }

            try {
                account1.withdraw(-50);
            } catch (NegativeAmountException e) {
                System.out.println("Negative amount: " + e.getMessage());
            }

            try {
                bank.findAccount(3);
            } catch (AccountNotFoundException e) {
                System.out.println("Account not found: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

