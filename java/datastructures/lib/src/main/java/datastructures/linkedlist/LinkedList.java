package datastructures.linkedlist;

public class LinkedList {
  private Node head;

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
    Node newNode = new Node(value);
    Node thisNode = this.head;
    while (thisNode.getNext() != null) {
      thisNode = thisNode.getNext();
    }
    thisNode.setNext(newNode);
    newNode.setNext(null);
    // TODO: account for empty list (wrap while loop in "while thisNode !null"?
  }

  public void insertBefore(int value, int targetValue) {
    // add value before first node containing specified target value
    Node thisNode = this.head;
    Node newNode = new Node(value);
    while (thisNode.getNext().getValue() != targetValue) {
      thisNode = thisNode.getNext();
    }
    newNode.setNext(thisNode.getNext());
    thisNode.setNext(newNode);
  }

  public void insertAfter(int value, int targetValue) {
    // add value after first node containing specified target value
    Node thisNode = this.head;
    Node newNode = new Node(value);
    while (thisNode.getValue() != targetValue) {
      thisNode = thisNode.getNext();
    }
    newNode.setNext(thisNode.getNext());
    thisNode.setNext(newNode);
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

  public int kthFromEnd(int k) {
    int kthValue;
    Node thisNode = this.head;
    try {
      while (thisNode.getNext() != null) {
        // sets this node as the previous node of the next node
        thisNode.getNext().setPrev(thisNode);
        thisNode = thisNode.getNext();
      }
      try {
        // if next node is null, this is the last node; start a for loop
        for (int i = k; i > 0; i--) {
          // turn around and go back k nodes
          thisNode = thisNode.getPrev();
        }
      } catch (Exception e) {
        System.out.println("Exception in for loop:" + e);
        }
    } catch (Exception e) {
      System.out.println("Exception in for loop:" + e);
      }
    kthValue = thisNode.getValue();
    return kthValue;
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

  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }
}
