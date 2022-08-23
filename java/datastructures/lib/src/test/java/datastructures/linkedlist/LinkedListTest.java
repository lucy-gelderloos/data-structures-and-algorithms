package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
    @Test void testCreate() {
      LinkedList sut = new LinkedList();
      System.out.println(sut);
      assertNull(sut.head);
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
      assertEquals(7,sut.head.getNext().value);
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

}
