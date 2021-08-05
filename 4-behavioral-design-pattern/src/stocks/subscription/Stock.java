package subscription;

import java.util.ArrayList;

public class Stock {

  String name;
  int count;
  double price;
  ArrayList<SubscriberInterface> subscribers;
  
  public Stock(String _name, int _count, double d) {
    this.name = _name;
    this.count = _count;
    this.price = d;
    this.subscribers = new ArrayList<SubscriberInterface>();
  }

  public void decreasePrice(double _price) {
    this.notifyAll("Stock " + this.name + " price decreased from " + this.price + " to " + _price);
    System.out.println("Stock " + this.name + " price decreased from " + this.price + " to " + _price);
    this.price = _price;
  }

  public void increasePrice(double _price) {
    this.notifyAll("Stock " + this.name + " price increased from " + this.price + " to " + _price);
    System.out.println("Stock " + this.name + " price increased from " + this.price + " to " + _price);
    this.price = _price;
  }

  public void changeCount(int _count) {
    this.notifyAll("Stock " + this.name + " count changed from " + this.count + " to " + _count);
    System.out.println("Stock " + this.name + " count changed from " + this.count + " to " + _count);
    this.count = _count;
  }

  public void notifyAll(String msg) {
    for (SubscriberInterface s: this.subscribers)
      s.update(msg);
  }

  public void subscribe(SubscriberInterface sub) {
    this.subscribers.add(sub);
    System.out.println("New user subscribed to " + this.name);
    sub.update("Subscribed successfully!");
  };

  public void unsubscribe(SubscriberInterface sub) {
    this.subscribers.remove(sub);
    System.out.println("New user unsubscribed from " + this.name);
    sub.update("Unsubscribed successfully!");
  };

}
