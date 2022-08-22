package datastructures.linkedlist;


//  https://www.javatpoint.com/java-program-to-create-a-singly-linked-list-of-n-nodes-and-count-the-number-of-nodes
public class LinkedList
{
  public Node head = null;
//  public Node tail = null;

  public void addNode(String value) {
    Node newNode = new Node(value);

    //Checks if the list is empty
    if(head == null) {
      //If list is empty, head will point to new node
      head = newNode;
    }
    else {

    }
  }

  @Override
  public String toString()
    {
        return "null";  // TODO: implement me
    }
}
