package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest
{
  @Test void testCreateQueue() {
    // does creating a new Queue result in a queue with front and rear set to null?
    Queue testQueue = new Queue();
    assertNull(testQueue.getFront());
    assertNull(testQueue.getRear());
  }

  @Test void testEnqueue() {

    Queue testQueue = new Queue();

    // after calling enqueue on an empty queue, is the provided value the value of the new front/rear node?
    testQueue.enqueue(1);
    assertEquals(1,testQueue.getFront().getData());
    assertEquals(1,testQueue.getRear().getData());

    // after enqueueing more values, are the values of the front and rear nodes still correct?
    testQueue.enqueue(2);
    testQueue.enqueue(3);
    assertEquals(1,testQueue.getFront().getData());
    assertEquals(3,testQueue.getRear().getData());
  }

  @Test void testDequeue() throws Exception {
    Queue testQueue = new Queue();

    // does it throw an exception if the queue is empty?
    Exception exception = assertThrows(Exception.class, () -> testQueue.dequeue());
    assertEquals("Cannot dequeue. The Queue is empty.", exception.getMessage());

    testQueue.enqueue(1);
    testQueue.enqueue(2);
    testQueue.enqueue(3);

    // after calling dequeue once, are the front and rear values correct?
    testQueue.dequeue();
    assertEquals(2,testQueue.getFront().getData());
    assertEquals(3,testQueue.getRear().getData());

    // can the list be depopulated by calling dequeue multiple times?
    testQueue.dequeue();
    testQueue.dequeue();
    assertNull(testQueue.getFront());
    assertNull(testQueue.getRear());
  }

  @Test void testPeek() throws Exception {
    Queue testQueue = new Queue();

    // does it throw an exception if the queue is empty?
    Exception exception = assertThrows(Exception.class, () -> testQueue.peek());
    assertEquals("Cannot peek. The Queue is empty.", exception.getMessage());

    testQueue.enqueue(1);
    // after one value is added, does peek show that value?
    assertEquals(1,testQueue.peek());

    testQueue.enqueue(2);
    testQueue.enqueue(3);
    // after multiple values are added, does peek show the correct value?
    assertEquals(1,testQueue.peek());

    testQueue.dequeue();
    testQueue.dequeue();
    // after multiple nodes are dequeued, does peek show the correct value?
    assertEquals(3,testQueue.peek());
  }

  @Test void testIsEmpty() {
    Queue testQueue = new Queue();

    // does it return true if called on an empty queue?
    assertTrue(testQueue.isEmpty());

    // does it return false if called on a queue that is not empty?
    testQueue.enqueue(1);
    testQueue.enqueue(2);
    assertFalse(testQueue.isEmpty());
  }
}
