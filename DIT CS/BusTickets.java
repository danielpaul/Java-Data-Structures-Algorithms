import java.util.Scanner;

public class BusTickets {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Please enter the total number of tickets: ");
    int total_tickets = scan.nextInt();

    System.out.print("How many of these are child/OAP tickets? ");
    int child_tickets = scan.nextInt();

    if(total_tickets < 1 || child_tickets > total_tickets) {
      System.out.println("Please enter valid number of tickets.");
      return;
    }

    int adult_tickets = total_tickets - child_tickets;

    double total_cost = 0.00;

    double child_ticket_cost = 1.50;
    double adult_ticket_cost = 3.00;

    if(total_tickets > 5 && total_tickets <= 10) {
      adult_ticket_cost = 2.50;
    } else if(total_tickets > 10) {
      adult_ticket_cost = 2.00;
    }

    total_cost += (adult_tickets * adult_ticket_cost);
    total_cost += (child_tickets * child_ticket_cost);

    System.out.println("Total cost for " + adult_tickets + " adult tickets and " + child_tickets + " child/OPA tickets is " + total_cost + " Euros.");
  }

}
