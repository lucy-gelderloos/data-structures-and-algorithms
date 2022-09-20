package datastructures.sorting;

import datastructures.sorting.insertion.SelectionSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class sortingTest {

  @Test
  void testSelectionSort() {
    int[] testArr = new int[]{8,4,23,42,16,15};
    int[] testArrReversed = new int[]{20,18,12,8,5,-2};
    int[] testArrDupes = new int[]{5,12,7,5,5,7};
    int[] testArrAlmost = new int[]{2,3,5,7,13,11};

    SelectionSort.selectionSort(testArr);
    SelectionSort.selectionSort(testArrReversed);
    SelectionSort.selectionSort(testArrDupes);
    SelectionSort.selectionSort(testArrAlmost);

    assertEquals("[4, 8, 15, 16, 23, 42]",SelectionSort.toTestingString(testArr));
    assertEquals("[-2, 5, 8, 12, 18, 20]",SelectionSort.toTestingString(testArrReversed));
    assertEquals("[5, 5, 5, 7, 7, 12]",SelectionSort.toTestingString(testArrDupes));
    assertEquals("[2, 3, 5, 7, 11, 13]",SelectionSort.toTestingString(testArrAlmost));
  }
}
