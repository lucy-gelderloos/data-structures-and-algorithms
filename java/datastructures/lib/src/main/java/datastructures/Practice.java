package datastructures;

import datastructures.linkedlist.Node;
import datastructures.linkedlist.Queue;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Objects.isNull;

public class Practice {
  public static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0 || s.length() == 1) {
      return s.length();
    }
    int length = 0;
    for (int i = 0; i < s.length(); i++) {
      int j = i;
      HashSet<Character> holdingSet = new HashSet<>();
      while (j < s.length()) {
        if (!holdingSet.contains(s.charAt(j))) {
          holdingSet.add(s.charAt(j));
        } else {
          break;
        }
        j++;
      }
      if (holdingSet.size() > length) {
        length = holdingSet.size();
      }
    }
    return length;
  }

  public static int romanToInt(String s) {
    class RomanPair {
      String pair;
      int value;
      public RomanPair(String pair, int value) {
        this.pair = pair;
        this.value = value;
      }
      public static RomanPair[] create() {
        RomanPair[] pairs = new RomanPair[6];
        pairs[0] = new RomanPair("CM", 900);
        pairs[1] = new RomanPair("CD", 400);
        pairs[2] = new RomanPair("XC", 90);
        pairs[3] = new RomanPair("XL", 40);
        pairs[4] = new RomanPair("IX", 9);
        pairs[5] = new RomanPair("IV", 4);
        return pairs;
      }
    }
    class RomanSingle {
      char letter;
      int value;

      public RomanSingle(char letter, int value) {
        this.letter = letter;
        this.value = value;
      }
      public static RomanSingle[] create() {
        RomanSingle[] singles = new RomanSingle[7];
        singles[0] = new RomanSingle('M', 1000);
        singles[1] = new RomanSingle('D', 500);
        singles[2] = new RomanSingle('C', 100);
        singles[3] = new RomanSingle('L', 50);
        singles[4] = new RomanSingle('X', 10);
        singles[5] = new RomanSingle('V', 5);
        singles[6] = new RomanSingle('I', 1);
        return singles;
      }
    }

    int arabic = 0;

    RomanPair[] pairs = RomanPair.create();

    for (RomanPair pair : pairs) {
      if (s.contains(pair.pair)) {
        arabic += pair.value;
        s = s.replace(pair.pair, "");
      }
    }

    RomanSingle[] singles = RomanSingle.create();

    for (RomanSingle single : singles) {
      for (char letter : s.toCharArray()) {
        if (letter == single.letter) {
          arabic += single.value;
        }
      }
    }

    return arabic;
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> noteMap = stringToMap(ransomNote);
    HashMap<Character, Integer> magMap = stringToMap(magazine);
    for (char key : noteMap.keySet()) {
      if (!magMap.containsKey(key) || magMap.get(key) < noteMap.get(key)) {
        return false;
      }
    }
    return true;
  }

  public HashMap<Character, Integer> stringToMap(String s) {
    HashMap<Character, Integer> charMap = new HashMap<>(s.length());
    for (Character letter : s.toCharArray()) {
      if (!charMap.containsKey(letter)) {
        charMap.put(letter, 1);
      } else {
        int currentVal = charMap.get(letter);
        charMap.put(letter, currentVal + 1);
      }
    }
    return charMap;
  }

  public List<String> fizzBuzz(int n) {
    List<String> answer = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        answer.add("FizzBuzz");
      } else if (i % 3 == 0) {
        answer.add("Fizz");
      } else if (i % 5 == 0) {
        answer.add("Buzz");
      } else {
        answer.add("" + i);
      }
    }
    return answer;
  }

  public static int[] kWeakestRows(int[][] mat, int k) {
    //in progress
    int[] strengthArr = new int[mat.length];
    int minStrength = mat[0].length;
    for(int i = 0; i < mat.length; i++) {
      int thisStrength = 0;
      for(int j = 0; j < mat[i].length; j++) {
        thisStrength += mat[i][j];
      }
      if(thisStrength < minStrength) {
        minStrength = thisStrength;
      }
      strengthArr[i] = thisStrength;
    }
    ArrayList<Integer> sortedList = new ArrayList<>();
    for(int i = 0; i < mat.length; i++) {
      for(int j = 0; j <= strengthArr.length; j++) {
        if(strengthArr[j] == i) {
          sortedList.add(j);
        }
      }
    }
    int[] weakestArr = new int[k];
    for(int i = 0; i < k; i++) {
      weakestArr[i] = sortedList.get(i);
    }
    return weakestArr;
  }

  public static int[][] rotateMatrix(int[][] matrix) {
    int[][] resultArr = new int[3][3];
    for (int i = 0; i < matrix.length; i++) {
      int targetIndex = matrix.length - i - 1;
      for (int j = 0; j < matrix[i].length; j++) {
        resultArr[j][targetIndex] = matrix[i][j];
      }
    }
    return resultArr;
  }

  public static String intToRoman(int year) {
    class DecimalRoman {
      public int decimal;
      public String roman;

      DecimalRoman(int decimal, String roman) {
        this.decimal = decimal;
        this.roman = roman;
      }
      public static DecimalRoman[] create() {
        DecimalRoman[] refArr = new DecimalRoman[13];
        refArr[0] = new DecimalRoman(1000, "M");
        refArr[1] = new DecimalRoman(900, "CM");
        refArr[2] = new DecimalRoman(500, "D");
        refArr[3] = new DecimalRoman(400, "CD");
        refArr[4] = new DecimalRoman(100, "C");
        refArr[5] = new DecimalRoman(90, "XC");
        refArr[6] = new DecimalRoman(50, "L");
        refArr[7] = new DecimalRoman(40, "XL");
        refArr[8] = new DecimalRoman(10, "X");
        refArr[9] = new DecimalRoman(9, "IX");
        refArr[10] = new DecimalRoman(5, "V");
        refArr[11] = new DecimalRoman(4, "IV");
        refArr[12] = new DecimalRoman(1, "I");
        return refArr;
      }
    }

    DecimalRoman[] refArr = DecimalRoman.create();

    String romanYear = "";
//    int remainder = year;
    for (int i = 0; i < refArr.length; i++) {
      while (year / refArr[i].decimal >= 1) {
        romanYear += refArr[i].roman;
        year -= refArr[i].decimal;
      }
    }
    return romanYear;
  }

  public static int numberOfSteps(int num) {
    int steps = 0;
    while(num != 0) {
      if(num%2 == 0) {
        num = num/2;
      } else {
        num -= 1;
      }
      steps++;
    }
    return steps;
  }

  public static String revStringArr(String string) {
    String returnString = "";
    for(char c : string.toCharArray()) {
      returnString = c + returnString;
    }
    return returnString;
  }

  public static String revStringStack(String string) {
    String returnString = "";
    Stack<Character> holdingStack = new Stack<>();
    for(char c : string.toCharArray()) {
      holdingStack.push(c);
    }
    while(!holdingStack.isEmpty()) {
      returnString += holdingStack.pop();
    }
    return returnString;
  }

  public static String revStringRecursive(String string) {
    if(isNull(string) || string.length() <= 1) {
      return string;
    }
    return revStringRecursive(string.substring(1)) + string.charAt(0);
  }

  public static int removeElement(int[] nums, int val) {
    if(nums.length == 0) {
      return 0;
    }
    int highestIndex = findHighest(nums, val, nums.length - 1);
    int i = 0;
    while(highestIndex >= i) {
      if(nums[i] == val) {
        nums[i] = nums[highestIndex];
        nums[highestIndex] = val;
        highestIndex = findHighest(nums, val, highestIndex);
      }
      i++;
    }
//    if(highestIndex == 0) {
//      return 0;
//    }
    return highestIndex  + 1;
  }

  private static int findHighest(int[] nums, int val, int highestIndex) {
    while(nums[highestIndex] == val) {
      highestIndex--;
    }
    return highestIndex;
  }

  public static Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
    Node<Integer> thisNode1 = l1;
    Node<Integer> thisNode2 = l2;

    Node<Integer> sumHead = new Node<>(0);
    Node<Integer> thisNodeSum = sumHead;


    while(thisNode1 != null && thisNode2 != null) {
      int thisValue = thisNode1.getData() + thisNode2.getData() + thisNodeSum.getData();
      int nextValue = 0;
      if(thisValue >= 10) {
        nextValue = 1;
        thisValue = thisValue - 10;
      }
      thisNodeSum.setData(thisValue);
      thisNode1 = thisNode1.getNext();
      thisNode2 = thisNode2.getNext();

      if(thisNode1 == null && thisNode2 == null) {
        if(nextValue == 0) {
          return sumHead;
        } else {
          thisNodeSum.setNext(new Node<>(nextValue));
          return sumHead;
        }
      }
      thisNodeSum.setNext(new Node<>(nextValue));
      thisNodeSum = thisNodeSum.getNext();
    }

    if(thisNode1 == null) {
      thisNode1 = thisNode2;
    }

    while(thisNode1 != null) {
      int thisValue = thisNode1.getData() + thisNodeSum.getData();
      int nextValue = 0;
      if(thisValue >= 10) {
        nextValue = 1;
        thisValue = thisValue - 10;
      }
      thisNodeSum.setData(thisValue);
      thisNode1 = thisNode1.getNext();

      if(thisNode1 == null) {
        if(nextValue == 0) {
          return sumHead;
        } else {
          thisNodeSum.setNext(new Node<>(nextValue));
          return sumHead;
        }
      }
      thisNodeSum.setNext(new Node<>(nextValue));
      thisNodeSum = thisNodeSum.getNext();
    }


    return sumHead;

  }

  public static double findMedian(int[] nums1, int[] nums2) {
    int targetIndex1 = 0;
    int targetIndex2 = 0;
    int returnValue = 0;
    int nums1tracker = 0;
    int nums2tracker = 0;
    int totalLength = nums1.length + nums2.length;
    boolean singleIndex = false;

    if(nums1.length == 0 || nums2.length == 0) {
      if(nums1.length == 0) {
        nums1 = nums2;
      }
      int targetIndex = 0;
      if(nums1.length % 2 != 0) {
        targetIndex = (totalLength - 1) / 2;
        return nums1[targetIndex];
      } else {
        targetIndex = (totalLength / 2) - 1;
        return (nums1[targetIndex] + nums1[targetIndex + 1]) / 2;
      }
    }

    if(totalLength % 2 != 0) {
      targetIndex1 = (totalLength - 1) / 2;
      singleIndex = true;
    } else {
      targetIndex1 = (totalLength / 2) - 1;
      targetIndex2 = (totalLength / 2);
    }

    while((nums1tracker + nums2tracker < targetIndex1) && nums1tracker < nums1.length && nums2tracker < nums2.length) {
      if(nums1[nums1tracker] < nums2[nums2tracker]) {
        returnValue = nums1[nums1tracker];
        nums1tracker++;
      } else {
        returnValue = nums2[nums2tracker];
        nums2tracker++;
      }
    }

    if()

    if(singleIndex == false) {
      int firstValue = returnValue;
      int secondValue = 0;
      if(nums1[nums1tracker] <= returnValue) {
        secondValue = nums2[nums2tracker];
      } else {
        secondValue = nums1[nums1tracker];
      }
      returnValue = (firstValue + secondValue) / 2;
    }

    return returnValue;
  }

}

