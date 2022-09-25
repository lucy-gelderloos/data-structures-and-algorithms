package datastructures.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

  @Test
  public void testCreateHashMap() {
    HashMap<Integer, String> testHashMap = new HashMap<>(5);

    assertNull(testHashMap.get(3));
    assertNull(testHashMap.getKeys());

    testHashMap.set(3,"Value3");
    testHashMap.set(7,"Value7");
    testHashMap.set(56,"Value56");
    testHashMap.set(-6,"Value-6");

    assertTrue(testHashMap.has(3));
    assertTrue(testHashMap.has(7));
    assertTrue(testHashMap.has(56));
    assertTrue(testHashMap.has(-6));

    assertEquals("Value3",testHashMap.get(3));
    assertEquals("Value-6",testHashMap.get(-6));
    assertNotNull(testHashMap.getKeys().contains(56));
    assertNotNull(testHashMap.getKeys().contains(-6));

    testHashMap.set(3,"NewValue3");

    assertEquals("NewValue3",testHashMap.get(3));
  }
}
