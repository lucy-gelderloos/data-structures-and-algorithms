package datastructures.trees;

import static java.util.Objects.isNull;

public class BinarySearchTree extends BinaryTree<Integer> {
  public BinarySearchTree() {
    super();
  }

  public BinarySearchTree(Node<Integer> root) {
    super();
    this.setRoot(root);
  }

  public void add(Integer value) {
    Node<Integer> newNode = new Node<>(value);
    if(isNull(this.getRoot())) {
      this.setRoot(newNode);
    } else {
      addNode(this.getRoot(),newNode);
    }
  }

  public void addNode(Node<Integer> root, Node<Integer> newNode) {
    if(root.getValue().compareTo(newNode.getValue()) > 0) {
      if(isNull(root.getLeft())) {
        root.setLeft(newNode);
      } else addNode(root.getLeft(), newNode);
    } else if(root.getValue().compareTo(newNode.getValue()) < 0) {
      if(isNull(root.getRight())) {
        root.setRight(newNode);
      } else addNode(root.getRight(),newNode);
    }
    // if the new value is neither less than nor greater than, do nothing
  }

  public boolean contains(Integer value) {
    Node<Integer> currentNode = this.getRoot();
    while(!isNull(currentNode)) {
      if(currentNode.getValue().equals(value)) {
        return true;
      } else if(currentNode.getValue().compareTo(value) > 0) {
        currentNode = currentNode.getLeft();
      } else {
        currentNode = currentNode.getRight();
      }
    }
    return false;
  }

}
