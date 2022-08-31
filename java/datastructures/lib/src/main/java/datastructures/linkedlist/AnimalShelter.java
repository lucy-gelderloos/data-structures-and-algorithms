package datastructures.linkedlist;

public class AnimalShelter {
  private Node<Animal> front;
  private Node<Animal> rear;
  private int catCounter;
  private int dogCounter;

  public AnimalShelter() {
    this.front = null;
    this.rear = null;
//    this.catCounter = 0;
//    this.dogCounter = 0;
  }

  public void enqueue(String name,String type) throws Exception {
    if(!type.equals("dog") && !type.equals("cat")) {
      throw new Exception("Please add a dog or cat");
    } else {
      Animal newAnimal = new Animal(name, type);
      Node<Animal> newAnimalNode = new Node<>(newAnimal);
      newAnimalNode.setNext(null);

      // TODO: implement counters?

      if(this.front == null) {
        this.front = newAnimalNode;
        this.rear = newAnimalNode;
      } else {
        this.rear.setNext(newAnimalNode);
        this.rear = newAnimalNode;
      }
    }
  }

  public Animal dequeue(String type) throws Exception {
    if (this.front == null) {
      throw new Exception("There are no animals in the shelter right now. Hooray!");
    } else if (!type.equals("dog") && !type.equals("cat")) {
      return null;
    } else {
      Node<Animal> pointerNode = this.front;
      Node<Animal> pointerPrevNode = this.front;
      Animal returnData = null;
      while (pointerNode != null) {
        if (!pointerNode.getData().getType().equals(type)) {
          pointerPrevNode = pointerNode;
          if(pointerNode.getNext() != null) {
            pointerNode = pointerNode.getNext();
            } else {
            pointerNode = null;
            throw new Exception("'Sorry, we don't have any ' + ${type} + 's at the shelter right now.'");
          }
        } else {
          returnData = pointerNode.getData();
          if (pointerNode.getNext() != null) {
            pointerPrevNode.setNext(pointerNode.getNext());
          } else {
            pointerPrevNode.setNext(null);
          }
          pointerNode.setNext(null);
          pointerNode = null;
        }
      }
      return returnData;
    }
  }

  public Node<Animal> getFront() {
    return front;
  }

  public void setFront(Node<Animal> front) {
    this.front = front;
  }

  public Node<Animal> getRear() {
    return rear;
  }

  public void setRear(Node<Animal> rear) {
    this.rear = rear;
  }

  public int getCatCounter() {
    return catCounter;
  }

  public void setCatCounter(int catCounter) {
    this.catCounter = catCounter;
  }

  public int getDogCounter() {
    return dogCounter;
  }

  public void setDogCounter(int dogCounter) {
    this.dogCounter = dogCounter;
  }
}
