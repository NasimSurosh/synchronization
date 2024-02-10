package assignment;

class Worker extends Thread {


  public void run() {
    try {
      Thread.sleep(500);
      
      System.out.println(" Worker is performed his task!");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

public class TaskManagement {

  public static void main(String[] args) {

    Worker worker1 = new Worker();
    Worker worker2 = new Worker();
    Worker worker3 = new Worker();
    Worker worker4 = new Worker();
    Worker worker5 = new Worker();

    worker1.start();

    try {
      worker1.join();

    } catch (Exception e) {
      System.out.println(e);
    }
    worker2.start();

    try {

      worker2.join();
    } catch (Exception e) {
      System.out.println(e);
    }
    worker3.start();

    try {

      worker3.join();
    } catch (Exception e) {
      System.out.println(e);
    }
    worker4.start();

    try {

      worker4.join();
    } catch (Exception e) {
      System.out.println(e);
    }
    worker5.start();
    try {

      worker5.join();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("All Workers performed tasks");

  }
}
