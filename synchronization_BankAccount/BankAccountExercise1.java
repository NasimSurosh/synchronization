package synchronization_BankAccount;

class BankAccount1 {
  private int balance;

  public BankAccount1() {
      balance =0;
  }

  public synchronized void deposit(int deposit) {
      balance += deposit;
  }

  public synchronized void withdraw(int withdraw) {
      if (balance >= withdraw) {
          balance -= withdraw;
      } else {
          System.out.println("Insufficient balance!");
      }
  }

  public int getBalance() {
      return balance;
  }
}

class Depositor1 extends Thread {
  private BankAccount1 account;
  private int depositAmount;
  private int depositCount;

  public Depositor1(BankAccount1 account, int depositAmount, int depositCount) {
      this.account = account;
      this.depositAmount = depositAmount;
      this.depositCount = depositCount;
  }

  @Override
  public void run() {
      for (int i = 0; i < depositCount; i++) {
          account.deposit(depositAmount);
          System.out.println("Deposited: " + depositAmount);
      }
  }
}

class Withdrawer extends Thread {
  private BankAccount1 account;
  private int withdrawAmount;
  private int withdrawCount;

  public Withdrawer(BankAccount1 account, int withdrawAmount, int withdrawCount) {
      this.account = account;
      this.withdrawAmount = withdrawAmount;
      this.withdrawCount = withdrawCount;
  }

  @Override
  public void run() {
      for (int i = 0; i < withdrawCount; i++) {
          account.withdraw(withdrawAmount);
          System.out.println("Withdrawn: " + withdrawAmount);
      }
  }
}

public class BankAccountExercise1 {
  public static void main(String[] args) {
      BankAccount1 bk = new BankAccount1(); // Initial balance of 1000
      Depositor1 dp = new Depositor1(bk, 100, 5);
      Withdrawer wd = new Withdrawer(bk, 80, 4);

      dp.start();
      wd.start();

      try {
          dp.join();
          wd.join();
      } catch (InterruptedException e) {
          System.out.println(e);
      }

      int finalBalance = bk.getBalance(); // Retrieve final balance after both threads finish
      System.out.println("Final balance: " + finalBalance);
  }
}
