package datastructures;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PracticeTests {

  @Test
  public void testLongestUnique() {
//    assertEquals(3,Practice.lengthOfLongestSubstring("abcabcbb"));
    assertEquals(2,Practice.lengthOfLongestSubstring("au"));
  }

  @Test
  public void testRomanToInt() {
    assertEquals(1987,Practice.romanToInt("MCMLXXXVII"));
  }

  @Test
  public void testRotateMatrix() {
    int[][] testMatrix = new int[3][3];
    testMatrix[0][0] = 1;
    testMatrix[0][1] = 1;
    testMatrix[0][2] = 1;
    testMatrix[1][0] = 2;
    testMatrix[1][1] = 2;
    testMatrix[1][2] = 2;
    testMatrix[2][0] = 3;
    testMatrix[2][1] = 3;
    testMatrix[2][2] = 3;
    assertEquals("[3, 2, 1]", Arrays.toString(Practice.rotateMatrix(testMatrix)[0]));
  }

  @Test
  public void testIntToRoman() {
    assertEquals("III",Practice.intToRoman(3));
  }

  @Test
  public void testNumberOfSteps() {
    assertEquals(6,Practice.numberOfSteps(14));
  }

  @Test
  public void testKWeakestRows() {
    int[][] testMatrix = new int[5][5];
    testMatrix[0][0] = 1;
    testMatrix[0][1] = 1;
    testMatrix[0][2] = 0;
    testMatrix[0][3] = 0;
    testMatrix[0][4] = 0;
    testMatrix[1][0] = 1;
    testMatrix[1][1] = 1;
    testMatrix[1][2] = 1;
    testMatrix[1][3] = 1;
    testMatrix[1][4] = 0;
    testMatrix[2][0] = 1;
    testMatrix[2][1] = 0;
    testMatrix[2][2] = 0;
    testMatrix[2][3] = 0;
    testMatrix[2][4] = 0;
    testMatrix[3][0] = 1;
    testMatrix[3][1] = 1;
    testMatrix[3][2] = 0;
    testMatrix[3][3] = 0;
    testMatrix[3][4] = 0;
    testMatrix[4][0] = 1;
    testMatrix[4][1] = 1;
    testMatrix[4][2] = 1;
    testMatrix[4][3] = 1;
    testMatrix[4][4] = 1;

    int[][] testMatrix2 = new int[5][5];
    testMatrix2[0][0] = 1;
    testMatrix2[0][1] = 1;
    testMatrix2[0][2] = 1;
    testMatrix2[0][3] = 1;
    testMatrix2[0][4] = 1;
    testMatrix2[1][0] = 1;
    testMatrix2[1][1] = 1;
    testMatrix2[1][2] = 1;
    testMatrix2[1][3] = 1;
    testMatrix2[1][4] = 1;
    testMatrix2[2][0] = 1;
    testMatrix2[2][1] = 1;
    testMatrix2[2][2] = 1;
    testMatrix2[2][3] = 1;
    testMatrix2[2][4] = 1;
    testMatrix2[3][0] = 1;
    testMatrix2[3][1] = 1;
    testMatrix2[3][2] = 1;
    testMatrix2[3][3] = 1;
    testMatrix2[3][4] = 1;
    testMatrix2[4][0] = 1;
    testMatrix2[4][1] = 1;
    testMatrix2[4][2] = 1;
    testMatrix2[4][3] = 1;
    testMatrix2[4][4] = 1;

    assertEquals("[0, 1, 2]", Arrays.toString(Practice.kWeakestRows(testMatrix2, 3)));
  }

  @Test
  public void testStringReversals() {
    String testString = "Test case";
    assertEquals("esac tseT",Practice.revStringArr(testString));
    assertEquals("esac tseT",Practice.revStringStack(testString));
    assertEquals("esac tseT",Practice.revStringRecursive(testString));
  }

  @Test
  public void testRemoveElement() {
    int[] testArr1 = new int[]{3,2,2,3};
    int[] testArr2 = new int[]{0,1,2,2,3,0,4,2};
    int[] testArr3 = new int[]{2};

    assertEquals(8,Practice.removeElement(testArr3,3));
  }

  @Test
  public void testAddTwo() throws Exception {
    LinkedList<Integer> list1 = new LinkedList<>();
    list1.setHead(new Node<Integer>(2));
    list1.getHead().setNext(new Node<>(4));
    list1.getHead().getNext().setNext(new Node<>(9));

    LinkedList<Integer> list2 = new LinkedList<>();
    list2.setHead(new Node<Integer>(5));
    list2.getHead().setNext(new Node<Integer>(6));
    list2.getHead().getNext().setNext(new Node<>(4));
    list2.getHead().getNext().getNext().setNext(new Node<>(9));

    LinkedList<Integer> list3 = new LinkedList<>();
    list3.setHead(Practice.addTwoNumbers(list1.getHead(),list2.getHead()));

    assertEquals("{7} -> {0} -> {4} -> {0} -> {1} -> NULL", list3.toString());
  }

  @Test
  public void testFindMedian() {
    int[] nums1 = new int[]{1,2};
    int[] nums2 = new int[]{3,4};

    assertEquals(2.5,Practice.findMedian(nums1,nums2));
  }
}
