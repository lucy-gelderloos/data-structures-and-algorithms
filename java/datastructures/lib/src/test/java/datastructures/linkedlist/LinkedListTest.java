package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
  @Test void testCreate()
    {
      LinkedList sut = new LinkedList();
      System.out.println(sut);
      assertNull(sut.head);
      assertTrue(sut.head == null);
    }
}
