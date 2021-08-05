package banking.loans;

import banking.Bank;
import banking.accounts.Account;
import banking.employees.*;

public class Loan {
  
  int issuedTime;
  float interestRate;
  float amount;
  boolean approved;
  Account account;
  Employee approver;
  // Staff approver;

  public Loan(Account _account, float _amount) {
    this.account = _account;
    this.amount = _amount;
    this.interestRate = (float) 0.1;
    this.issuedTime = 0;
    this.approved = false;
  }

  public void approve(Employee emp) throws Exception {
    if (!(emp instanceof ManagingDirector || emp instanceof Officer))
      throw new Exception("ERROR: Insufficient permissions");
    this.approver = emp;
    this.issuedTime = Bank.getGlobalYear();
    this.approved = true;
    account.addToBalance(this.amount);
  }

  @Override
  public String toString() {
    return "<Loan-" + this.account.getUsername() + "-" + this.amount + "-" + this.approved + ">";
  }

  public float getYearlyInterest() {
    return this.interestRate * this.amount;
  }

  public boolean isApproved() {
    return this.approved;
  }

  public float getAmount() {
    return this.amount;
  }

}
