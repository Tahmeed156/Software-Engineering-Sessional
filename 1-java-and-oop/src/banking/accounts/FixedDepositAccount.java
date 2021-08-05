package banking.accounts;

import banking.Bank;

public class FixedDepositAccount extends Account {

  public FixedDepositAccount(String _username, float _deposit) throws Exception {
    super("Fixed Deposit", _username, _deposit);
  }

  @Override
  void checkInit() throws Exception {
    if (this.deposit < 100000)
      throw new Exception("ERROR: Fixed deposit should have at least 100,000$");
    }
    
  @Override
  public void makeDeposit(float _deposit) throws Exception {
    if (_deposit < 50000)
      throw new Exception("ERROR: Fixed deposit need at least 50,000$ as deposit");
    super.makeDeposit(_deposit);
  }

  @Override
  public void withdraw(float _amount) throws Exception {
    if (Bank.getGlobalYear() - this.timeOfCreation < 1)
      throw new Exception("ERROR: Has not reached maturity period of 1 year");
    super.withdraw(_amount);
  }

  @Override
  void loanEligibility(float _amount) throws Exception {
    if (_amount > 100000)
      throw new Exception("ERROR: Loan amount exceed limit 100,000$");
  }

  @Override
  public void addDepositInterest() throws Exception {
    this.deposit += this.deposit * Account.FIXED_DEPOSIT_INTEREST_RATES;
  }

}