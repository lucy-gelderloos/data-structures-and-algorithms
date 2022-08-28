package datastructures.linkedlist;

public class Queue {
  private Node front = new Node();
  private Node rear = new Node();

  public Queue() {
    this.front = null;
    this.rear = null;
  }

  public void enqueue(int value) {
    // convert provided value to node & add to the end of the list
    Node newNode = new Node(value);
    this.rear.setNext(newNode);
  }

  public int dequeue() throws Exception {
    // Returns: the value from node from the front of the queue
    // Removes the node from the front of the queue
    // Should raise exception when called on empty queue
    if(this.isEmpty() == true){
      throw new Exception("Cannot dequeue. The Queue is empty.");
    } else {
      Node prevFrontNode = this.front;
      this.front = prevFrontNode.getNext();
      prevFrontNode.setNext(null);
      return prevFrontNode.getValue();
    }
  }

  public int peek() throws Exception {
    // Returns: Value of the node located at the front of the queue
    // Should raise exception when called on empty stack
    if(this.isEmpty() == true){
      throw new Exception("Cannot peek. The Queue is empty.");
    } else return this.front.getValue();
  }

  public boolean isEmpty() {
    // Returns: Boolean indicating whether the queue is empty
    return this.front != null;
  }

  public Node getFront() {
    return front;
  }

  public void setFront(Node front) {
    this.front = front;
  }

  public Node getRear() {
    return rear;
  }

  public void setRear(Node rear) {
    this.rear = rear;
  }
}
