package wait_And_Notify;

class Account {
  int amount = 20000;

  synchronized void withdraw(int amount) {
    System.out.println("Withdeawing...!");
    if (this.amount < amount) {
      System.out.println("Insufficient funds. Please deposite ...");

      try {
        wait();
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    this.amount -= amount;
    System.out.println("withdraw completed! ");
  }

  synchronized void deposite(int amount) {
    System.out.println("Depositing...");
    this.amount += amount;
    System.out.println("Deposite completed");
    notify();
  }
}

public class Main {

  public static void main(String[] args) {
    
    Account acc = new Account();
    
    new Thread() {
      public void run() {
        acc.withdraw(5000);
      }
      
    }.start();

    new Thread() {
      public void run() {
        acc.deposite(6000);
      }
    }.start();
  }

}
