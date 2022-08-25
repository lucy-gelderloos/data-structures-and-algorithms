package datastructures.linkedlist;

public class LinkedList
{
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

  public void append(int value) {
    // add value to end of list
    Node newNode = new Node(value);
    Node thisNode = this.head;
    if (thisNode != null) {
      while (thisNode != null && thisNode.getNext() != null) {
        thisNode = thisNode.getNext();
      }
      thisNode.setNext(newNode);
    } else { this.setHead(newNode); }
    newNode.setNext(null);
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
    while (thisNode != null) {
      if (thisNode.getValue() == targetValue) {
        break;
      }
      thisNode = thisNode.getNext();
    }
    newNode.setNext(thisNode.getNext());
    thisNode.setNext(newNode);
  }

  public boolean includes(int value) {
    // start at the head of the list
    Node thisNode = this.getHead();
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

  public static LinkedList zipLists(LinkedList list1, LinkedList list2) throws Exception {
    if(list1.getHead() == null && list2.getHead() == null) {
      throw new Exception("Both lists are empty.");
    }

    LinkedList outputList = new LinkedList();
    Node list1CurrentNode = list1.getHead();
    Node list2CurrentNode = list2.getHead();

    while(list1CurrentNode != null || list2CurrentNode != null){
      if(list1CurrentNode != null) {
        outputList.append(list1CurrentNode.getValue());
        list1CurrentNode = list1CurrentNode.getNext();
      }
      if(list2CurrentNode != null) {
        outputList.append(list2CurrentNode.getValue());
        list2CurrentNode = list2CurrentNode.getNext();
      }
    }
    return outputList;
  }

  public static LinkedList zipSortedLists(LinkedList list1, LinkedList list2) throws Exception {
    if(list1.getHead() == null && list2.getHead() == null) {
      throw new Exception("Both lists are empty.");
    }

    LinkedList outputList = new LinkedList();
    Node list1CurrentNode = list1.getHead();
    Node list2CurrentNode = list2.getHead();

    while(list1CurrentNode != null && list2CurrentNode != null){
      if(list1CurrentNode.getValue() < list2CurrentNode.getValue()) {
        outputList.append(list1CurrentNode.getValue());
        list1CurrentNode = list1CurrentNode.getNext();
      } else {
        outputList.append(list2CurrentNode.getValue());
        list2CurrentNode = list2CurrentNode.getNext();
      }
    }

    Node overflowNode;

    if(list1CurrentNode != null){
      overflowNode = list1CurrentNode;
    } else { overflowNode = list2CurrentNode; }

    while(overflowNode != null) {
      outputList.append(overflowNode.getValue());
      overflowNode = overflowNode.getNext();
    }

    return outputList;
  }

  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }
}
