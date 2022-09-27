package datastructures.hashmap;

import datastructures.linkedlist.Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K, V> {
  ArrayList<LinkedList<HashMapPair<K, V>>> bucketArrayList;
  int size;

  public HashMap(int size) {
    if(size < 1) {
      throw new IllegalArgumentException("HashMap size must be greater than 1");
    }
    this.size = size;
    this.bucketArrayList = new ArrayList<>(size);

    for(int i = 0; i < this.size; i++) {
      bucketArrayList.add(i, new LinkedList<>());
    }
  }

  public void set(K key, V value) {
    int hashedKey = hash(key);
    if(this.get(key) != value && this.get(key) != null) {
      for(HashMapPair<K, V> hashMapPair :
      this.bucketArrayList.get(hashedKey)) {
        if(hashMapPair.getKey() == key) {
          hashMapPair.setValue(value);
        }
      }
    }
    else {
      HashMapPair<K, V> hashMapPair = new HashMapPair<>(key, value);
      LinkedList<HashMapPair<K,V>> bucket = this.bucketArrayList.get(hashedKey);
      bucket.add(hashMapPair);
      this.bucketArrayList.set(hashedKey,bucket);
      }
  }

  public V get(K key) {
    int hashedKey = hash(key);
    LinkedList<HashMapPair<K, V>> bucket = bucketArrayList.get(hashedKey);
    for(HashMapPair<K, V> hashMapPair :
      bucket ) {
      if(hashMapPair.getKey() == key) {
        return (V) hashMapPair.getValue();
      }
    }
    return null;
  }

  public List<K> getKeys() {
    List<K> keysList = new ArrayList<>();
    for (LinkedList<HashMapPair<K, V>> bucket :
         bucketArrayList) {
      if(!bucket.isEmpty()) {
        for (HashMapPair<K, V> hashMapPair :
          bucket) {
          keysList.add((K) hashMapPair.getKey());
        }
      }
    }
    if(keysList.isEmpty()) {
      return null;
    } else return keysList;
  }

  public boolean has(K key) {
    List<K> keysList = this.getKeys();
    if(keysList != null && keysList.contains(key)) {
      return true;
    }
    return false;
  }

  public int hash(K key){
    return Math.abs(key.hashCode()) % size;
  }

  public static String repeatedWord(String inputString) throws Exception {
    if(inputString.equals("")) {
      throw new Exception("The string is empty.");
    }
    String allowedCharactersString = "abcdefghijklmnopqrstuvwxyz'-";
    Queue<String> holdingQueue = new Queue<>();
    HashMap<String,String> holdingMap = new HashMap<>(1000);

    for(int i = 0; i < inputString.length(); i++) {
      String currentChar = "" + inputString.charAt(i);
      // if the current character is in the allowed characters string, add it to the queue
      // https://stackoverflow.com/questions/56056419/how-can-i-convert-a-char-to-charsequence
      if(allowedCharactersString.contains(currentChar.toLowerCase())) {
        holdingQueue.enqueue(currentChar.toLowerCase());
      }
      // if the current character is not in the allowed characters string
      else {
        if(!holdingQueue.isEmpty()) {
          // if the holding queue is not empty, create a temp string, then iterate through the queue to find the word to check
          String tempString = "";
          while(!holdingQueue.isEmpty()) {
            // if the next character is an apostrophe, dequeue it to a separate string
            if(holdingQueue.peek().equals("\'")) {
              String apostrophe = holdingQueue.dequeue();
              // if the character following the apostrophe is an "s", dequeue it
              if(holdingQueue.peek().equals("s")) {
                holdingQueue.dequeue();
              }
              // otherwise, add the apostrophe to the string and continue
              else tempString += apostrophe;
            }
            else tempString += holdingQueue.dequeue();
          }
          if(!holdingMap.has(tempString)) {
            holdingMap.set(tempString,tempString);
          }
          else return tempString;
        }
      }
    }
    return "There are no repeated words in the string.";
  }

}
