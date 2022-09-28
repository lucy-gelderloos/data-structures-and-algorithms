package datastructures.trees;

import datastructures.hashmap.HashMap;
import datastructures.linkedlist.Queue;

import java.util.ArrayList;

import static java.util.Objects.isNull;

public class BinaryTree<T> {
  private Node<T> root;

  public BinaryTree() {
    this.root = null;
  }

  public BinaryTree(Node<T> root) {
    this.root = root;
  }

  public ArrayList<T> getValuesPreOrder() {
    ArrayList<T> values = new ArrayList<>();
    preOrder(this.root, values);
    return values;
  }

  // https://www.techiedelight.com/preorder-tree-traversal-iterative-recursive/
  public void preOrder(Node<T> root, ArrayList<T> values) {
    if (root == null) {
      return;
      }
    values.add(root.getValue());
    if(!isNull(root.getLeft())) {
      preOrder(root.getLeft(), values);
    }
    if(!isNull(root.getRight())) {
      preOrder(root.getRight(), values);
    }
  }
  public ArrayList<T> getValuesInOrder() {
    ArrayList<T> values = new ArrayList<>();
    inOrder(this.root, values);
    return values;
  }

  public void inOrder(Node<T> root, ArrayList<T> values) {
    if (root == null) {
      return;
      }
    if(!isNull(root.getLeft())) {
      inOrder(root.getLeft(), values);
    }
    values.add(root.getValue());
    if(!isNull(root.getRight())) {
      inOrder(root.getRight(), values);
    }
  }

  public ArrayList<T> getValuesPostOrder() {
    ArrayList<T> values = new ArrayList<>();
    postOrder(this.root, values);
    return values;
  }

  public void postOrder(Node<T> root, ArrayList<T> values) {
    if (root == null) {
      return;
      }
    if(!isNull(root.getLeft())) {
      postOrder(root.getLeft(), values);
    }
    if(!isNull(root.getRight())) {
      postOrder(root.getRight(), values);
    }
    values.add(root.getValue());
  }

  public int getMax() throws Exception {
    if(isNull(this.root)) {
      throw new Exception("The tree is empty.");
    }
    int[] valueHolder = new int[1];
    valueHolder[0] = (int) this.root.getValue();
    findMax((Node<Integer>) this.root, valueHolder);
    return valueHolder[0];
  }
  public void findMax(Node<Integer> root, int[] valueHolder) {
    if(root == null) {
      return;
    }
    if(valueHolder[0] < root.getValue()) {
      valueHolder[0] = root.getValue();
    }
    if(!isNull(root.getLeft())) {
      findMax(root.getLeft(), valueHolder);
    }
    if(!isNull(root.getRight())) {
      findMax(root.getRight(), valueHolder);
    }
  }

  public static ArrayList breadthFirst(BinaryTree tree) throws Exception {
    if(isNull(tree.getRoot())) {
      throw new Exception("The tree is empty.");
    }
    // TODO: possible to use parameterized Node, Queue, etc.?
    Queue holdingQueue = new Queue<>();
    holdingQueue.enqueue(tree.getRoot());
    ArrayList values = new ArrayList<>();
    while(!isNull(holdingQueue.getFront())) {
      Node thisNode = (Node) holdingQueue.getFront().getData();
      if(!isNull(thisNode.getLeft())) {
        holdingQueue.enqueue(thisNode.getLeft());
      }
      if(!isNull(thisNode.getRight())) {
        holdingQueue.enqueue(thisNode.getRight());
      }
      values.add(thisNode.getValue());
      holdingQueue.dequeue();
    }
    return values;
  }

  public static BinaryTree<String> getFizzBuzz(BinaryTree<Integer> inputTree) throws Exception {
    if(isNull(inputTree.getRoot())) {
      throw new Exception("The tree is empty.");
    }
    BinaryTree<String> outputTree = new BinaryTree<>();
    outputTree.setRoot(new Node<String>());
    fizzBuzz(inputTree.getRoot(),outputTree.getRoot());
    return outputTree;
  }

  public static void fizzBuzz(Node<Integer> inputRoot,Node<String> outputRoot) {
    if(isNull(inputRoot)) {
      return;
    }

    Integer inputValue = inputRoot.getValue();
    if(inputValue%5 == 0 && inputValue%3 == 0) {
      outputRoot.setValue("FizzBuzz");
    } else if(inputValue%3 == 0) {
      outputRoot.setValue("Fizz");
    } else if(inputValue%5 == 0) {
      outputRoot.setValue("Buzz");
    } else { outputRoot.setValue(inputValue.toString()); }

    if(!isNull(inputRoot.getLeft())) {
      Node<String> newNode = new Node<>();
      outputRoot.setLeft(newNode);
      fizzBuzz(inputRoot.getLeft(),outputRoot.getLeft());
    }
    if(!isNull(inputRoot.getRight())) {
      Node<String> newNode = new Node<>();
      outputRoot.setRight(newNode);
      fizzBuzz(inputRoot.getRight(),outputRoot.getRight());
    }
  }


  public Node<T> getRoot() {
    return root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }
}
