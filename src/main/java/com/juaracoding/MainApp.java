package com.juaracoding;

public class MainApp {
    public static void main(String[] args) {
        BankAccountModified account = new BankAccountModified();

        // Set initial value
        account.setAccount(211209, "Gugun Wisetyo", 1000.0);

        // Deposit
        double newBalanceAfterDeposit = account.deposit(500.0);
        System.out.println("Saldo setelah deposit: $" + newBalanceAfterDeposit);

        // Tarik dana
        double withdrawnAmount = account.withdraw(200.0);
        if (withdrawnAmount == -1) {
            System.out.println("Saldo tidak cukup");
        } else {
            System.out.println("Dana sebesar : $"+ withdrawnAmount + " Telah ditarik");
        }

        // cek saldo
        double currentBalance = account.checkBalance();
        System.out.println("Saldo saat ini: $" + currentBalance);

        // Display detil akun
        String accountDetails = account.display();
        System.out.println("Detil akun: " + accountDetails);
    }
}