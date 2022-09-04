package datastructures.trees;

import static java.util.Objects.isNull;

public class BinarySearchTree extends BinaryTree {
  public BinarySearchTree() {
    super();
  }

  public void add(int value) {
    Node newNode = new Node(value);
    if(isNull(this.getRoot())) {
      this.setRoot(newNode);
    } else {
      addNode(this.getRoot(),newNode);
    }
  }

  public void addNode(Node root, Node newNode) {
    if(root.getValue() > newNode.getValue()) {
      if(isNull(root.getLeft())) {
        root.setLeft(newNode);
      } else addNode(root.getLeft(), newNode);
    } else if(root.getValue() < newNode.getValue()) {
      if(isNull(root.getRight())) {
        root.setRight(newNode);
      } else addNode(root.getRight(),newNode);
    }
    // if the new value is neither less than nor greater than, do nothing
  }

  public boolean contains(int value) {
    Node currentNode = this.getRoot();
    while(!isNull(currentNode)) {
      if(currentNode.getValue() == value) {
        return true;
      } else if(currentNode.getValue() > value) {
        currentNode = currentNode.getLeft();
      } else {
        currentNode = currentNode.getRight();
      }
    }
    return false;
  }

}
