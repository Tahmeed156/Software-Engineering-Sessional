package banking.accounts;


public class SavingsAccount extends Account {

  public SavingsAccount(String _username, float _deposit) throws Exception {
    super("Savings", _username, _deposit);
  }

  @Override
  public void withdraw(float _amount) throws Exception {
    if (this.deposit - _amount < 1000)
      throw new Exception("ERROR: Savings must remain more than 1000$, balance " + this.deposit + "$");
    super.withdraw(_amount);
  }

  @Override
  public void loanEligibility(float _amount) throws Exception {
    if (_amount > 10000)
      throw new Exception("ERROR: Loan amount exceed limit 10,000$");
  }

  @Override
  public void addDepositInterest() throws Exception {
    this.deposit += this.deposit * Account.SAVINGS_INTEREST_RATES;
  }

}
