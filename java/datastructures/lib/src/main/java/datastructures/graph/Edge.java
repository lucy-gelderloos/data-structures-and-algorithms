package datastructures.graph;

public class Edge<T extends Comparable<? super T>> implements Comparable<Node<T>> {
  private Node<T> destination;
  private int weight;

  public Edge(Node<T> destination) {
    this(destination,0);
  }

  public Edge(Node<T> destination, int weight) {
    this.destination = destination;
    this.weight = weight;
  }

  @Override
  public int compareTo(Node<T> o) {
    throw new UnsupportedOperationException("Edge does not implement CompareTo()");
  }

  public Node<T> getDestination() {
    return destination;
  }

  public void setDestination(Node<T> destination) {
    this.destination = destination;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
