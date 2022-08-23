package datastructures.linkedlist;

public class LinkedList
{
  public Node head;

  public LinkedList() {
    // creates new list with head null
    this.head = null;
  }

  //https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
  public void insert(int value) {
    // creates new node using Node class
    Node newNode = new Node(value);
    // sets pointer of new node to point at current head
    newNode.setNext(this.head);
    // makes new node new head
    this.head = newNode;
  }

  public void append(int value) {
    // add value to end of list
    Node thisNode = this.head;
    while (thisNode != null) {
      thisNode = thisNode.getNext();
    }
    thisNode.setValue(value);
    thisNode.setNext(null);
  }

  public void insertBefore(int value, int targetValue) {
    // add value before first node containing specified target value
    Node thisNode = this.head;
    Node newNode = new Node(value);
    while (thisNode != null) {
      if(thisNode.getNext().getValue() == targetValue){
        thisNode.setNext(newNode);
        newNode.setNext(thisNode.getNext());
        break;
      }
    }
  }

  public void insertAfter(int value, int targetValue) {
    // add value after first node containing specified target value
    Node thisNode = this.head;
    Node newNode = new Node(value);
    while (thisNode != null) {
      if(thisNode.getValue() == targetValue){
        thisNode.setNext(newNode);
        newNode.setNext(thisNode.getNext());
        break;
      }
    }
  }

  public boolean includes(int value) {
    // start at the head of the list
    Node thisNode = this.head;
    // if this node is null, exit
    while (thisNode != null) {
      // get value of this node & return true if value matches argument
      if (thisNode.getValue() == value) {
        return true;
      }
      // move to the next node
      thisNode = thisNode.getNext();
      }
      return false;
  }

  @Override
  public String toString() {
    String contents = "";
    // same loop as above, except add the value to the string instead of checking against an argument
    Node thisNode = this.head;
    while (thisNode != null) {
      contents += "{" + thisNode.getValue() + "} -> ";
      thisNode = thisNode.getNext();
    }
      return contents + "NULL";
    }
}
