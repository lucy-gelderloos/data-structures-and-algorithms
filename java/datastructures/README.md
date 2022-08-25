# Data Structures

## Implementation Notes

## Code Challenges

### Challenge 05 - Linked List Implementation

Create a Node class to hold a value and a pointer to another node, and a LinkedList class that creates a list of linked nodes.

Location: `src/main/java/codechallenges/datastructures/linkedlist`

Tests: `src/test/java/codechallenges/datastructures/linkedlist`

#### LinkedList.java

- Properties
  - Node `head`
- Constructor
  - *LinkedList* creates a new linked list with a head node whose value is null
- Methods
  - *insert* creates a new node whose value is the provided integer and inserts it at the beginning of the list
  - *includes* returns `true` if the value of any node in the list matches the provided integer
  - *toString* iterates through the list and returns a string containing every value and ending in `NULL`, formatted as follows: "{<value of head node>} -> {<value of second node>} -> {<value of third node>} -> ... -> {<value of tail node>} -> NULL"

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

Location: `src/main/java/codechallenges/datastructures/linkedlist`

Tests: `src/test/java/codechallenges/datastructures/linkedlist`

#### LinkedList.java

- Methods
  - *append* creates a new node whose value is the provided integer and inserts it at the end of the list
  - *insertBefore* creates a new node whose value is the provided integer and inserts it before the first node whose value is the provided target value
  - *insertAfter* creates a new node whose value is the provided integer and inserts it after the first node whose value is the provided target value

#### Testing

[//]: # (TODO: describe tests)


### Challenge 07

In the LinkedList class, create a method called kthFromEnd that returns the value that is k nodes from the end of a linked list.

Location: `src/main/java/codechallenges/datastructures/linkedlist`

Tests: `src/test/java/codechallenges/datastructures/linkedlist`

#### LinkedList.java

- Methods
  - *kthFromEnd(int k)* returns the value of the node that is k nodes from the end of the list

#### Testing

[//]: # (TODO: describe tests)


