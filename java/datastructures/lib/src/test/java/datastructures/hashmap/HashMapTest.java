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

  @Test
  public void testRepeatedWord() throws Exception {
    String noRepeats = "This is a test string with no repeated words.";
    String possessiveCaps = "This String's repeated word should be string.";
    String apostrophesEverywhere = "Oh, perhaps you hav'n't got any, he said quickly. No matter though, I know many chaps that hav'n't got any,—good luck to 'em; and they are all the better off for it. A soul's a sort of a fifth wheel to a wagon.";
    String longString = "An eagle flew thrice round Tarquin's head, removing his cap to replace it, and thereupon Tanaquil, his wife, declared that Tarquin would be king of Rome. But only by the replacing of the cap was that omen accounted good. Ahab's hat was never restored; the wild hawk flew on and on with it; far in advance of the prow: and at last disappeared; while from the point of that disappearance, a minute black spot was dimly discerned, falling from that vast height into the sea.";


    assertEquals("There are no repeated words in the string.",HashMap.repeatedWord(noRepeats));
    assertEquals("string",HashMap.repeatedWord(possessiveCaps));
    assertEquals("hav'n't",HashMap.repeatedWord(apostrophesEverywhere));
    assertEquals("his",HashMap.repeatedWord(longString));

    Exception exception = assertThrows(Exception.class, () -> HashMap.repeatedWord(""));
    assertEquals("The string is empty.", exception.getMessage());
  }

  @Test
  public void testLeftJoin() {
    HashMap<String, String> testLeftMap = new HashMap<>(5);
    testLeftMap.set("diligent","employed");
    testLeftMap.set("fond","enamored");
    testLeftMap.set("guide","usher");
    testLeftMap.set("outfit","garb");
    testLeftMap.set("wrath","anger");

    HashMap<String, String> testRightMapOverlap = new HashMap<>(5);
    testRightMapOverlap.set("diligent","idle");
    testRightMapOverlap.set("fond","averse");
    testRightMapOverlap.set("guide","follow");
    testRightMapOverlap.set("flow","jam");
    testRightMapOverlap.set("wrath","delight");

    HashMap<String, String> testRightMapNoOverlap = new HashMap<>(1);
    testRightMapNoOverlap.set("flow","jam");

    assertEquals("[[diligent, employed, idle], [wrath, anger, delight], [guide, usher, follow], [fond, enamored, averse], [outfit, garb, null]]",HashMap.leftJoin(testLeftMap,testRightMapOverlap).toString());

    assertEquals("[[diligent, employed, null], [wrath, anger, null], [guide, usher, null], [fond, enamored, null], [outfit, garb, null]]",HashMap.leftJoin(testLeftMap,testRightMapNoOverlap).toString());


  }
}
