package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalShelterTest
{
  @Test void testCreate() {
    AnimalShelter sutShelter = new AnimalShelter();
    // does the constructor create a new AnimalShelter with null front and rear?
    assertNull(sutShelter.getFront());
    assertNull(sutShelter.getRear());
  }

  @Test void testEnqueue() throws Exception {
    AnimalShelter sutShelter = new AnimalShelter();
    sutShelter.enqueue("Kate","dog");
    sutShelter.enqueue("Annie","dog");
    sutShelter.enqueue("Kudo","cat");
    sutShelter.enqueue("Merry","cat");
    sutShelter.enqueue("Pippin","cat");

    // is the first animal enqueued at the head of the queue?
    assertEquals("Kate",sutShelter.getFront().getData().getName());

    // is the last animal enqueued at the rear of the queue?
    assertEquals("Pippin",sutShelter.getFront().getData().getName());

    // if someone tries to add an animal whose type is not dog or cat, does it throw an exception?
    Exception exception = assertThrows(Exception.class, () -> sutShelter.enqueue("Elizabeth","Lizard"));
    assertEquals("Please add a dog or a cat.", exception.getMessage());
  }

  @Test void testDequeue() throws Exception {
    AnimalShelter sutShelter = new AnimalShelter();
    sutShelter.enqueue("Kate","dog");
    sutShelter.enqueue("Annie","dog");
    sutShelter.enqueue("Kudo","cat");
    sutShelter.enqueue("Merry","cat");
    sutShelter.enqueue("Pippin","cat");

    // if we try to dequeue a cat, does it return the right animal?
    Animal dequeuedCat = sutShelter.dequeue("cat");
    assertEquals("Kudo",dequeuedCat.getName());

    // if we try to dequeue a dog, does it return the right animal?
    Animal dequeuedDog = sutShelter.dequeue("dog");
    assertEquals("Kate",dequeuedDog.getName());

    // TODO: test for exceptions
  }

}
