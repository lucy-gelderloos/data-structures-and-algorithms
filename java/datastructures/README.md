# Data Structures

## Implementation Notes

## Code Challenges

### Challenge 05 - Linked List Implementation

Create a Node class to hold a value and a pointer to another node, and a LinkedList class that creates a list of linked nodes.

Location: `src/main/java/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/datastructures/linkedlist/LinkeListTest.java`

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

Location: `src/main/java/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/datastructures/linkedlist/LinkeListTest.java`

#### LinkedList.java

- Methods
  - *append(int value)* creates a new node whose value is the provided integer and inserts it at the end of the list. Efficiency: O(n)
  - *insertBefore(int value, int targetValue)* creates a new node whose value is the provided integer and inserts it before the first node whose value is the provided target value. Throws an exception if the list is empty or if the target value is not in the list. Efficiency: O(n)
  - *insertAfter(int value, int targetValue)* creates a new node whose value is the provided integer and inserts it after the first node whose value is the provided target value. Throws an exception if the list is empty or if the target value is not in the list. Efficiency: O(n)

#### Testing

[//]: # (TODO: describe tests)

### Challenge 07

In the LinkedList class, create a method called kthFromEnd that returns the value that is k nodes from the end of a linked list.

Location: `src/main/java/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/datastructures/linkedlist/LinkeListTest.java`

#### LinkedList.java

- Methods
  - *kthFromEnd(int k)* uses a while loop to add a `previous` property to each node, pointing at the previous node. When the last node is reached, starts a for loop that runs for `k` iterations while moving back through the list using the new `previous` property on each node. Returns the value that is `k` nodes from the end. Throws an exception if the provided k value is larger than the length of the list. Efficiency: O(n).
  - To do: refactor to account for if nodes already have a previous property.

#### Testing

[//]: # (TODO: describe tests)

### Challenge 08

In the LinkedList class, create a method that zips two linked lists together and returns the lists' alternating values in another linked list.

*Stretch goal:* create a method that zips two sorted lists together and returns a sorted list.

Location: `src/main/java/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/datastructures/linkedlist/LinkeListTest.java`

#### LinkedList.java

- Methods
  - *zipLists(LinkedList list1, LinkedList list2)* takes two linked lists and alternates inserting the values from each list into a third list. If one list is shorter than the other, it alternates values until the shorter list is null, then inserts the values from the longer list in order. If one list is null, the output list will have the same contents as the non-null input list. Throws an exception if both lists are null. Efficiency: O(n^2) because calls *append* to add the value; refactor to improve efficiency.
  - *zipSortedLists(LinkedList list1, LinkedList list2)* takes in two sorted lists. It checks the head value of each list, inserts the lower value into the output list, and advances to the next node of that list. It continues comparing the nodes from each list, inserting the lower of the two values, and advancing through the lists until there are no values left in one or both lists. If one list has values left over, they are inserted in order. Duplicate values will be duplicated (i.e., if each list has a node whose value is 5, the output list will have two consecutive nodes whose value is 5. Throws an exception if both lists are null.  Efficiency: O(n^2) because calls *append* to add the value; refactor to improve efficiency.
  - To do: refactor to reduce size (do not call *append*)

#### Testing

[//]: # (TODO: describe tests)

### Challenge 10

Using a Linked List as the underlying data storage mechanism, implement both a Stack and a Queue.

Location: `src/main/java/datastructures/linkedlist/Stack.java`; `src/main/java/datastructures/linkedlist/Queue.java`

Tests: `src/test/java/datastructures/linkedlist/StackTest.java`; `src/test/java/datastructures/linkedlist/QueueTest.java`

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

Location: `src/main/java/datastructures/linkedlist/PseudoQueue.java`

Tests: `src/test/java/datastructures/linkedlist/PseudoQueueTest.java`

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

Location: `src/main/java/datastructures/linkedlist/AnimalShelter.java`

Tests: `src/test/java/datastructures/linkedlist/AnimalShelter.java`

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

### Challenge 13

Create a method called validate brackets, which takes in a string and returns true if all brackets in the string are balanced (i.e., all opening brackets have a matching closing bracket and brackets are not overlapping).

Location: `src/main/java/datastructures/linkedlist/LinkedList.java`

Tests: `src/test/java/datastructures/linkedlist/LinkedList.java`

#### Whiteboard

![Whiteboard part 1](./src/main/java/resources/challenge-13-whiteboard-01.png)
![Whiteboard part 2](./src/main/java/resources/challenge-13-whiteboard-02.png)
![Whiteboard part 3](./src/main/java/resources/challenge-13-whiteboard-03.png)

#### LinkedList.java

- Method
  - *validateBrackets(String inputString)*
    1. Throw an exception if the string is empty.
    2. Create a holding stack, an arrayList of opening brackets, an arrayList of closing brackets, and a bracket counter. Each closing bracket should be at the same index in its arrayList as the matching opening bracket is in its arrayList. The bracket counter starts at 0.
    3. Loop through the provided string character by character.
    4. If the current character is an opening bracket, add it to the top of the holding stack and move to the next character. Increment the bracket counter.
    5. If the current character is a closing bracket, increment the bracket counter and check if the top value of the holding stack is the matching opening bracket. If yes, pop that value off the holding stack. If no (including if the holding stack is empty), return false.
    6. After the for loop has iterated through the whole string, if the bracket counter is still 0, throw an exception with message "There are no brackets in the string." If there are still values in the holding stack (i.e., not every opening bracket had a matching closing bracket), return false. Otherwise, return true.
  - Time Efficiency: O(n)
  - Space Efficiency: O(n)

#### Testing

- *testValidateBrackets* provides several strings and confirms they return true or false as expected; also confirms that empty strings and strings with no brackets return appropriate exceptions.

### Challenge 15

Implement a binary tree and a binary search tree.

Location: `src/main/java/datastructures/trees/Node.java`; `src/main/java/datastructures/trees/BinaryTree.java`; `src/main/java/datastructures/trees/BinarySearchTree.java`;

Tests: `src/test/java/datastructures/trees/TreesTest.java`

#### Node.java

- Properties
  - *T* value
  - *Node<T>* left
  - *Node<T>* right
- Constructors
  - *Node()* creates a new node whose value is null
  - *Node(T value)* creates a new node whose value is the provided value

#### BinaryTree.java

- Properties
  - *Node<T>* root
- Constructors
  - *BinaryTree()* creates a new binary tree whose root is null
  - *BinaryTree(Node<T> root)* creates a new binary tree whose root is the provided node
- Methods
  - *getValuesPreOrder()* creates an empty ArrayList to hold the values generated while traversing the tree, then calls *preOrder*, passing in the list and the tree's root node.
  - *preOrder(Node<T> root, ArrayList<T> values)* adds the value of the root node to the list of values, then checks if the root has a left child node. If yes, it calls itself on the root's left node and repeats the process; if no, it checks if the node has a right child node and if yes, calls itself on the root's right node. If both child nodes are empty, the function returns, until every node has been visited and its value has been recorded.
  - *getValuesInOrder()* creates an empty ArrayList to hold the values generated while traversing the tree, then calls *inOrder*, passing in the list and the tree's root node.
  - *inOrder(Node<T> root, ArrayList<T> values)* starts by checking for a left child node and proceeding down the tree until it finds a node with no left child. It adds the value of that node to the list of values, then checks if the node has a right child node. If yes, it checks that node for a left child, continuing the pattern until every node has been visited and its value has been recorded.
  - *getValuesPostOrder()* creates an empty ArrayList to hold the values generated while traversing the tree, then calls *postOrder*, passing in the list and the tree's root node.
  - *postOrder(Node<T> root, ArrayList<T> values)* starts by checking for a left child node and proceeding down the tree until it finds a node with no left child. It then checks if the node has a right child node; if yes, it moves to that child node and continues the process until it finds a node with no children. It adds the value of that node to the list of values, then continues the pattern until every node has been visited and its value has been recorded.

#### BinarySearchTree.java

- Extends BinaryTree
- Properties
  - inherits root from Binary Tree
- Constructors
  - *BinarySearchTree()* inherited from BinaryTree (creates a new tree whose root is null)
  - *BinaryTree(Node<Integer> root)* creates a new binary search tree whose root is the provided node (the node's value must be an Integer)
- Methods
  - *add(Integer value)* creates a new node whose value is the provided Integer. If the root of the tree is null, sets the new node as the root; otherwise, calls *addNode* and passes in the root and the new node.
  - *addNode(Node<Integer> root, Node<Integer> newNode)* checks whether the provided value is greater than or less than the value of the root node. (If neither - i.e., they are equal - the method returns.) If the value of the root is greater than the value of the new node, it then checks if the root's left child node is null; if yes, it sets the new node as the root's left child node, and if no, it calls itself on the left child node. The pattern repeats until the new node has been added to the tree such that it is greater than every node to its left and less than every node to its right.
  - *contains(Integer value)* returns true if the provided Integer is the value of one of the nodes in the tree. It checks by looking at each node and determining whether its value is equal to, greater than, or less than the provided Integer. If the values are equal, it returns true. It returns false if: the current node has no children; the value of the current node is greater than the Integer and the current node has no left children; or the value of the current node is less than the Integer and the current node has no right children. Otherwise, it continues down the tree, choosing left or right child node depending on whether the value of the current node is greater or less than the integer.

#### Testing

- *testCreateTree* creates a BinaryTree with a null root, a BinaryTree with a single node, a BinarySearchTree with a null root, and a BinarySearchTree with a single node, then tests to confirm the root values are correct/null, as appropriate.
- *testPreOrderTraversal*, *testInOrderTraversal*, and *testPostOrderTraversal*  call *getValuesPreOrder*, *getValuesInOrder*, *getValuesPostOrder*, respectively, and confirm that each method returns the expected values in the expected order.
- *testAdd* creates three binary search trees with the same values provided in a different order, then traverses each tree to confirm that the values are all present in the expected position.
- *testContains* creates a binary search tree, then confirms that calling contains() on that tree will return true if the provided value is in the tree, and false if it is not.
