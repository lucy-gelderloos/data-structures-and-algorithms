package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
    @Test void testCreateList() {
      LinkedList sut = new LinkedList();
      System.out.println(sut);
      assertNull(sut.getHead());
    }

    @Test void testCreateNode() {
      Node sut1 = new Node(3);
      Node sut2 = new Node();

      assertEquals(3, sut1.getValue());
      assertEquals(0, sut2.getValue());
    }

    @Test void testInsert() {
      // not sure how to test this other than using toString, but I don't like having a test depend on another method in the class I'm testing
      LinkedList sut = new LinkedList();
      sut.insert(7);
      sut.insert(10);
      assertEquals("{10} -> {7} -> NULL",sut.toString());
    }

    @Test void testHeadPointsToNext() {
      LinkedList sut = new LinkedList();
      sut.insert(7);
      sut.insert(10);
      assertEquals(7,sut.getHead().getNext().getValue());
    }

    @Test void testIncludes() {
      LinkedList sut = new LinkedList();
      sut.insert(7);
      sut.insert(10);
      assertTrue(sut.includes(7));
      assertFalse(sut.includes(15));
    }

    @Test void testToString() {
      LinkedList sut = new LinkedList();
      sut.insert(7);
      sut.insert(10);
      assertEquals("{10} -> {7} -> NULL",sut.toString());
    }

    @Test void testAppend() {
      LinkedList testList = new LinkedList();
      testList.insert(3);
      testList.insert(4);
      testList.insert(5);
      testList.insert(6);
      testList.insert(7);
      testList.append(2);
      assertEquals("{7} -> {6} -> {5} -> {4} -> {3} -> {2} -> NULL",testList.toString());
    }

    @Test void testInsertBefore() {
      LinkedList testList = new LinkedList();
      testList.insert(2);
      testList.insert(3);
      testList.insert(5);
      testList.insert(6);
      testList.insert(7);
      testList.insertBefore(4,3);
      assertEquals("{7} -> {6} -> {5} -> {4} -> {3} -> {2} -> NULL",testList.toString());
    }

    @Test void testInsertAfter() {
      LinkedList testList = new LinkedList();
      testList.insert(2);
      testList.insert(3);
      testList.insert(5);
      testList.insert(6);
      testList.insert(7);
      testList.insertAfter(4,5);
      assertEquals("{7} -> {6} -> {5} -> {4} -> {3} -> {2} -> NULL",testList.toString());
    }

    @Test void testKthFromEnd()  {
      LinkedList testList = new LinkedList();
      testList.insert(2);
      testList.insert(3);
      testList.insert(4);
      testList.insert(5);
      testList.insert(6);
      testList.insert(7);

      LinkedList shortTestList = new LinkedList();
      shortTestList.insert(3);

      assertEquals(5,testList.kthFromEnd(3),"k of 3 should return 5");
      assertEquals(2,testList.kthFromEnd(0),"k of 0 should return 2");
      assertEquals(2,testList.kthFromEnd(0),"k of 6 should return 7");
      assertEquals(3,shortTestList.kthFromEnd(0),"k of 0 should return 3");
//      assertThrows(Exception,testList.kthFromEnd(8));
    }

}
