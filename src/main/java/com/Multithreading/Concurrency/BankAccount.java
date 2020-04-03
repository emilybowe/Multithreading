package com.Multithreading.Concurrency;

public class BankAccount {
    private int balance;

    BankAccount(int startBalance) {
        this.balance = startBalance;
    }
    public int getBalance() {
        return balance;
    }
    public void deposit(int amount) {
        balance += amount;
    }
}
