package banking.employees;


public abstract class Employee {
  String username;
  String position;

  Employee(String _position, String _username) {
    this.position = _position;
    this.username = _username;
  }

  public String getUsername() {
    return this.username;
  }

  @Override
  public String toString() {
    return '<' + this.position + '-' + this.username + '>';
  }
}
