package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
    @Test void testCreate() {
      LinkedList sut = new LinkedList();
      System.out.println(sut);
      assertNull(sut.head);
      assertTrue(sut.head == null);
    }

    @Test void testInsert() {
      LinkedList sut = new LinkedList();
      sut.insert("firstNewHead");
      sut.insert("secondNewHead");
      assertEquals(sut.toString(),"{secondNewHead} -> {firstNewHead} -> NULL");
    }

    @Test void testHeadPointsToNext() {
      LinkedList sut = new LinkedList();
      sut.insert("firstNewHead");
      sut.insert("secondNewHead");
      assertEquals(sut.head.getNext().value,"firstNewHead");
    }
}
