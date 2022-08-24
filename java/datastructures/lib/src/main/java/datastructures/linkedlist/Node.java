package datastructures.linkedlist;

public class Node {
  private int value;
  private Node next;

//  https://www.javatpoint.com/java-program-to-create-a-singly-linked-list-of-n-nodes-and-count-the-number-of-nodes

  public Node(int value){
    this.value = value;
  }

  public Node() {
    this.value = 0;
  }

  // TODO: constructors for lists of integers, strings, etc.

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getNext() {
    return next;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

}
