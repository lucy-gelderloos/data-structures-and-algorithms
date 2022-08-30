package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PseudoQueueTest
{
  @Test void testCreatePseudoQueue() {
    // does creating a new Queue result in a queue with front and rear set to null?
    PseudoQueue testPseudoQueue = new PseudoQueue<>();
    assertNull(testPseudoQueue.getForwardStack().getTop());
    assertNull(testPseudoQueue.getBackwardStack().getTop());
  }

  @Test void testEnqueue() {
    PseudoQueue testPseudoQueue = new PseudoQueue<>();

    testPseudoQueue.enqueue(1);
    // after adding one value, are the top values of both stacks the same?
    assertEquals(1,testPseudoQueue.getForwardStack().getTop().getData());
    assertEquals(1,testPseudoQueue.getBackwardStack().getTop().getData());


    testPseudoQueue.enqueue(2);
    testPseudoQueue.enqueue(3);
    // after enqueueing more values, are the top values of each stack updated appropriately?
    assertEquals(1,testPseudoQueue.getForwardStack().getTop().getData());
    assertEquals(3,testPseudoQueue.getBackwardStack().getTop().getData());
  }

  @Test void testDequeue() throws Exception {
    PseudoQueue testPseudoQueue = new PseudoQueue<>();

    // does it throw an exception if the pseudoqueue is empty?
    Exception exception = assertThrows(Exception.class, () -> testPseudoQueue.dequeue());
    assertEquals("Cannot dequeue. The pseudoqueue is empty.", exception.getMessage());

    testPseudoQueue.enqueue(1);
    testPseudoQueue.enqueue(2);
    testPseudoQueue.enqueue(3);
    testPseudoQueue.enqueue(4);
    testPseudoQueue.enqueue(5);

    // does dequeueing return the right value?
    assertEquals(1,testPseudoQueue.dequeue());

    // after dequeueing once, is the top value of each list correct?
    assertEquals(2,testPseudoQueue.getForwardStack().getTop().getData());
    assertEquals(5,testPseudoQueue.getBackwardStack().getTop().getData());
    assertEquals(2,testPseudoQueue.dequeue());
    assertEquals(3,testPseudoQueue.dequeue());
    assertEquals(4,testPseudoQueue.dequeue());

    // after dequeueing multiple times, is the top value of each list correct?
    assertEquals(5,testPseudoQueue.getForwardStack().getTop().getData());
    assertEquals(5,testPseudoQueue.getBackwardStack().getTop().getData());
  }

}
