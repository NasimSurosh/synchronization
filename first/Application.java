package first;

/*
 *  Two ways to creating threads
 *  
 *  1- Extending Thread class-
 *  2- Implementing Runnable Interface
 */

public class Application {
  int number = 0;

  public synchronized void numberIncrementation() {
    number++;
  }

  public void multipleThreads() {
    Thread firstThread = new Thread(new Runnable() {

      @Override
      public void run() {
        for (int n = 0; n < 20000; n++) {
          numberIncrementation();
        }
      }
    });
    Thread secondThread = new Thread(new Runnable() {

      @Override
      public void run() {
        for (int n = 0; n < 20000; n++) {
          numberIncrementation();
        }

      }

    });
    firstThread.start();
    secondThread.start();

    try {
      firstThread.join();
      secondThread.join();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    System.out.println("Number is " + number);
  }

  public static void main(String[] args) {

    Application ap = new Application();
    ap.multipleThreads();

  }

}
