package datastructures.graph;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>> {

  public HashMap<Node<T>, LinkedList<Edge<T>>> adjacencyLists;
  private int nodeCount = 0;

  public Graph(int maxNodes) {
    adjacencyLists = new HashMap<>(maxNodes);
  }

  public Node<T> addNode(T value) throws Exception {
    Node<T> newNode = new Node<>(value);
    if(adjacencyLists.containsKey(newNode)) {
      throw new Exception("This value is already in the graph.");
    }
    LinkedList<Edge<T>> edgeList = new LinkedList<>();
    adjacencyLists.put(newNode,edgeList);
    nodeCount++;
    return newNode;
  }

  public void addEdge(Node<T> start, Node<T> destination) throws Exception {
    addEdge(start,destination,0);
  }

  public void addEdge(Node<T> start, Node<T> destination, int weight) throws Exception {
    if(!adjacencyLists.containsKey(start) || !adjacencyLists.containsKey(destination)) {
      throw new Exception("Both nodes must be in the graph.");
    }
    Edge<T> newEdge = new Edge<>(destination,weight);
    LinkedList<Edge<T>> edgeList = adjacencyLists.get(start);
    edgeList.add(newEdge);
    adjacencyLists.put(start,edgeList);
  }

  public LinkedList<Node<T>> getNodes() {
    LinkedList<Node<T>> nodeList = new LinkedList<>();
    for(Node<T> node : adjacencyLists.keySet()) {
      nodeList.add(node);
    }
    return nodeList;
  }

  public LinkedList<Edge<T>> getNeighbors(Node<T> node) {
    return adjacencyLists.get(node);
  }

  public int size() {
    return nodeCount;
  }

  @Override
  public int compareTo(Graph<T> o)
  {
    throw new UnsupportedOperationException("Graph does not implement compareTo()");
  }

//  @Override
//  public String toString()
//  {
//    // Good for testing
//    // WARNING: Your HashMap does not guarantee ordering!
//    // But you can basically rely on it if you add nodes to your graphs in a consistent way
//
//    return "";
//  }

  public HashMap<Node<T>, LinkedList<Edge<T>>> getAdjacencyLists() {
    return adjacencyLists;
  }

  public void setAdjacencyLists(HashMap<Node<T>, LinkedList<Edge<T>>> adjacencyLists) {
    this.adjacencyLists = adjacencyLists;
  }

  public int getNodeCount() {
    return nodeCount;
  }

  public void setNodeCount(int nodeCount) {
    this.nodeCount = nodeCount;
  }
}
