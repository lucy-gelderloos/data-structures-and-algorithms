package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
    @Test void testCreateList() {
      LinkedList<Integer> sut = new LinkedList<>();
      System.out.println(sut);
      assertNull(sut.getHead());
    }

    @Test void testCreateNode() {
      Node<Integer> sutInt = new Node<>(3);
      Node<String> sutString = new Node<>("Pippin");

      assertEquals(3, sutInt.getData());
      assertEquals("Pippin", sutString.getData());
    }

    @Test void testInsert() {
      LinkedList<Integer> sut = new LinkedList<>();
      sut.insert(7);
      sut.insert(10);
      assertEquals("{10} -> {7} -> NULL",sut.toString());
    }

    @Test void testHeadPointsToNext() {
      LinkedList<Integer> sut = new LinkedList<>();
      sut.insert(7);
      sut.insert(10);
      assertEquals(7,sut.getHead().getNext().getData());
    }

    @Test void testIncludes() {
      LinkedList<Integer> sut = new LinkedList<>();
      sut.insert(7);
      sut.insert(10);
      assertTrue(sut.includes(7));
      assertFalse(sut.includes(15));
    }

    @Test void testToString() {
      LinkedList<Integer> sut = new LinkedList<>();
      sut.insert(7);
      sut.insert(10);
      assertEquals("{10} -> {7} -> NULL",sut.toString());
    }

    @Test void testAppend() {
      LinkedList<Integer> testList = new LinkedList<>();
      testList.insert(3);
      testList.insert(4);
      testList.insert(5);
      testList.insert(6);
      testList.insert(7);
      testList.append(2);
      assertEquals("{7} -> {6} -> {5} -> {4} -> {3} -> {2} -> NULL",testList.toString());
      assertEquals(7,testList.getHead().getData());
    }

    @Test void testInsertBefore() throws Exception {
      LinkedList<Integer> testList = new LinkedList<>();
      testList.insert(2);
      testList.insert(3);
      testList.insert(5);
      testList.insert(6);
      testList.insert(7);
      testList.insertBefore(4,3);

      assertEquals("{7} -> {6} -> {5} -> {4} -> {3} -> {2} -> NULL",testList.toString());

      Exception exception = assertThrows(Exception.class, () -> testList.insertBefore(4, 9));
      assertEquals("The target value is not in the list.", exception.getMessage());
    }

    @Test void testInsertAfter() throws Exception {
      LinkedList<Integer> testList = new LinkedList<>();
      testList.insert(2);
      testList.insert(3);
      testList.insert(5);
      testList.insert(6);
      testList.insert(7);
      testList.insertAfter(4,5);
      assertEquals("{7} -> {6} -> {5} -> {4} -> {3} -> {2} -> NULL",testList.toString());

      Exception exception = assertThrows(Exception.class, () -> testList.insertBefore(4, 9));
      assertEquals("The target value is not in the list.", exception.getMessage());
    }

  @Test void testKthFromEnd() throws Exception {
    LinkedList<Integer> testList = new LinkedList<>();
    testList.insert(2);
    testList.insert(3);
    testList.insert(4);
    testList.insert(5);
    testList.insert(6);
    testList.insert(7);

    LinkedList<Integer> shortTestList = new LinkedList<>();
    shortTestList.insert(3);

    assertEquals(5,testList.kthFromEnd(3),"k of 3 should return 5");
    assertEquals(2,testList.kthFromEnd(0),"k of 0 should return 2");
    assertEquals(2,testList.kthFromEnd(0),"k of 6 should return 7");
    assertEquals(3,shortTestList.kthFromEnd(0),"k of 0 should return 3");
//      assertThrows(Exception,testList.kthFromEnd(8));
  }


  @Test void testZipLists() throws Exception {
      LinkedList<Integer> list1 = new LinkedList<>();
      list1.append(1);
      list1.append(3);
      list1.append(5);

      LinkedList<Integer> list2 = new LinkedList<>();
      list2.append(2);
      list2.append(4);
      list2.append(6);

      LinkedList<Integer> list3 = new LinkedList<>();
      list3.append(2);
      list3.append(4);
      list3.append(6);
      list3.append(8);
      list3.append(10);

      LinkedList<Integer> list4 = new LinkedList<>();
      LinkedList<Integer> list5 = new LinkedList<>();

      // does it zip lists of equal length correctly?
      LinkedList<Integer> equalLengthLists = LinkedList.zipLists(list1, list2);

      // does it work correctly if one list is longer than the other?
      LinkedList<Integer> oneLonger = LinkedList.zipLists(list1, list3);

      // does it work correctly if one list is null?
      LinkedList<Integer> oneNull = LinkedList.zipLists(list1, list4);

      assertEquals("{1} -> {2} -> {3} -> {4} -> {5} -> {6} -> NULL",equalLengthLists.toString());
      assertEquals("{1} -> {2} -> {3} -> {4} -> {5} -> {6} -> {8} -> {10} -> NULL",oneLonger.toString());
      assertEquals("{1} -> {3} -> {5} -> NULL",oneNull.toString());

      // does it throw an exception if both lists are null?
      Exception exception = assertThrows(Exception.class, () -> LinkedList.zipLists(list4, list5));
      assertEquals("Both lists are empty.", exception.getMessage());
    }

    @Test void testZipSortedLists() throws Exception {
      LinkedList<Integer> sortedList1 = new LinkedList<>();
      sortedList1.append(1);
      sortedList1.append(2);
      sortedList1.append(5);
      sortedList1.append(7);

      LinkedList<Integer> sortedList2 = new LinkedList<>();
      sortedList2.append(3);
      sortedList2.append(4);
      sortedList2.append(5);
      sortedList2.append(6);

      LinkedList<Integer> list3 = new LinkedList<>();
      list3.append(3);
      list3.append(4);
      list3.append(5);
      list3.append(6);
      list3.append(8);

      LinkedList<Integer> list4 = new LinkedList<>();
      LinkedList<Integer> list5 = new LinkedList<>();

      // does it zip lists of equal length correctly?
      LinkedList<Integer> equalLengthLists = LinkedList.zipSortedLists(sortedList1, sortedList2);

      // does it work correctly if one list is longer than the other?
      LinkedList<Integer> oneLonger = LinkedList.zipSortedLists(sortedList1, list3);

      // does it work correctly if one list is null?
      LinkedList<Integer> oneNull = LinkedList.zipSortedLists(sortedList1, list4);

      assertEquals("{1} -> {2} -> {3} -> {4} -> {5} -> {5} -> {6} -> {7} -> NULL",equalLengthLists.toString());
      assertEquals("{1} -> {2} -> {3} -> {4} -> {5} -> {5} -> {6} -> {7} -> {8} -> NULL",oneLonger.toString());
      assertEquals("{1} -> {2} -> {5} -> {7} -> NULL",oneNull.toString());

      // does it throw an exception if both lists are null?
      Exception exception = assertThrows(Exception.class, () -> LinkedList.zipLists(list4, list5));
      assertEquals("Both lists are empty.", exception.getMessage());
    }
}


