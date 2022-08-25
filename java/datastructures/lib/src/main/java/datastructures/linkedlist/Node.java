package datastructures.linkedlist;

public class Node {
  private int value;
  private Node next;
  private Node prev;

//  https://www.javatpoint.com/java-program-to-create-a-singly-linked-list-of-n-nodes-and-count-the-number-of-nodes

  public Node(int value){
    this.value = value;
  }

  public Node() {
    this.value = 0;
  }

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

  public Node getPrev() { return prev; }

  public void setPrev(Node prev) {
    this.prev = prev;
  }
}
