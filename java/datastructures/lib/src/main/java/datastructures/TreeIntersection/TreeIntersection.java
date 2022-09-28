package datastructures.TreeIntersection;

import datastructures.hashmap.HashMap;
import datastructures.trees.BinaryTree;

import java.util.ArrayList;

public class TreeIntersection {

  public static ArrayList<Integer> treeIntersection(BinaryTree<Integer> treeOne, BinaryTree<Integer> treeTwo) throws Exception {
    if(treeOne.getRoot() == null && treeTwo.getRoot() == null) {
      throw new Exception("Both trees are empty.");
    }
    else {
      ArrayList<Integer> returnArray = new ArrayList<>();
      if (treeOne.getRoot() != null && treeTwo.getRoot() != null) {
        ArrayList<Integer> treeOneValues = treeOne.getValuesPreOrder();
        ArrayList<Integer> treeTwoValues = treeTwo.getValuesPreOrder();
        HashMap<Integer, Integer> treeValues = new HashMap<>(treeOneValues.size());
        for (Integer value :
          treeOneValues) {
          treeValues.set(value, value);
        }
        for (Integer value :
          treeTwoValues) {
          if (treeValues.has(value)) {
            returnArray.add(value);
          }
        }
      }
      return returnArray;
    }
  }
}
