package datastructures.linkedlist;

public class LinkedList
{
  public Node head;

  public LinkedList() {
    // creates new list with head null
    this.head = null;
  }

  //https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
  public void insert(String value) {
    // creates new node using Node class
    Node newNode = new Node(value);
    // sets pointer of new node to point at current head
    newNode.setNext(this.head);
    // makes new node new head
    this.head = newNode;
  }

  public boolean includes(String value) {
    // start at the head of the list
    Node thisNode = this.head;
    // if this node is null, exit
    while (thisNode != null) {
      // get value of this node & return true if value matches argument
      if (thisNode.getValue().equals(value)) {
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
