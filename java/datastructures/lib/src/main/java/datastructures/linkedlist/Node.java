package datastructures.linkedlist;

public class Node {
  int value;
  Node next;

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

}
