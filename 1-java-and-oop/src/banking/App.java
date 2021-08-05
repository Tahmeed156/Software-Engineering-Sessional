package banking;

import java.util.Scanner;

public class App {

  static String username;
  static int globalTime;

  public static void main (String [] args) {
    
    Bank bank = new Bank();

    Scanner scn = new Scanner(System.in);
    String inp, inpTokens[];
    String currentUser = "";

    while (scn.hasNextLine()) {
      inp = scn.nextLine();
      inpTokens = inp.split(" ");

      try {
        switch(inpTokens[0]) {
          case "Create":
            bank.createAccount(inpTokens[1], inpTokens[2], Float.parseFloat(inpTokens[3]));
            currentUser = inpTokens[1];
            break;
          case "Deposit":
            bank.depositMoney(currentUser, Float.parseFloat(inpTokens[1]));
            break;
          case "Withdraw":
            bank.withdrawal(currentUser, Float.parseFloat(inpTokens[1]));
            break;
          case "Query":
            bank.query(currentUser);
            break;
          case "Request":
            bank.requestLoan(currentUser, Float.parseFloat(inpTokens[1]));
            break;
          case "Close":
            System.out.println("Opeartions closed for " + currentUser);
            currentUser = "";
            break;
          case "Open":
            currentUser = inpTokens[1];
            String message = bank.getEmployeeMessages(currentUser);
            System.out.println(currentUser + " active" + message);
            break;
          case "Approve":
            bank.approveLoan(currentUser);
            break;
          case "Change":
            bank.changeInterestRate(currentUser, inpTokens[1], Float.parseFloat(inpTokens[2]));
            break;
          case "Lookup":
            bank.lookup(currentUser, inpTokens[1]);
            break;
          case "See":
            bank.seeInternalFund(currentUser);
            break;
          case "INC":
            bank.yearIncrement();
            break;
          case "Show":
            switch(inpTokens[1]) {
              case "Accounts":
                bank.showAccounts();
                break;
              case "Loans":
                bank.showLoans();
                break;
              case "Employees":
                bank.showEmployees();
                break;
            }
            break;
          default:
            System.out.println("Invalid input. Try again.");
        }
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }

    }

    scn.close();
  }
}
