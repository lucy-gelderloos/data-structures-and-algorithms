package datastructures.sorting.insertion;

public class InsertionSort {

  public static int[] insertionSort(int[] array) {
    for(int i = 1; i < array.length; i ++) {
      int j = i - 1;
      int temp = array[i];

      while(j >= 0 && temp < array[j]) {
        array[j + 1] = array[j];
        j = j - 1;
        array[j + 1] = temp;
      }
    }
    return array;
  }

public static String toTestingString(int[] array) {
    String testingString = "[";
    for(int i = 0; i < array.length - 1; i++) {
      testingString += array[i] + ", ";
    }
    testingString += array[array.length - 1] + "]";
    return testingString;
}


}
