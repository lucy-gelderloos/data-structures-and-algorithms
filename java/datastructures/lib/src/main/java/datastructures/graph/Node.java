package datastructures.graph;

import java.util.Objects;

public class Node<T extends Comparable<? super T>> implements Comparable<Node<T>> {
  private T value;

  public Node(T value) {
    this.value = value;
  }

  @Override
  public int compareTo(Node<T> o) {
    throw new UnsupportedOperationException("Node does not implement compareTo()");
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Node<?> vertex = (Node<?>) o;
    return Objects.equals(value, vertex.value);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(value);
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
