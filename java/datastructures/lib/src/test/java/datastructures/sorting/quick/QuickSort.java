package datastructures.sorting.quick;

public class QuickSort {

  public static int[] getQuickSort(int[] array) {
    int left = 0;
    int right = array.length - 1;
    quickSort(array, left, right);
    return array;
  }
  public static int[] quickSort(int[] array, int left, int right) {
    if(left < right) {
      int position = partition(array, left, right);
      quickSort(array, left, position - 1);
      quickSort(array, position + 1, right);
    }
    return array;
  }

  public static int partition(int[] array, int left, int right) {
    int pivot = array[right];
    int low = left - 1;
    for(int i = left; i < right; i++) {
      if(array[i] <= pivot) {
        low++;
        swap(array, i, low);
      }
    }
    swap(array, right, low + 1);
    return low + 1;
  }

  public static void swap(int[] array, int i, int low) {
    int temp = array[i];
    array[i] = array[low];
    array[low] = temp;
  }

  public static String makeImgLinks() {
    String imgLinks = "";
    for(int i = 1; i <= 20; i++) {
      imgLinks += "![Code challenge 28, step " + i + "](../../../resources/cc-28-" + i + ".png\n\n";
    }
    return imgLinks;
  }

}
