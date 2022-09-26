package datastructures.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

  @Test
  public void testCreateHashMap() {
    HashMap<Integer, String> testHashMap = new HashMap<>(5);

    assertNull(testHashMap.get(3));
    assertNull(testHashMap.getKeys());
  }

  @Test
  public void testAddToHashMap() {
    HashMap<Integer, String> testHashMap = new HashMap<>(5);
    testHashMap.set(3,"Value3");
    testHashMap.set(7,"Value7");
    testHashMap.set(56,"Value56");
    testHashMap.set(-6,"Value-6");

    assertTrue(testHashMap.has(3));
    assertTrue(testHashMap.has(7));
    assertTrue(testHashMap.has(56));
    assertTrue(testHashMap.has(-6));
  }

  @Test
  public void testGet() {
    HashMap<Integer, String> testHashMap = new HashMap<>(5);
    testHashMap.set(3,"Value3");
    testHashMap.set(7,"Value7");
    testHashMap.set(56,"Value56");
    testHashMap.set(-6,"Value-6");


    assertEquals("Value3",testHashMap.get(3));
    assertEquals("Value-6",testHashMap.get(-6));
    assertNull(testHashMap.get(10));
  }

  @Test
  public void testGetKeys() {
    HashMap<Integer, String> testHashMap = new HashMap<>(5);
    testHashMap.set(3,"Value3");
    testHashMap.set(7,"Value7");
    testHashMap.set(56,"Value56");
    testHashMap.set(-6,"Value-6");

    assertTrue(testHashMap.getKeys().contains(56));
    assertTrue(testHashMap.getKeys().contains(-6));
  }

  @Test
  public void testCollision() {
    HashMap<Integer, String> testHashMap = new HashMap<>(1);
    testHashMap.set(3,"Value3");
    testHashMap.set(7,"Value7");
    testHashMap.set(56,"Value56");
    testHashMap.set(-6,"Value-6");

    assertEquals(testHashMap.hash(3), testHashMap.hash(7));
    assertTrue(testHashMap.getKeys().contains(56));
    assertEquals("Value-6",testHashMap.get(-6));


    testHashMap.set(-6,"NewValue-6");

    assertEquals("NewValue-6",testHashMap.get(-6));
  }

}
