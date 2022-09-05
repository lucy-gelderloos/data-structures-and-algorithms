package datastructures.linkedlist;

public class Node<T> {
  private T data;
  private Node<T> next;

//  https://www.javatpoint.com/java-program-to-create-a-singly-linked-list-of-n-nodes-and-count-the-number-of-nodes

  public Node(T data){
    this.data = data;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setData(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

}
