package datastructures.trees;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TreesTest {

  @Test void testPreOrderTraversal() {
    BinaryTree testTree = new BinaryTree();
    testTree.setRoot(new Node(1));
    testTree.getRoot().setLeft(new Node(2));
    testTree.getRoot().setRight(new Node(3));
    testTree.getRoot().getLeft().setLeft(new Node(4));
    testTree.getRoot().getLeft().setRight(new Node(5));
    testTree.getRoot().getRight().setLeft(new Node(6));
    testTree.getRoot().getRight().setRight(new Node(7));

    ArrayList<Integer> expectedReturn = new ArrayList<>();
    expectedReturn.add(1);
    expectedReturn.add(2);
    expectedReturn.add(4);
    expectedReturn.add(5);
    expectedReturn.add(3);
    expectedReturn.add(6);
    expectedReturn.add(7);

    assertEquals(expectedReturn,testTree.getValuesPreOrder(),"preOrder");
  }

  @Test void testInOrderTraversal() {
    BinaryTree testTree = new BinaryTree();
    testTree.setRoot(new Node(1));
    testTree.getRoot().setLeft(new Node(2));
    testTree.getRoot().setRight(new Node(3));
    testTree.getRoot().getLeft().setLeft(new Node(4));
    testTree.getRoot().getLeft().setRight(new Node(5));
    testTree.getRoot().getRight().setLeft(new Node(6));
    testTree.getRoot().getRight().setRight(new Node(7));

    ArrayList<Integer> expectedReturn = new ArrayList<>();
    expectedReturn.add(4);
    expectedReturn.add(2);
    expectedReturn.add(5);
    expectedReturn.add(1);
    expectedReturn.add(6);
    expectedReturn.add(3);
    expectedReturn.add(7);

    assertEquals(expectedReturn,testTree.getValuesInOrder(),"inOrder");
  }

  @Test void testPostOrderTraversal() {
    BinaryTree testTree = new BinaryTree();
    testTree.setRoot(new Node(1));
    testTree.getRoot().setLeft(new Node(2));
    testTree.getRoot().setRight(new Node(3));
    testTree.getRoot().getLeft().setLeft(new Node(4));
    testTree.getRoot().getLeft().setRight(new Node(5));
    testTree.getRoot().getRight().setLeft(new Node(6));
    testTree.getRoot().getRight().setRight(new Node(7));

    ArrayList<Integer> expectedReturn = new ArrayList<>();
    expectedReturn.add(4);
    expectedReturn.add(5);
    expectedReturn.add(2);
    expectedReturn.add(6);
    expectedReturn.add(7);
    expectedReturn.add(3);
    expectedReturn.add(1);

    assertEquals(expectedReturn,testTree.getValuesPostOrder(),"postOrder");
  }

}

