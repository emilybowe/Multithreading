package com.Multithreading.Concurrency;

public class Worker implements Runnable{ //implements runnable so can be run on a thread
private BankAccount account;

public Worker (BankAccount account) {
    this.account = account;
}
    public void run() {
    for(int i = 0; i < 10; i++) {
        int startBalance = account.getBalance();
        account.deposit(10);
        int endBalance = account.getBalance();
    }

    }
}
