# Data Structures

## Implementation Notes

## Code Challenges

### Challenge 05 - Linked List Implementation

Create a Node class to hold a value and a pointer to another node, and a LinkedList class that creates a list of linked nodes.

Location: `src/main/java/codechallenges/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/codechallenges/datastructures/linkedlist/LinkeListTest.java`

#### LinkedList.java

- Properties
  - Node `head`
- Constructor
  - *LinkedList* creates a new linked list with a head node whose value is null
- Methods
  - *insert(int value)* creates a new node whose value is the provided integer and inserts it at the beginning of the list. If the list is empty, becomes the new head node. Efficiency: O(1)
  - *includes(int value)* returns `true` if the value of any node in the list matches the provided integer and `false` if not. Efficiency: O(n)
  - *toString()* iterates through the list and returns a string containing every value and ending in "NULL", formatted as follows: "{<value of head node>} -> {<value of second node>} -> {<value of third node>} -> ... -> {<value of tail node>} -> NULL". If the list is empty, returns "NULL". Efficiency: O(n)

#### Node.java

- Properties
  - int `value`
  - Node `next`
- Constructor
  - Creates a new node whose value is the provided integer. If no integer is provided, creates a node whose value is 0.

#### Testing

[//]: # (TODO: describe tests)

### Challenge 06 - Linked List Insertions

In the LinkedList class, create a method to append a node with the provided value to the end of the list and to insert nodes with the provided value either before or after a target value.

Location: `src/main/java/codechallenges/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/codechallenges/datastructures/linkedlist/LinkeListTest.java`

#### LinkedList.java

- Methods
  - *append(int value)* creates a new node whose value is the provided integer and inserts it at the end of the list. Efficiency: O(n)
  - *insertBefore(int value, int targetValue)* creates a new node whose value is the provided integer and inserts it before the first node whose value is the provided target value. Throws an exception if the list is empty or if the target value is not in the list. Efficiency: O(n)
  - *insertAfter(int value, int targetValue)* creates a new node whose value is the provided integer and inserts it after the first node whose value is the provided target value. Throws an exception if the list is empty or if the target value is not in the list. Efficiency: O(n)

#### Testing

[//]: # (TODO: describe tests)

### Challenge 07

In the LinkedList class, create a method called kthFromEnd that returns the value that is k nodes from the end of a linked list.

Location: `src/main/java/codechallenges/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/codechallenges/datastructures/linkedlist/LinkeListTest.java`

#### LinkedList.java

- Methods
  - *kthFromEnd(int k)* uses a while loop to add a `previous` property to each node, pointing at the previous node. When the last node is reached, starts a for loop that runs for `k` iterations while moving back through the list using the new `previous` property on each node. Returns the value that is `k` nodes from the end. Throws an exception if the provided k value is larger than the length of the list. Efficiency: O(n).
  - To do: refactor to account for if nodes already have a previous property.

#### Testing

[//]: # (TODO: describe tests)

### Challenge 08

In the LinkedList class, create a method that zips two linked lists together and returns the lists' alternating values in another linked list.

*Stretch goal:* create a method that zips two sorted lists together and returns a sorted list.

Location: `src/main/java/codechallenges/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/codechallenges/datastructures/linkedlist/LinkeListTest.java`

#### LinkedList.java

- Methods
  - *zipLists(LinkedList list1, LinkedList list2)* takes two linked lists and alternates inserting the values from each list into a third list. If one list is shorter than the other, it alternates values until the shorter list is null, then inserts the values from the longer list in order. If one list is null, the output list will have the same contents as the non-null input list. Throws an exception if both lists are null. Efficiency: O(n^2) because calls *append* to add the value; refactor to improve efficiency.
  - *zipSortedLists(LinkedList list1, LinkedList list2)* takes in two sorted lists. It checks the head value of each list, inserts the lower value into the output list, and advances to the next node of that list. It continues comparing the nodes from each list, inserting the lower of the two values, and advancing through the lists until there are no values left in one or both lists. If one list has values left over, they are inserted in order. Duplicate values will be duplicated (i.e., if each list has a node whose value is 5, the output list will have two consecutive nodes whose value is 5. Throws an exception if both lists are null.  Efficiency: O(n^2) because calls *append* to add the value; refactor to improve efficiency.
  - To do: refactor to reduce size (do not call *append*)

#### Testing

[//]: # (TODO: describe tests)

### Challenge 10

Using a Linked List as the underlying data storage mechanism, implement both a Stack and a Queue.

Location: `src/main/java/codechallenges/datastructures/linkedlist/Stack.java`; `src/main/java/codechallenges/datastructures/linkedlist/Queue.java`

Tests: `src/test/java/codechallenges/datastructures/linkedlist/StackTest.java`; `src/test/java/codechallenges/datastructures/linkedlist/QueueTest.java`

#### Stack.java

- Properties:
  - Node `top`
- Constructor
  - *Stack* creates a new stack with a null top
- Methods
  - *push(int value)* creates a node whose value is the provided value and inserts it at the top of the stack. Efficiency: O(1)
  - *pop()* removes the top node of the stack and returns its value. Throws an exception if the stack is empty. Efficiency: O(1)
  - *peek()* returns the value of the top node of the stack without modifying the stack. Throws an exception if the stack is empty. Efficiency: O(1)
  - *isEmpty()* returns `true` if the stack is empty and `false` if it is not. Efficiency: O(1)

##### Testing

- *testCreate* tests whether the Stack constructor creates a stack whose top node is null.
- *testPush* tests whether values can be successfully pushed onto the top of the stack.
- *testPop* tests whether pop() throws an exception if the stack is empty and whether it returns the correct value and removes the top node if the stack is not empty.
- *testPeek* tests whether peek() throws an exception if the stack is empty and whether it returns the correct value if the stack is not empty.
- *testIsEmpty* tests whether isEmpty() returns true for an empty stack and false for a non-empty one.

#### Queue.java

- Properties:
  - Node `front`
  - Node `rear`
- Constructor
  - *Queue* creates a new queue with a null front and rear
- Methods
  - *enqueue(int value)* creates a node whose value is the provided value and inserts it at the rear of the queue. Efficiency: O(1)
  - *dequeue()* removes the front node of the queue and returns its value. Throws an exception if the queue is empty. Efficiency: O(1)
  - *peek()* returns the value of the front node of the queue without modifying the queue. Throws an exception if the queue is empty. Efficiency: O(1)
  - *isEmpty()* returns `true` if the queue is empty and `false` if it is not. Efficiency: O(1)

##### Testing

- *testCreate* tests whether the Queue constructor creates a queue whose front and rear nodes are null.
- *testEnqueue* tests whether values can be successfully enqueued at the rear of the queue.
- *testDequeue* tests whether dequeue() throws an exception if the queue is empty and whether it returns the correct value and removes the front node if the queue is not empty.
- *testPeek* tests whether peek() throws an exception if the queue is empty and whether it returns the correct value if the queue is not empty.
- *testIsEmpty* tests whether isEmpty() returns true for an empty queue and false for a non-empty one.

### Challenge 11

Create a PseudoQueue class that behaves like a queue externally, but internally uses two stacks to manage nodes.

Location: `src/main/java/codechallenges/datastructures/linkedlist/PseudoQueue.java`

Tests: `src/test/java/codechallenges/datastructures/linkedlist/PseudoQueueTest.java`

#### PseudoQueue.java

- Properties
  - Stack<T> `forwardStack`
  - Stack<T> `backwardStack`
- Constructor
  - *PseudoQueue* creates a new pseudoqueue with forwardStack and backwardStack properties; each stack's top node is null.
- Methods
  - *enqueue(T value)* creates a new node whose value is the provided value and inserts it at the top of the backwardStack and the bottom of the forwardStack. Efficiency: O(n)
  - *dequeue(T value)* removes the node at the "front" of the pseudoqueue (i.e., the node at the top of the forwardStack and the bottom of the backwardStack) and returns its value. Throws an exception if the pseudoqueue is empty. Efficiency: O(n)

#### Testing

- *testCreatePseudoqueue* confirms that a new pseudoqueue will have a forwardStack and backwardStack property, and that the top node of each stack is null.
- *testEnqueue* confirms that the provided value is added to the correct position in both stacks.
- *testDequeue* confirms that calling dequeue on a pseudoqueue results in an exception if the pseudoqueue is empty, and removes the correct node/returns the correct value if not.

### Challenge 12

Create an AnimalShelter class that holds dog and cat objects. The class should be a Queue, utilizing first in/first out principles, but users are able to specify whether they want a dog or a cat.

Location: `src/main/java/codechallenges/datastructures/linkedlist/AnimalShelter.java`

Tests: `src/test/java/codechallenges/datastructures/linkedlist/AnimalShelter.java`

#### Whiteboard

![Whiteboard part 1](./src/main/java/resources/challenge-12-whiteboard-01.png)
![Whiteboard part 2](./src/main/java/resources/challenge-12-whiteboard-02.png)

#### AnimalShelter.java

- Properties
  - *Node<Animal>* front
  - *Node<Animal>* rear
- Constructor
  - *AnimalShelter* creates a new AnimalShelter with null front and rear nodes.
- Methods
  - *enqueue(String name, String type)* creates a new Animal object and sets it as the value of a new node, then inserts that node at the rear of the AnimalShelter queue. Efficiency: O(1)
  - *dequeue(String type)* starts at the front of the AnimalShelter queue and finds the first node whose Animal object's type property matches the provided type. It returns the value of that node and removes it from the queue. Efficiency: O(n)

#### Testing

- *testCreateAnimalShelter* confirms that a new AnimalShelter will have a front and rear property, both of which are null.
- *testEnqueue* confirms that the provided animal is added to the correct position in the queue.
- *testDequeue* confirms that calling dequeue on an AnimalShelter removes the correct node and returns its value.
