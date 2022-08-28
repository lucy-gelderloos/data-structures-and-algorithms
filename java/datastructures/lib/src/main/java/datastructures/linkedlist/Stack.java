package datastructures.linkedlist;

// Create a Stack class that has a top property. It creates an empty Stack when instantiated.
// This object should be aware of a default empty value assigned to top when the stack is created.

public class Stack {
  private Node top;

  public Stack(Node top) {
    this.top = top;
  }

  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    // adds a new node with that value to the top of the stack with an O(1) Time performance.
    // TODO: make generic
    Node newNode = new Node(value);
    newNode.setNext(this.top);
    this.top = newNode;
  }

  public int pop() throws Exception {
    // Returns: the value from node from the top of the stack
    // Removes the node from the top of the stack
    // Should raise exception when called on empty stack
    // TODO: make generic
    if(this.isEmpty() == true) {
      throw new Exception("Cannot pop. The Stack is empty.");
    } else {
      Node prevTopNode = this.top;
      if(prevTopNode.getNext() != null){
      this.setTop(prevTopNode.getNext());
      }
      prevTopNode.setNext(null);
      return prevTopNode.getValue();
    }
  }

  public int peek() throws Exception {
    // Returns: Value of the node located at the top of the stack
    // Should raise exception when called on empty stack
    if(this.isEmpty() == true) {
      throw new Exception("Cannot peek. The Stack is empty.");
    } else {
      return this.top.getValue();
    }
  }

  public boolean isEmpty() {
    return this.top != null;
  }

  public Node getTop() {
    return top;
  }

  public void setTop(Node head) {
    this.top = top;
  }
}
