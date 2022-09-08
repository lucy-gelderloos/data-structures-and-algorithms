package datastructures.linkedlist;

import static java.util.Objects.isNull;

public class Queue<T> {
  private Node<T> front;
  private Node<T> rear;

  public Queue() {
    this.front = null;
    this.rear = null;
  }

  public void enqueue(T data) {
    // convert provided value to node & add to the end of the list
    Node<T> newNode = new Node<>(data);
    if(isNull(this.front)){
      this.front = newNode;
    } else {
      this.rear.setNext(newNode);
    }
    this.rear = newNode;
  }

  public void enqueue(Node<T> newNode) {
    if(isNull(this.front)){
      this.front = newNode;
    } else {
      this.rear.setNext(newNode);
    }
    this.rear = newNode;
  }

  public T dequeue() throws Exception {
    // Returns: the value from node from the front of the queue
    // Removes the node from the front of the queue
    // Should raise exception when called on empty queue
    T returnValue;
    if(this.isEmpty() == true){
      throw new Exception("Cannot dequeue. The Queue is empty.");
    } else {
      returnValue = this.front.getData();
      if(this.front == this.rear) {
        this.front = null;
        this.rear = null;
      } else {
        Node dequeuedNode = this.front;
        this.front = dequeuedNode.getNext();
        dequeuedNode.setNext(null);
      }
      return returnValue;
    }
  }

  public T peek() throws Exception {
    // Returns: Value of the node located at the front of the queue
    // Should raise exception when called on empty stack
    if(this.isEmpty() == true){
      throw new Exception("Cannot peek. The Queue is empty.");
    } else return this.front.getData();
  }

  public boolean isEmpty() {
    // Returns: Boolean indicating whether the queue is empty
    if(this.getFront() != null) {
      return false;
    } else return true;
  }

  public Node<T> getFront() {
    return front;
  }

  public void setFront(Node<T> front) {
    this.front = front;
  }

  public Node<T> getRear() {
    return rear;
  }

  public void setRear(Node<T> rear) {
    this.rear = rear;
  }
}
