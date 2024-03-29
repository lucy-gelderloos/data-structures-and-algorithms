package datastructures.linkedlist;

// Create a Stack class that has a top property. It creates an empty Stack when instantiated.
// This object should be aware of a default empty value assigned to top when the stack is created.

import static java.util.Objects.isNull;

public class Stack<T> {
  private Node<T> top;

  public Stack(Node<T> top) {
    this.top = top;
  }

  public Stack() {
    this.top = null;
  }

  public void push(T data) {
    // adds a new node with that value to the top of the stack with an O(1) Time performance.
    // TODO: make generic
    Node<T> newNode = new Node<>(data);
    newNode.setNext(this.top);
    this.top = newNode;
  }

  public T pop() throws Exception {
    // Returns: the value from node from the top of the stack
    // Removes the node from the top of the stack
    // Should raise exception when called on empty stack
    // TODO: make generic
    if(this.isEmpty() == true) {
      throw new Exception("Cannot pop. The Stack is empty.");
    } else {
      Node<T> prevTopNode = this.top;
      if(isNull(prevTopNode.getNext())) {
        this.top = null;
      } else {
        Node prevNextNode = this.top.getNext();
        this.top = prevNextNode;
      }
      prevTopNode.setNext(null);
      return prevTopNode.getData();
    }
  }

  public T peek() throws Exception {
    // Returns: Value of the node located at the top of the stack
    // Should raise exception when called on empty stack
    if(this.isEmpty() == true) {
      throw new Exception("Cannot peek. The Stack is empty.");
    } else {
      return this.top.getData();
    }
  }

  public boolean isEmpty() {
    if(this.getTop() != null) {
      return false;
    } else return true;
  }

  public Node<T> getTop() {
    return top;
  }

  public void setTop(Node<T> top) {
    this.top = top;
  }
}
