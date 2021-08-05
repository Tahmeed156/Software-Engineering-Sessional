package banking.accounts;

import java.util.ArrayList;

import banking.Bank;
import banking.employees.*;
import banking.loans.Loan;


public abstract class Account {
  
  String accountType;
  String username;
  float deposit;
  int timeOfCreation;
  ArrayList<Loan> loans;

  static float SAVINGS_INTEREST_RATES = (float) 0.1;
  static float STUDENT_INTEREST_RATES = (float) 0.05;
  static float FIXED_DEPOSIT_INTEREST_RATES = (float) 0.15;

  // Class functions

  Account(String _accountType, String _username, float _deposit) throws Exception {

    this.accountType = _accountType;
    this.username = _username;
    this.deposit = _deposit;
    this.timeOfCreation = Bank.getGlobalYear();

    this.loans = new ArrayList<Loan>();
    
    this.checkInit();
  } 

  void checkInit() throws Exception {}

  @Override
  public String toString () {
    return '<' + this.username + '-' + this.accountType + '-' + this.deposit + '>';
  }

  // Client functions

  public void makeDeposit(float _amount) throws Exception {
    this.deposit += _amount;
  }

  public void withdraw(float _amount) throws Exception {
    if (_amount > this.deposit) 
      throw new Exception("ERROR: Withdrawing more than deposited, balance " + this.deposit + "$");
    this.deposit -= _amount;
  }

  public Loan requestLoan(float amount) throws Exception {
    this.loanEligibility(amount);
    Loan loan = new Loan(this, amount);
    this.loans.add(loan);
    return loan;
  }

  // Yearly functions

  public void deductServiceCharge() throws Exception {
    if (this.deposit < 500)
      throw new Exception("ERROR: Account balance lower than service charge for " + this.username);
    this.deposit -= 500;
  }

  public void addDepositInterest() throws Exception {}

  public void deductLoanInterests() throws Exception {
    for (Loan loan: this.loans) {
      if (loan.isApproved())
        this.deposit -= loan.getYearlyInterest();
    }
  }

  // Employee functions

  public String lookup() {
    return this.username + "'s current balance is " + this.deposit + "$";
  }

  public static void changeInterestRate(Employee emp, String _accType, float _interestRate) throws Exception {
    if (!(emp instanceof ManagingDirector))
      throw new Exception("ERROR: You don't have enough permissions for this operation");
    switch(_accType) {
      case "Student":
        Account.STUDENT_INTEREST_RATES = _interestRate;
        break;
      case "Savings":
        Account.SAVINGS_INTEREST_RATES = _interestRate;
        break;
      case "Fixed":
        Account.FIXED_DEPOSIT_INTEREST_RATES = _interestRate;
        break;
      default:
        throw new Exception("ERROR: Invalid account type");
    }
  }

  public String query() {
    String balanceString = "Current balance " + this.deposit + "$";
    String loanString = "";
    float totalLoan = 0;
    for (Loan loan: this.loans)
      if (loan.isApproved())
        totalLoan += loan.getAmount();
    if (totalLoan > 0)
      loanString = ", loan " + totalLoan + "$";
    return balanceString + loanString;
  }

  // Utility functions

  void loanEligibility(float _amount) throws Exception {}

  public float getDeposit() {
    return this.deposit;
  }

  public void addToBalance(float amount) {
    this.deposit += amount;
  }

  public String getUsername() {
    return this.username;
  }

}
