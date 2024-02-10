package same_assignment;

class Worker extends Thread {
  int worker;

  public Worker(int worker) {
    this.worker = worker;
  }

  public void run() {

    System.out.println(worker + " Worker is performed a task!");
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }

  }
}

public class TaskManagement1 {

  public static void main(String[] args) {

    int workerNumber = 5;
    Worker[] worker = new Worker[workerNumber];

    for (int i = 0; i < workerNumber; i++) {
      worker[i] = new Worker(i + 1);
      worker[i].start();
    }
    for (int i = 0; i < workerNumber; i++) {
      try {
        worker[i].join();
      } catch (Exception e) {
        System.out.println(e);
      }
      System.out.println(i + " Worker is complated a task!");
    }

  }
}