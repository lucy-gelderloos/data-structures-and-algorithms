package datastructures;

import datastructures.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PracticeTest {

  @Test
  public void testRevArr() {
    int[] testArr = new int[]{1,2,3,4,5};
    int[] resultArr = Practice.revArr(testArr);

    assertEquals("[5,4,3,2,1]",Practice.toTestString(resultArr));
  }

  @Test
  public void testInsertIntoArr() {
    int[] testArrOddLength = new int[]{1,2,3,4,5};
    int[] testArrEvenLength = new int[]{1,2,3,4};
    int[] testArrZero = new int[0];
    int[] resultArrOdd = Practice.insertIntoArr(testArrOddLength,6);
    int[] resultArrEven = Practice.insertIntoArr(testArrEvenLength,5);
    int[] resultArrZero = Practice.insertIntoArr(testArrZero,1);

    assertEquals("[1,2,3,6,4,5]",Practice.toTestString(resultArrOdd));
    assertEquals("[1,2,5,3,4]",Practice.toTestString(resultArrEven));
    assertEquals("[1]",Practice.toTestString(resultArrZero));
  }

  @Test
  public void testBinarySearch() {
    int[] testArrOdd = new int[]{1,2,3,4,5};
    int[] testArrEven = new int[]{1,2,3,4,5,6};

    assertEquals(2,Practice.binarySearch(testArrEven,3));
    assertEquals(4,Practice.binarySearch(testArrEven,5));
    assertEquals(-1,Practice.binarySearch(testArrEven,7));
  }

  @Test
  public void testKthFromEnd() {
    LinkedList<Integer> testList = new LinkedList<>();
    testList.append(5);
    testList.append(4);
    testList.append(3);
    testList.append(2);
    testList.append(1);

    assertEquals(1,Practice.kthFromEnd(testList,0));
    assertEquals(5,Practice.kthFromEnd(testList,4));
  }

}
