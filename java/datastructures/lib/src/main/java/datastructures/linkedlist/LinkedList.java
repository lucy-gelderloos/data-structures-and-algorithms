package datastructures.linkedlist;

import static java.util.Objects.isNull;

public class LinkedList<T>
{

  private Node<T> head;

  public LinkedList() {
    // creates new list with head null
    this.head = null;
  }

  @Override
  public String toString() {
    String contents = "";
    // same loop as above, except add the value to the string instead of checking against an argument
    Node<T> thisNode = this.head;

    while (thisNode != null) {
      contents += "{" + thisNode.getData() + "} -> ";
      thisNode = thisNode.getNext();
    }
    return contents + "NULL";
  }

  //https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
  public void insert(T data) {
    // creates new node using Node class
    Node<T> newNode = new Node<>(data);
    // sets pointer of new node to point at current head
    newNode.setNext(this.head);
    // makes new node new head
    this.head = newNode;
  }

  public void append(T data) {
    // add value to end of list
    Node<T> newNode = new Node<>(data);
    Node<T> thisNode = this.head;
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

  public void insertBefore(T data, T targetValue) throws Exception {
    // add value before first node containing specified target value
    Node<T> thisNode = this.head;
    Node<T> newNode = new Node<>(data);

    if(isNull(thisNode)) {
      throw new Exception("The list is empty.");
    }

    if(thisNode.getData() == targetValue) {
      // if the value of the head node is the target value, insert the value at the beginning of the list
      this.insert(data);
    } else {
      while (thisNode.getNext() != null) {
        // while the next node is not null, check if the value of the next node is the target value
        if (thisNode.getNext().getData() == targetValue) {
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

  public void insertAfter(T data, T targetValue) throws Exception {
    // add value after first node containing specified target value
    Node<T> thisNode = this.head;
    Node<T> newNode = new Node<>(data);
    while (thisNode != null) {
      if (thisNode.getData() != targetValue) {
        thisNode = thisNode.getNext();
      } else {
        newNode.setNext(thisNode.getNext());
        thisNode.setNext(newNode);
        return;
      }
    }
    throw new Exception("The target value is not in the list.");
  }

  public boolean includes(T value) {
    // start at the head of the list
    Node<T> thisNode = this.getHead();
    // if this node is null, exit
    while (thisNode != null) {
      // get value of this node & return true if value matches argument
      if (thisNode.getData() == value) {
        return true;
      }
      // move to the next node
      thisNode = thisNode.getNext();
    }
    return false;
  }


  public T kthFromEnd(int k) throws Exception {

    T kthValue;
    Node<T> thisNode = this.head;

    if(isNull(thisNode)) {
      throw new Exception("The list is empty.");
    }

    while(thisNode != null) {

      Node<T> nextNode = thisNode.getNext();

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
    kthValue = thisNode.getData();
    return kthValue;
  }

  public static LinkedList<Integer> zipLists(LinkedList<Integer> list1, LinkedList<Integer> list2) throws Exception {

    // TODO: a method to modify one of the lists in-place rather than creating a new list

    if(list1.getHead() == null && list2.getHead() == null) {
      // if both lists are empty, throw an exception
      throw new Exception("Both lists are empty.");
    }

    LinkedList<Integer> outputList = new LinkedList<>();
    // create empty output list
    Node<Integer> list1CurrentNode = list1.getHead();
    // point list1CurrentNode to the head of list1
    Node<Integer> list2CurrentNode = list2.getHead();
    // point list2CurrentNode to the head of list2

    while(list1CurrentNode != null || list2CurrentNode != null){
      // while either CurrentNode is not null
      if(list1CurrentNode != null) {
        // if list1CurrentNode is not null, insert it into output list, then move to the next node
        outputList.append(list1CurrentNode.getData());
        // TODO: because we know we're at the end of the output list, don't need to use append() to iterate through and find the end
        list1CurrentNode = list1CurrentNode.getNext();
      }
      if(list2CurrentNode != null) {
        // if list2CurrentNode is not null, insert it into output list, then move to the next node
        outputList.append(list2CurrentNode.getData());
        list2CurrentNode = list2CurrentNode.getNext();
      }
    }
    return outputList;
  }

  public static LinkedList<Integer> zipSortedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) throws Exception {

    if(list1.getHead() == null && list2.getHead() == null) {
      throw new Exception("Both lists are empty.");
    }

    LinkedList<Integer> outputList = new LinkedList<>();
    Node<Integer> list1CurrentNode = list1.getHead();
    Node<Integer> list2CurrentNode = list2.getHead();

    while(list1CurrentNode != null && list2CurrentNode != null){
      if(list1CurrentNode.getData() < list2CurrentNode.getData()) {
        outputList.append(list1CurrentNode.getData());
        list1CurrentNode = list1CurrentNode.getNext();
      } else {
        outputList.append(list2CurrentNode.getData());
        list2CurrentNode = list2CurrentNode.getNext();
      }
    }

    Node<Integer> overflowNode;

    if(list1CurrentNode != null){
      overflowNode = list1CurrentNode;
    } else { overflowNode = list2CurrentNode; }

    while(overflowNode != null) {
      outputList.append(overflowNode.getData());
      overflowNode = overflowNode.getNext();
    }

    return outputList;
  }

  public void reverse(LinkedList<T> list) {
    // TODO: try reversing list
  }

  public void isPalindrome(LinkedList<T> list) {
    // TODO: try checking if is palindrome
  }

  public Node<T> getHead() {
    return head;
  }

  public void setHead(Node<T> head) {
    this.head = head;
  }
}
