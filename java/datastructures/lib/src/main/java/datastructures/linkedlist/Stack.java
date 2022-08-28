package datastructures.linkedlist;

// Create a Stack class that has a top property. It creates an empty Stack when instantiated.
// This object should be aware of a default empty value assigned to top when the stack is created.

public class Stack {
  private Node head;

  public Stack(Node head) {
    this.head = head;
  }

  public Stack() {
    this.head = null;
  }

  public void push(int value) {
    // adds a new node with that value to the top of the stack with an O(1) Time performance.
    // TODO: make generic
  }

  public void pop() throws Exception {
    // Returns: the value from node from the top of the stack
    // Removes the node from the top of the stack
    // Should raise exception when called on empty stack
  }

  public void peek() throws Exception {
    // Returns: Value of the node located at the top of the stack
    // Should raise exception when called on empty stack
  }

  public boolean isEmpty(Stack stack) {
    // Arguments: none
    // Returns: Boolean indicating whether the stack is empty.
    return true;
  }

  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }
}
