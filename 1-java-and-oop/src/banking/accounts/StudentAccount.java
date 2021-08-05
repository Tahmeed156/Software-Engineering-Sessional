package banking.accounts;


public class StudentAccount extends Account {

  public StudentAccount(String _username, float _deposit) throws Exception {
    super("Student", _username, _deposit);
  }

  @Override
  public void withdraw(float _amount) throws Exception {
    if (_amount > 10000)
      throw new Exception("ERROR: Students can not withdraw more than 10000$");
    super.withdraw(_amount);
  }

  @Override
  void loanEligibility(float _amount) throws Exception {
    if (_amount > 1000)
      throw new Exception("ERROR: Loan amount exceed limit 1,000$");
  }

  @Override
  public void deductServiceCharge() throws Exception {}

  @Override
  public void addDepositInterest() throws Exception {
    this.deposit += this.deposit * Account.STUDENT_INTEREST_RATES;
  }

}
