package com.Multithreading.Concurrency;

public class BankAccount {
    private int balance;

    BankAccount(int startBalance) { //never mark constructors as synchronized
        this.balance = startBalance;
    }
    public synchronized int getBalance() {
        return balance;
    }
    public synchronized void deposit(int amount) {
        balance += amount;
    }
}
