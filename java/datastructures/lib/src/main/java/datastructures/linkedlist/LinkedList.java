package datastructures.linkedlist;

import static java.util.Objects.isNull;

public class LinkedList
{
  private Node head;

  public LinkedList() {
    // creates new list with head null
    this.head = null;
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
    if (isNull(thisNode)) {
      this.setHead(newNode);
    } else {
      while (thisNode != null && thisNode.getNext() != null) {
        // iterate through and stop when thisNode is pointing at the last node
      thisNode = thisNode.getNext();
      }
      thisNode.setNext(newNode);
    }
    newNode.setNext(null);
  }

  public void insertBefore(int value, int targetValue) throws Exception {
    // add value before first node containing specified target value
    Node thisNode = this.head;
    Node newNode = new Node(value);

    if(isNull(thisNode)) {
      throw new Exception("The list is empty.");
    }

    if(thisNode.getValue() == targetValue) {
      // if the value of the head node is the target value, insert the value at the beginning of the list
      this.insert(value);
    } else {
      while (thisNode.getNext() != null) {
        // while the next node is not null, check if the value of the next node is the target value
        if (thisNode.getNext().getValue() == targetValue) {
          // if yes, set the new node to point to the next node
          newNode.setNext(thisNode.getNext());
          // set this node to point to the new node
          thisNode.setNext(newNode);
          return;
        } else {
          thisNode = thisNode.getNext();
        }
      }
    }
    throw new Exception("The target value is not in the list.");
  }

  public void insertAfter(int value, int targetValue) throws Exception {
    // add value after first node containing specified target value
    Node thisNode = this.head;
    Node newNode = new Node(value);
    while (thisNode != null) {
      if (thisNode.getValue() != targetValue) {
        thisNode = thisNode.getNext();
      } else {
        newNode.setNext(thisNode.getNext());
        thisNode.setNext(newNode);
        return;
      }
    }
    throw new Exception("The target value is not in the list.");
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


  public int kthFromEnd(int k) throws Exception {

    int kthValue;
    Node thisNode = this.head;

    if(isNull(thisNode)) {
      throw new Exception("The list is empty.");
    }

    while(thisNode != null) {

      Node nextNode = thisNode.getNext();

      if(nextNode != null) {
        // if the next node is not null, set this node as the previous node of the next node
        nextNode.setPrev(thisNode);
        // move to the next node
        thisNode = thisNode.getNext();
      } else {
        // if next node is null, this is the last node; start a for loop
        for(int i = 0; i < k; i++) {
          // turn around and go back k nodes
          thisNode = thisNode.getPrev();
        }
        break;
      }
    }
    kthValue = thisNode.getValue();
    return kthValue;
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
