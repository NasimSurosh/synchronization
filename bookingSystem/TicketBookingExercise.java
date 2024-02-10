package bookingSystem;

class TicketBookingSystem {
  private int totalTickets;

  public TicketBookingSystem(int totalTickets) {
      this.totalTickets = totalTickets;
  }

  public synchronized void bookTicket(User user, int numTickets) {
      if (totalTickets >= numTickets) {
          totalTickets -= numTickets;
          System.out.println(user.getName() + " booked " + numTickets + " ticket(s). Available tickets: " + totalTickets);
      } else {
          System.out.println(user.getName() + " - No tickets available.");
      }
  }

  public int getAvailableTickets() {
      return totalTickets;
  }
}

class User extends Thread {
  private TicketBookingSystem bookingSystem;
  private int numTicketsToBook;

  public User(String name, TicketBookingSystem bookingSystem, int numTicketsToBook) {
      super(name);
      this.bookingSystem = bookingSystem;
      this.numTicketsToBook = numTicketsToBook;
  }

  @Override
  public void run() {
      for (int i = 0; i < 3; i++) {
          bookingSystem.bookTicket(this, numTicketsToBook);
      }
  }
}

public class TicketBookingExercise {
  public static void main(String[] args) {
      TicketBookingSystem bookingSystem = new TicketBookingSystem(10); // Change 10 to the desired number of total tickets

      User user1 = new User("User 1", bookingSystem, 2);
      User user2 = new User("User 2", bookingSystem, 2);
      User user3 = new User("User 3", bookingSystem, 2);
      User user4 = new User("User 4", bookingSystem, 2);
      User user5 = new User("User 5", bookingSystem, 2);

      user1.start();
      user2.start();
      user3.start();
      user4.start();
      user5.start();
  }
}