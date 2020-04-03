package com.Multithreading.Concurrency;

public class TxWorker implements Runnable{
    protected BankAccount account;
    protected char txType; // w withdraw; d deposit
    protected int amt;

    public TxWorker (BankAccount account, char txType, int amt) {
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }
    public void run() {
        if (txType == 'w') {
            account.withdrawal(amt);
        }
        else if(txType == 'd') {
            // Synchronized block decides which threads to stop based on the object that you pass to it.
            // The object that you pass serves as the identifier of the critical section guarded by the synchronized block.

            // Synchronized block obtains the lock, object instances are not just locked - the lock is associated with a particular thread
            // therefore any methods that are called on the same thread that already hold the lock, are allowed to proceed
            synchronized (account) {
                account.deposit(amt);
                if (account.getBalance() > 500) {
                    int bonus = (int) ((account.getBalance() - 500) * 0.1);
                    account.deposit(bonus);
                }
            }
        }
    }
}
