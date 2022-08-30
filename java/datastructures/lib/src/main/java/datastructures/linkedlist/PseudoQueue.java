package datastructures.linkedlist;

public class PseudoQueue<T> {
  // the forwardStack's top is the front of the queue
  private Stack<T> forwardStack;
  // the backwardStack's top is the rear of the queue
  private Stack<T> backwardStack;

  public PseudoQueue(Stack<T> forwardStack, Stack<T> backwardStack) {
    this.forwardStack = forwardStack;
    this.backwardStack = backwardStack;
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
