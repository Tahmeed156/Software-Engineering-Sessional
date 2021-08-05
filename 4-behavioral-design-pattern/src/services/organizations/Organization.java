package organizations;

import java.util.LinkedList;
import java.util.Queue;

import mediator.MediatorInterface;

abstract class Organization implements OrganizationInterface {

  private MediatorInterface mediator;
  private Queue<String> queue;

  public Organization(MediatorInterface _mediator) {
    this.mediator = _mediator;
    this.queue = new LinkedList<>();
  }

  public void request(String service) {
    this.mediator.request(this, service);
  }

  public void enqueue(String requesterId) {
    this.queue.add(requesterId);
  }

  public void serve() {
    String orgId = this.queue.poll();
    this.mediator.serve(this, orgId);
  }
  
}
