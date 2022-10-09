package datastructures;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.Node;

import java.util.ArrayList;

public class Practice {

  public static String toTestString(int[] arr) {
    String returnString = "[";
    for(int i = 0; i < arr.length - 1; i++) {
      returnString += arr[i] + ",";
    }
    returnString += arr[arr.length - 1] + "]";
    return returnString;
  }
  public static int[] revArr(int[] arr) {
    int[] newArr = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      newArr[i] = arr[arr.length - 1 - i];
    }
    return newArr;
  }

  public static int[] insertIntoArr(int[] arr, int value) {
    int[] newArr = new int[arr.length + 1];
    int midIndex = 0;
    if(arr.length % 2 == 0) {
      midIndex = (arr.length / 2) - 1;
    } else {
      midIndex = (arr.length - 1) / 2;
    }
    for(int i = 0; i < newArr.length; i++) {
      if(i <= midIndex) {
        newArr[i] = arr[i];
      } else if(i == midIndex + 1) {
        newArr[i] = value;
      } else {
        newArr[i] = arr[i - 1];
      }
    }
    return newArr;
  }

  public static int binarySearch(int[] arr, int key) {
    int lowIndex = 0;
    int highIndex = arr.length - 1;
    int midIndex = 0;
    if((highIndex - lowIndex) % 2 == 0) {
      midIndex = (highIndex - lowIndex) / 2;
    } else {
      midIndex = (arr.length) / 2;
    }
    while(arr[lowIndex] <= key && arr[highIndex] >= key) {
      if(arr[midIndex] == key){
        return midIndex;
      } else if(arr[midIndex] > key) {
        midIndex = midIndex / 2;
      } else {
        midIndex += midIndex / 2;
      }
    }
    return -1;
  }

  public static int kthFromEnd(LinkedList<Integer> list, int k) {
    Node<Integer> temp = list.getHead();
    ArrayList<Integer> holdingList = new ArrayList<>();
    while(temp != null) {
      holdingList.add(temp.getData());
      temp = temp.getNext();
    }
    return holdingList.get(holdingList.size() - k - 1);
  }

}
