package datastructures.linkedlist;

public class Queue {
  private Node front = new Node();

  public Queue(Node front) {
    this.front = front;
  }

  public Queue() {
    this.front = null;
  }

  public void enqueue(int value) {
    // adds a new node with that value to the back of the queue with an O(1) Time performance.

  }

  public void dequeue() throws Exception {
    // Returns: the value from node from the front of the queue
    // Removes the node from the front of the queue
    // Should raise exception when called on empty queue

  }

  public void peek() throws Exception {
    // Returns: Value of the node located at the front of the queue
    // Should raise exception when called on empty stack

  }

  public boolean isEmpty() {
    // Returns: Boolean indicating whether the queue is empty

    return true;
  }



  public Node getFront() {
    return front;
  }

  public void setFront(Node front) {
    this.front = front;
  }
}
