package datastructures.linkedlist;

public class BinaryNode {
  private int value;
  private BinaryNode left;
  private BinaryNode right;

  public BinaryNode(int value){
    this.value = value;
  }


  public int getData() {
    return value;
  }

  public void setData(int value) {
    this.value = value;
  }

  public BinaryNode getLeft() {
    return left;
  }

  public void setLeft(BinaryNode left) {
    this.left = left;
  }

  public BinaryNode getRight() {
    return right;
  }

  public void setRight(BinaryNode right) {
    this.right = right;
  }
}
