package datastructures.linkedlist;

public class PseudoQueue<T> {
  // the forwardStack's top is the front of the queue
  private Stack<T> forwardStack;
  // the backwardStack's top is the rear of the queue
  private Stack<T> backwardStack;

  public PseudoQueue() {
    this.forwardStack = new Stack<>();
    this.backwardStack = new Stack<>();
  }

  public void enqueue(T value) {
    // add the new node to the front of the pseudoqueue - i.e., the top of the forwardStack and the bottom of the backwardStack
    Node<T> newNode = new Node<>(value);

    // if the pseudoqueue is empty, make the new node its new front and rear
    if(forwardStack.getTop() == null) {
      this.forwardStack.setTop(newNode);
      this.backwardStack.setTop(newNode);
    } else {
      // else add the new node to the top of the backwardStack
      backwardStack.push(value);
      // and the bottom of the forwardStack
      Node<T> pointerNode = forwardStack.getTop();
      while(pointerNode.getNext() != null) {
        pointerNode = pointerNode.getNext();
      }
      pointerNode.setNext(newNode);
    }
  }

  public T dequeue() throws Exception {
    // if the pseudoqueue is empty, throw an exception
    if(forwardStack.getTop() == null) {
      throw new Exception("Cannot dequeue. The pseudoqueue is empty.");
      // if there is only one node in the pseudoqueue, return the value of that node and set the top of both stacks to null
    } else if(forwardStack.getTop() == backwardStack.getTop()) {
      T returnValue = forwardStack.getTop().getData();
      forwardStack.setTop(null);
      backwardStack.setTop(null);
      return returnValue;
      // else remove the top node of the forwardStack and the bottom node of the backwardStack
    } else {
      forwardStack.pop();

      Node<T> pointerNode = backwardStack.getTop();
      Node<T> pointerPrevNode = null;
      while(pointerNode.getNext() != null) {
        pointerPrevNode = pointerNode;
        pointerNode = pointerNode.getNext();
      }
      T returnValue = pointerNode.getData();
      pointerPrevNode.setNext(null);
      return returnValue;
    }
  }

  public Stack<T> getForwardStack() {
    return forwardStack;
  }

  public void setForwardStack(Stack<T> forwardStack) {
    this.forwardStack = forwardStack;
  }

  public Stack<T> getBackwardStack() {
    return backwardStack;
  }

  public void setBackwardStack(Stack<T> backwardStack) {
    this.backwardStack = backwardStack;
  }
}
