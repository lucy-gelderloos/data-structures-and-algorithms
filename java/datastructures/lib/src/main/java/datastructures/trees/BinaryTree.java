package datastructures.trees;

import datastructures.linkedlist.Stack;

import java.util.ArrayList;

import static java.util.Objects.isNull;

public class BinaryTree {
  private Node root;

  public BinaryTree() {
    this.root = null;
  }

  public ArrayList<Integer> getValuesPreOrder() {
    ArrayList<Integer> values = new ArrayList<>();
    preOrder(this.root, values);
    return values;
  }

  // https://www.techiedelight.com/preorder-tree-traversal-iterative-recursive/
  public void preOrder(Node root, ArrayList<Integer> values) {
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

  public ArrayList<Integer> getValuesInOrder() {
    ArrayList<Integer> values = new ArrayList<>();
    inOrder(this.root, values);
    return values;
  }

  public void inOrder(Node root, ArrayList<Integer> values) {
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

  public ArrayList<Integer> getValuesPostOrder() {
    ArrayList<Integer> values = new ArrayList<>();
    postOrder(this.root, values);
    return values;
  }

  public void postOrder(Node root, ArrayList<Integer> values) {
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

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }
}
