package com.juaracoding;

public class BankAccountModified {
    int acc_no;
    String name;
    double amount;

    public void setAccount(int a, String n, double amt) {
        acc_no = a;
        name = n;
        amount = amt;
    }

    public double deposit(double amt) {
        amount = amount + amt;
        return amount; // Return saldo setelah deposit
    }

    public double withdraw(double amt) {
        if (amount < amt) {
            return -1; // saldo tidak cukup ditandai dengan value -1
        } else {
            amount = amount - amt;
            return amt; // Return dana yang tertarik
        }
    }

    public double checkBalance() {
        return amount; // Return saldo terkini
    }

    public String display() {
        return "No akun = "+acc_no + ", atas nama " + name + ", jumlah dana = $" + amount; // Return account details as a string
    }
}
