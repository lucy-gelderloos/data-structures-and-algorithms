package datastructures.hashmap;

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

}
