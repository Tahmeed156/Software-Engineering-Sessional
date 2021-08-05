package banking;

import java.util.ArrayList;

import banking.accounts.*;
import banking.employees.*;
import banking.loans.*;

public class Bank {
  
  ArrayList<Account> accounts;
  ArrayList<Loan> loans;
  ArrayList<Employee> employees;
  float internalFund;
  private static int GLOBAL_YEAR;

  Bank () {
    
    System.out.println("============== BANK CREATED =============");

    this.accounts = new ArrayList<Account>();
    this.loans = new ArrayList<Loan>();
    this.employees = new ArrayList<Employee>();
    this.internalFund = 1000000;

    this.employees.add(new ManagingDirector("MD"));
    this.employees.add(new Officer("O1"));
    this.employees.add(new Officer("O2"));
    this.employees.add(new Cashier("C1"));
    this.employees.add(new Cashier("C2"));
    this.employees.add(new Cashier("C3"));
    this.employees.add(new Cashier("C4"));
    this.employees.add(new Cashier("C5"));
  }

  // Client functions

  void createAccount(String _username, String _accountType, float _deposit) throws Exception {
    // check if user already has account
    this.checkDuplicateAccount(_username);

    // creating new account for client
    Account acc = null;
    switch (_accountType) {
      case "Student":
        acc = new StudentAccount(_username, _deposit);
        break;
      case "Savings":
        acc = new SavingsAccount(_username, _deposit);
        break;
      case "Fixed":
        acc = new FixedDepositAccount(_username, _deposit);
        break;
      default:
        throw new Exception("ERROR: Invalid account type");
    }

    // add account to client accounts
    this.accounts.add(acc);

    System.out.println(_accountType + " account for " + _username + " Created; initial balance " + acc.getDeposit() + "$");
  }   
  
  void depositMoney(String username, float deposit) throws Exception {
    Account account = findAccount(username);
    account.makeDeposit(deposit);
    System.out.println(deposit + "$ deposited; current balance " + account.getDeposit() + "$");
  }

  void withdrawal(String username, float amount) throws Exception {
    Account account = findAccount(username);
    account.withdraw(amount);
    System.out.println(amount + "$ withdrawn; current balance " + account.getDeposit() + "$");
  }

  void requestLoan(String username, float amount) throws Exception {
    Account account = findAccount(username);
    Loan loan = account.requestLoan(amount);
    this.loans.add(loan);
    System.out.println("Loan request successful, sent for approval");
  }

  void query(String username) throws Exception {
    Account account = findAccount(username);
    System.out.println(account.query());
  }

  // Employee functions

  void approveLoan(String _username) throws Exception {
    Employee emp = this.findEmployee(_username);
    for (Loan loan: this.loans) {
      if (!loan.isApproved())
        loan.approve(emp);
    }
    System.out.println("All loans approved");
  }

  void lookup(String _username, String _accName) throws Exception {
    this.findEmployee(_username); // just check if employee exists
    Account acc = findAccount(_accName);
    String result = acc.lookup();
    System.out.println(result);
  }

  void changeInterestRate(String _username, String _accType, float _interestRate) throws Exception {
    Employee emp = this.findEmployee(_username);
    _interestRate = _interestRate/100;
    Account.changeInterestRate(emp, _accType, _interestRate);
    System.out.println("Interest rate for " + _accType + " changed successfully");
  }

  void seeInternalFund(String _username) throws Exception {
    Employee emp = this.findEmployee(_username);
    if (!(emp instanceof ManagingDirector))
      throw new Exception("ERROR: You don’t have permission for this operation");
    System.out.println("Internal fund has " + this.internalFund + "$");
  }

  String getEmployeeMessages(String username) throws Exception {
    Employee emp = this.findEmployee(username);
    if (emp instanceof ManagingDirector || emp instanceof Officer) {
      for (Loan loan: this.loans) {
        if (!loan.isApproved())
          return ", there are loan approval pending";
      }
    }
    return "";
  }

  // Utility functions

  public void yearIncrement() throws Exception {
    Bank.GLOBAL_YEAR += 1;
    for (Account acc: this.accounts) {
      acc.deductServiceCharge();
      acc.addDepositInterest();
      acc.deductLoanInterests();
    }
    System.out.println("1 year passed");
  }

  void checkDuplicateAccount(String name) throws Exception {
    for (Account acc: this.accounts) {
      if (acc.getUsername().equals(name))
        throw new Exception("ERROR: Existing account with same username");
    }
  }

  Account findAccount(String username) throws Exception {
    for (Account acc: this.accounts)
      if (acc.getUsername().equals(username))
        return acc;

    throw new Exception("ERROR: No account found with username " + username);
  }

  Employee findEmployee(String username) throws Exception {
    for (Employee emp: this.employees)
      if (emp.getUsername().equals(username))
        return emp;

    throw new Exception("ERROR: No employee found with username " + username);
  }

  void showAccounts() {
    for (Account acc: this.accounts) {
      System.out.println(acc);
    }
  }

  void showLoans() {
    for (Loan loan: this.loans) {
      System.out.println(loan);
    }
  }

  void showEmployees() {
    for (Employee emp: this.employees) {
      System.out.println(emp);
    }
  }

  public static int getGlobalYear() {
    return Bank.GLOBAL_YEAR;
  }

}