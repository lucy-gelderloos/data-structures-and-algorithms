package datastructures.sorting;

import datastructures.sorting.insertion.InsertionSort;
import datastructures.sorting.merge.MergeSort;
import datastructures.sorting.quick.QuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class sortingTest {

  @Test
  void testInsertionSort() {
    int[] testArr = new int[]{8,4,23,42,16,15};
    int[] testArrReversed = new int[]{20,18,12,8,5,-2};
    int[] testArrDupes = new int[]{5,12,7,5,5,7};
    int[] testArrAlmost = new int[]{2,3,5,7,13,11};

    InsertionSort.insertionSort(testArr);
    InsertionSort.insertionSort(testArrReversed);
    InsertionSort.insertionSort(testArrDupes);
    InsertionSort.insertionSort(testArrAlmost);

    assertEquals("[4, 8, 15, 16, 23, 42]", InsertionSort.toTestingString(testArr));
    assertEquals("[-2, 5, 8, 12, 18, 20]", InsertionSort.toTestingString(testArrReversed));
    assertEquals("[5, 5, 5, 7, 7, 12]", InsertionSort.toTestingString(testArrDupes));
    assertEquals("[2, 3, 5, 7, 11, 13]", InsertionSort.toTestingString(testArrAlmost));
  }

  @Test
  void testMergeSort() {
    int[] testArr = new int[]{8,4,23,42,16,15};
    int[] testArrReversed = new int[]{20,18,12,8,5,-2};
    int[] testArrDupes = new int[]{5,12,7,5,5,7};
    int[] testArrAlmost = new int[]{2,3,5,7,13,11};

    MergeSort.mergeSort(testArr);
    MergeSort.mergeSort(testArrReversed);
    MergeSort.mergeSort(testArrDupes);
    MergeSort.mergeSort(testArrAlmost);

    assertEquals("[4, 8, 15, 16, 23, 42]", InsertionSort.toTestingString(testArr));
    assertEquals("[-2, 5, 8, 12, 18, 20]", InsertionSort.toTestingString(testArrReversed));
    assertEquals("[5, 5, 5, 7, 7, 12]", InsertionSort.toTestingString(testArrDupes));
    assertEquals("[2, 3, 5, 7, 11, 13]", InsertionSort.toTestingString(testArrAlmost));
  }

 @Test
  void testQuickSort() {
    int[] testArr = new int[]{8,4,23,42,16,15};
    int[] testArrReversed = new int[]{20,18,12,8,5,-2};
    int[] testArrDupes = new int[]{5,12,7,5,5,7};
    int[] testArrAlmost = new int[]{2,3,5,7,13,11};
    int[] testArrAllSame = new int[]{1,1,1,1,1,1};

    QuickSort.getQuickSort(testArr);
    QuickSort.getQuickSort(testArrReversed);
    QuickSort.getQuickSort(testArrDupes);
    QuickSort.getQuickSort(testArrAlmost);
    QuickSort.getQuickSort(testArrAllSame);

    assertEquals("[4, 8, 15, 16, 23, 42]", InsertionSort.toTestingString(testArr));
    assertEquals("[-2, 5, 8, 12, 18, 20]", InsertionSort.toTestingString(testArrReversed));
    assertEquals("[5, 5, 5, 7, 7, 12]", InsertionSort.toTestingString(testArrDupes));
    assertEquals("[2, 3, 5, 7, 11, 13]", InsertionSort.toTestingString(testArrAlmost));
    assertEquals("[1, 1, 1, 1, 1, 1]", InsertionSort.toTestingString(testArrAllSame));
  }

}
