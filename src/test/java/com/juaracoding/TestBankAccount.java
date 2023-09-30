package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBankAccount {

    private BankAccountModified account;

    @BeforeClass
    public void setUp() {
        account = new BankAccountModified();
        account.setAccount(211209, "Gugun Wisetyo", 1000.0);
    }

    @Test(priority = 1)
    public void testDeposit() {
        double newBalance = account.deposit(500.0);
        Assert.assertEquals(newBalance, 1500.0, 0.01); // Assert saldo setelah deposit
    }

    @Test(priority = 2)
    public void testWithdrawSufficientBalance() {
        double withdrawnAmount = account.withdraw(200.0);
        Assert.assertEquals(withdrawnAmount, 200.0, 0.01); // Assert tarik dana 200
        Assert.assertEquals(account.checkBalance(), 1300.0, 0.01); // Assert saldo akhir setelah withdraw
    }

    @Test(priority = 3)
    public void testWithdrawInsufficientBalance() {
        double withdrawnAmount = account.withdraw(2000.0);
        Assert.assertEquals(withdrawnAmount, -1.0, 0.01); // Assert ke value -1 agar return insufficient
        Assert.assertEquals(account.checkBalance(), 1300.0, 0.01); // Assert balance setelah sukses tarik 200 tadi
    }

    @Test(priority = 4)
    public void testCheckBalance() {
        double balance = account.checkBalance();
        Assert.assertEquals(balance, 1300.0, 0.01); // Assert balance setelah ada proses tarik
    }

    @Test(priority = 5)
    public void testDisplay() {
        String accountDetails = account.display();
        Assert.assertEquals(accountDetails, "No akun = 211209, atas nama Gugun Wisetyo, jumlah dana = $1300.0");
    }
}
