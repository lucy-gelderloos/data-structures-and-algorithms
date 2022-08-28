package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest
{
  @Test void testCreateStack() {
    // does creating a new Stack result in a stack with top set to null?
    Stack testStack = new Stack();
    assertNull(testStack.getTop());
  }

  @Test void testPush() {

    Stack testStack = new Stack();

    // after pushing a value onto the stack, is that value the value of the list's top node?
    testStack.push(1);
    assertEquals(1,testStack.getTop().getValue());

    // after pushing multiple values onto the stack, is the top value correct?
    testStack.push(2);
    testStack.push(3);
    assertEquals(3,testStack.getTop().getValue());
    assertEquals(2,testStack.getTop().getNext().getValue());
  }

  @Test void testPop() throws Exception {
    Stack testStack = new Stack();
    // does it throw an exception if the stack is empty?
    Exception exception = assertThrows(Exception.class, () -> testStack.pop());
    assertEquals("Cannot pop. The Stack is empty.", exception.getMessage());

    testStack.push(1);
    testStack.push(2);
    testStack.push(3);

    // does the first pop return the stack's top value?
    int poppedVal1 = testStack.pop();
    assertEquals(3,poppedVal1);

    // does the second pop return the stack's new top value?
    int poppedVal2 = testStack.pop();
    assertEquals(2,poppedVal2);

    // after two pops, is the top value correct?
    assertEquals(1,testStack.getTop().getValue());

    testStack.pop();
    // after every value is popped off, is the stack's top node null?
    assertNull(testStack.getTop());
  }

  @Test void testPeek() throws Exception {
    Stack testStack = new Stack();

    // does it throw an exception if the stack is empty?
    Exception exception = assertThrows(Exception.class, () -> testStack.peek());
    assertEquals("Cannot peek. The Stack is empty.", exception.getMessage());

    // after multiple values are added, does peek show the correct top value?
    testStack.push(1);
    testStack.push(2);
    assertEquals(2,testStack.peek());

    // if another value is added, does the peek result change accordingly?
    testStack.push(3);
    assertEquals(3,testStack.peek());

    // if a value is popped off, does the peek result change accordingly?
    testStack.pop();
    assertEquals(2,testStack.peek());
  }

  @Test void testIsEmpty() {
    Stack sutEmpty = new Stack();

    Stack sutNotEmpty = new Stack();
    sutNotEmpty.push(1);
    sutNotEmpty.push(2);

    assertTrue(sutEmpty.isEmpty());
    assertFalse(sutNotEmpty.isEmpty());
  }
}
