package datastructures.sorting.merge;

public class MergeSort {

  public static int[] mergeSort(int[] array) {
    int n = array.length;
    if(n > 1) {
      int mid = (int) Math.ceil((double)n / 2);
      int[] left = new int[mid];
      int[] right = new int[n - mid];
      for(int i = 0; i < array.length; i++) {
        if(i < mid) {
          left[i] = array[i];
        }
        else right[i - mid] = array[i];
      }
      mergeSort(left);
      mergeSort(right);
      merge(left,right,array);
    }
    return array;
  }

  public static int[] merge(int[] left, int[] right, int[] array) {
    int i = 0;
    int j = 0;
    int k = 0;
    while(i < left.length && j < right.length) {
      if(left[i] <= right[j]) {
        array[k] = left[i];
        i++;
      }
      else {
        array[k] = right[j];
        j++;
      }
      k++;
    }
    if(i == left.length) {
      for(int x = k; x < array.length; x++) {
        array[x] = right[j];
        j++;
      }
    }
    else {
      for(int x = k; x < array.length; x++) {
        array[x] = left[i];
        i++;
      }
    }
    return array;
  }

  public static String screenshotString() {
    String screenshots = "";
    for(int i = 1; i <= 40; i ++) {
      screenshots += "![Code challenge 27, step " + i + "](../../../resources/cc-27-" + i + ".png)\n\n";
    }
    return screenshots;
  }

}
