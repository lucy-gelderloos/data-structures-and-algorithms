package datastructures.trees;

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

  public Node<T> getRoot() {
    return root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }
}
