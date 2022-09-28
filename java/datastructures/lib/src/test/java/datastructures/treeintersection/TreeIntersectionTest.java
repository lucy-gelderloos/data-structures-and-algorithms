package datastructures.treeintersection;

import datastructures.TreeIntersection.TreeIntersection;
import datastructures.trees.BinaryTree;
import datastructures.trees.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TreeIntersectionTest {

  @Test
  void testTreeIntersection() throws Exception {
    BinaryTree<Integer> testTreeOne = new BinaryTree<>();
    testTreeOne.setRoot(new Node<>(1));
    testTreeOne.getRoot().setLeft(new Node<>(2));
    testTreeOne.getRoot().setRight(new Node<>(3));
    testTreeOne.getRoot().getLeft().setLeft(new Node<>(4));
    testTreeOne.getRoot().getLeft().setRight(new Node<>(5));
    testTreeOne.getRoot().getRight().setLeft(new Node<>(6));
    testTreeOne.getRoot().getRight().setRight(new Node<>(7));

    BinaryTree<Integer> testTreeTwo = new BinaryTree<>();
    testTreeTwo.setRoot(new Node<>(10));
    testTreeTwo.getRoot().setLeft(new Node<>(2));
    testTreeTwo.getRoot().setRight(new Node<>(30));
    testTreeTwo.getRoot().getLeft().setLeft(new Node<>(4));
    testTreeTwo.getRoot().getLeft().setRight(new Node<>(50));
    testTreeTwo.getRoot().getRight().setLeft(new Node<>(6));
    testTreeTwo.getRoot().getRight().setRight(new Node<>(70));

    BinaryTree<Integer> testTreeThree = new BinaryTree<>();
    testTreeThree.setRoot(new Node<>(10));
    testTreeThree.getRoot().setRight(new Node<>(30));
    testTreeThree.getRoot().getLeft().setRight(new Node<>(50));
    testTreeThree.getRoot().getRight().setRight(new Node<>(70));

    BinaryTree<Integer> testTreeNull = new BinaryTree<>();

    assertEquals("[2,4,6]", TreeIntersection.treeIntersection(testTreeOne,testTreeTwo).toString());
    assertEquals("[]", TreeIntersection.treeIntersection(testTreeOne,testTreeThree).toString());
    assertEquals("[]", TreeIntersection.treeIntersection(testTreeOne,testTreeNull).toString());

    Exception exception = assertThrows(Exception.class, () -> TreeIntersection.treeIntersection(testTreeNull,testTreeNull));
    assertEquals("Both trees are empty.",exception.getMessage());
  }
}
