package datastructures.linkedlist;

import java.util.ArrayList;

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

    if(isNull(this.head)) {
      throw new Exception("The list is empty.");
    }
    Node<T> thisNode = this.head;
    ArrayList<T> holdingArray = new ArrayList<>();
    while(thisNode != null) {
      holdingArray.add(thisNode.getData());
      thisNode = thisNode.getNext();
    }
    if(holdingArray.size() < k) {
      throw new Exception("The list is too short.");
    } else {
      return holdingArray.get(holdingArray.size() - k - 1);
    }
  }

  public static LinkedList<Integer> zipLists(LinkedList<Integer> list1, LinkedList<Integer> list2) throws Exception {

    if(isNull(list1.getHead()) || isNull(list2.getHead())) {
      if(isNull(list1.getHead()) && isNull(list2.getHead())) {
        throw new Exception("Both lists are empty.");
      } else if(isNull(list1.getHead())) {
        list1 = list2;
      }
      return list1;

    } else {
      Node<Integer> list1PointerNode = list1.getHead();
      Node<Integer> list2PointerNode = list2.getHead();

      Node<Integer> list1PointerNext;
      Node<Integer> list2PointerNext;

      while(!isNull(list1PointerNode) && !isNull(list2PointerNode)) {
        // if the next node in list 1 is not null, set the pointer next node to the next node
        if(!isNull(list1PointerNode.getNext())) {
          list1PointerNext = list1PointerNode.getNext();
          // if the next node is null, set the pointer next node to null
        } else { list1PointerNext = null; }

        // set the list 1 pointer node next to the list 2 pointer node
        list1PointerNode.setNext(list2PointerNode);

        // if the next node in list 2 is not null and the list 1 pointer next node is null (i.e., we've reached the end of list 1), return
        if(!isNull(list2PointerNode.getNext())) {
          if(isNull(list1PointerNext)) {
            return list1;
          }
          // if the next node in neither list is null, set the list 2 pointer next node to the next node
          list2PointerNext = list2PointerNode.getNext();
          // else if the next node in list 2 is null, set the next pointer node to null
        } else { list2PointerNext = null; }

        // point the list 2 pointer node at the list 1 pointer next node
        list2PointerNode.setNext(list1PointerNext);

        // move both pointer nodes forward
        list1PointerNode = list1PointerNext;
        list2PointerNode = list2PointerNext;
      }
    }
    return list1;
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

  public static boolean validateBrackets(String inputString) throws Exception {
    // TODO: exception for strings with no brackets

    if(inputString.length() == 0) {
      throw new Exception("The string is empty.");
    }

    Stack<Character> holdingStack = new Stack<>();

    ArrayList<Character> openingBrackets = new ArrayList<>();
    openingBrackets.add('[');
    openingBrackets.add('{');
    openingBrackets.add('(');

    ArrayList<Character> closingBrackets = new ArrayList<>();
    closingBrackets.add(']');
    closingBrackets.add('}');
    closingBrackets.add(')');

    int bracketCounter = 0;

    for(int i = 0; i < inputString.length(); i++) {
      Character currentChar = inputString.charAt(i);
      if (openingBrackets.contains(currentChar)) {
        // if the character is an opening bracket, push it onto the top of the holding stack
        holdingStack.push(currentChar);
        bracketCounter++;
      } else if (closingBrackets.contains(currentChar)) {
        // if the character is a closing bracket, look up the corresponding opening bracket
        Character matchingBracket = openingBrackets.get(closingBrackets.indexOf(currentChar));
        bracketCounter++;
        if (holdingStack.isEmpty() || matchingBracket != holdingStack.peek()) {
          // if the holding stack is empty or the top value isn't the right opening bracket, return false
          return false;
        } else {
          // otherwise, pop the opening bracket off the holding stack
          holdingStack.pop();
        }
      }
    }
    if(bracketCounter == 0) {
      // if, after iterating through the input string, the bracket counter is still 0 (i.e., no opening OR closing brackets have been found), throw an exception
      throw new Exception("There are no brackets in the string.");
    } else if(!holdingStack.isEmpty()) {
      // if, after iterating through the input string, there are still unmatched brackets left in the holding stack, return false
      return false;
    } else return true;
  }

  public Node<T> getHead() {
    return head;
  }

  public void setHead(Node<T> head) {
    this.head = head;
  }
}
