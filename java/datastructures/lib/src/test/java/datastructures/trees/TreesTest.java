package datastructures.trees;

import datastructures.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TreesTest {

  @Test
  void testCreateTree() {
    BinaryTree<Integer> nullTree = new BinaryTree<>();
    Node<Integer> newNode = new Node<>(5);
    BinaryTree<Integer> oneNodeTree = new BinaryTree<>(newNode);

    BinarySearchTree nullSearchTree = new BinarySearchTree();
    BinarySearchTree oneNodeSearchTree = new BinarySearchTree(newNode);

    assertNull(nullTree.getRoot());
    assertNull(nullSearchTree.getRoot());
    assertEquals(5, oneNodeTree.getRoot().getValue().intValue());
    assertEquals(5, oneNodeSearchTree.getRoot().getValue().intValue());
  }

  @Test
  void testPreOrderTraversal() {
    BinaryTree<Integer> testTree = new BinaryTree<>();
    testTree.setRoot(new Node<>(1));
    testTree.getRoot().setLeft(new Node<>(2));
    testTree.getRoot().setRight(new Node<>(3));
    testTree.getRoot().getLeft().setLeft(new Node<>(4));
    testTree.getRoot().getLeft().setRight(new Node<>(5));
    testTree.getRoot().getRight().setLeft(new Node<>(6));
    testTree.getRoot().getRight().setRight(new Node<>(7));

    ArrayList<Integer> expectedReturn = new ArrayList<>();
    expectedReturn.add(1);
    expectedReturn.add(2);
    expectedReturn.add(4);
    expectedReturn.add(5);
    expectedReturn.add(3);
    expectedReturn.add(6);
    expectedReturn.add(7);

    assertEquals(expectedReturn, testTree.getValuesPreOrder(), "preOrder");
  }

  @Test
  void testInOrderTraversal() {
    BinaryTree<Integer> testTree = new BinaryTree<>();
    testTree.setRoot(new Node<>(1));
    testTree.getRoot().setLeft(new Node<>(2));
    testTree.getRoot().setRight(new Node<>(3));
    testTree.getRoot().getLeft().setLeft(new Node<>(4));
    testTree.getRoot().getLeft().setRight(new Node<>(5));
    testTree.getRoot().getRight().setLeft(new Node<>(6));
    testTree.getRoot().getRight().setRight(new Node<>(7));

    ArrayList<Integer> expectedReturn = new ArrayList<>();
    expectedReturn.add(4);
    expectedReturn.add(2);
    expectedReturn.add(5);
    expectedReturn.add(1);
    expectedReturn.add(6);
    expectedReturn.add(3);
    expectedReturn.add(7);

    assertEquals(expectedReturn, testTree.getValuesInOrder(), "inOrder");
  }

  @Test
  void testPostOrderTraversal() {
    BinaryTree<Integer> testTree = new BinaryTree<>();
    testTree.setRoot(new Node<>(1));
    testTree.getRoot().setLeft(new Node<>(2));
    testTree.getRoot().setRight(new Node<>(3));
    testTree.getRoot().getLeft().setLeft(new Node<>(4));
    testTree.getRoot().getLeft().setRight(new Node<>(5));
    testTree.getRoot().getRight().setLeft(new Node<>(6));
    testTree.getRoot().getRight().setRight(new Node<>(7));

    ArrayList<Integer> expectedReturn = new ArrayList<>();
    expectedReturn.add(4);
    expectedReturn.add(5);
    expectedReturn.add(2);
    expectedReturn.add(6);
    expectedReturn.add(7);
    expectedReturn.add(3);
    expectedReturn.add(1);

    assertEquals(expectedReturn, testTree.getValuesPostOrder(), "postOrder");
  }

  @Test
  void testAdd() {
    int[] searchTreeValues = new int[]{4, 8, 15, 16, 22, 23, 27, 42, 85, 105};
    BinarySearchTree testSearchTree = new BinarySearchTree();
    ArrayList<Integer> expectedValues = new ArrayList<>();
    for (int value : searchTreeValues) {
      testSearchTree.add(value);
      expectedValues.add(value);
    }

    int[] searchTreeValuesReversed = new int[]{105, 85, 42, 27, 23, 22, 16, 15, 8, 4};
    BinarySearchTree testSearchTreeReversed = new BinarySearchTree();
    for (int value : searchTreeValuesReversed) {
      testSearchTreeReversed.add(value);
    }

    int[] searchTreeValuesScrambled = new int[]{23, 85, 15, 8, 27, 22, 105, 4, 16, 42};
    BinarySearchTree testSearchTreeScrambled = new BinarySearchTree();
    for (int value : searchTreeValuesScrambled) {
      testSearchTreeScrambled.add(value);
    }

    assertEquals(expectedValues, testSearchTree.getValuesInOrder());
    assertEquals(expectedValues, testSearchTreeReversed.getValuesInOrder());
    assertEquals(expectedValues, testSearchTreeScrambled.getValuesInOrder());
  }

  @Test
  void testContains() {
    int[] searchTreeValues = new int[]{4, 8, 15, 16, 22, 23, 27, 42, 85, 105};
    BinarySearchTree testSearchTree = new BinarySearchTree();
    for (int value : searchTreeValues) {
      testSearchTree.add(value);
    }

    assertTrue(testSearchTree.contains(16));
    assertTrue(testSearchTree.contains(42));
    assertFalse(testSearchTree.contains(43));
  }

  @Test
  void testFindMax() throws Exception {
    BinaryTree<Integer> testTree = new BinaryTree<>();
    testTree.setRoot(new Node<>(8));
    testTree.getRoot().setLeft(new Node<>(13));
    testTree.getRoot().setRight(new Node<>(1));
    testTree.getRoot().getLeft().setLeft(new Node<>(1));
    testTree.getRoot().getLeft().setRight(new Node<>(6));
    testTree.getRoot().getRight().setRight(new Node<>(14));
    testTree.getRoot().getLeft().getRight().setLeft(new Node<>(14));
    testTree.getRoot().getLeft().getRight().setRight(new Node<>(7));
    testTree.getRoot().getRight().getRight().setRight(new Node<>(3));

    BinaryTree<Integer> testBabyTree = new BinaryTree<>();
    testBabyTree.setRoot(new Node<>(4));

    BinaryTree<Integer> testNullTree = new BinaryTree<>();

    assertEquals(14,testTree.getMax());
    assertEquals(4,testBabyTree.getMax());

    Exception exception = assertThrows(Exception.class, () -> testNullTree.getMax());
    assertEquals("The tree is empty.", exception.getMessage());
  }

  @Test
  void testBreadthFirst() throws Exception {
    BinaryTree<Integer> testTree = new BinaryTree<>();
    testTree.setRoot(new Node<>(8));
    testTree.getRoot().setLeft(new Node<>(13));
    testTree.getRoot().setRight(new Node<>(1));
    testTree.getRoot().getLeft().setLeft(new Node<>(1));
    testTree.getRoot().getLeft().setRight(new Node<>(6));
    testTree.getRoot().getRight().setRight(new Node<>(14));
    testTree.getRoot().getLeft().getRight().setLeft(new Node<>(14));
    testTree.getRoot().getLeft().getRight().setRight(new Node<>(7));
    testTree.getRoot().getRight().getRight().setRight(new Node<>(3));

    BinaryTree<Integer> testBabyTree = new BinaryTree<>();
    testBabyTree.setRoot(new Node<>(4));

    BinaryTree<Integer> testNullTree = new BinaryTree<>();

    // [8,13,1,1,6,14,14,7,3]

    assertEquals("[8, 13, 1, 1, 6, 14, 14, 7, 3]",BinaryTree.breadthFirst(testTree).toString());
    assertEquals("[4]",BinaryTree.breadthFirst(testBabyTree).toString());

    Exception exception = assertThrows(Exception.class, () -> BinaryTree.breadthFirst(testNullTree));
    assertEquals("The tree is empty.", exception.getMessage());
  }

}
