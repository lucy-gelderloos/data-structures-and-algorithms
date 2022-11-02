package datastructures.graph;

import java.util.*;
import datastructures.linkedlist.Queue;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>> {

  public HashMap<Node<T>, LinkedList<Edge<T>>> adjacencyList;
  private int nodeCount = 0;

  public Graph(int maxNodes) {
    adjacencyList = new HashMap<>(maxNodes);
  }

  public Node<T> addNode(T value) throws Exception {
    Node<T> newNode = new Node<>(value);
    if(adjacencyList.containsKey(newNode)) {
      throw new Exception("This value is already in the graph.");
    }
    LinkedList<Edge<T>> edgeList = new LinkedList<>();
    adjacencyList.put(newNode,edgeList);
    nodeCount++;
    return newNode;
  }

  public void addEdge(Node<T> start, Node<T> destination) throws Exception {
    addEdge(start,destination,0);
  }

  public void addEdge(Node<T> start, Node<T> destination, int weight) throws Exception {
    if(!adjacencyList.containsKey(start) || !adjacencyList.containsKey(destination)) {
      throw new Exception("Both nodes must be in the graph.");
    }
    Edge<T> newEdge = new Edge<>(destination,weight);
    LinkedList<Edge<T>> edgeList = adjacencyList.get(start);
    edgeList.add(newEdge);
    adjacencyList.put(start,edgeList);
  }

  public LinkedList<Node<T>> getNodes() {
    LinkedList<Node<T>> nodeList = new LinkedList<>();
    for(Node<T> node : adjacencyList.keySet()) {
      nodeList.add(node);
    }
    return nodeList;
  }

  public LinkedList<Edge<T>> getNeighbors(Node<T> node) {
    return adjacencyList.get(node);
  }

  public int size() {
    return nodeCount;
  }

  public static Integer businessTrip(Graph<String> routeMap, String[] itinerary) {
    int totalCost = 0;
    for(int i = 0; i < itinerary.length - 1; i++) {
      Node<String> originNode = new Node<>(itinerary[i]);
      Node<String> destinationNode = new Node<>(itinerary[i + 1]);
      LinkedList<Edge<String>> neighborsList = routeMap.getNeighbors(originNode);
      for(Edge<String> edge : neighborsList) {
        if(edge.getDestination().equals(destinationNode)) {
          totalCost += edge.getWeight();
        }
      }
    }
    if(totalCost == 0) {
      return null;
    } else {
      return totalCost;
    }
  }

  public HashSet<Node<T>> breadthFirst(Node<T> startingNode) throws Exception {
    HashSet<Node<T>> visitedList = new HashSet<>();
    Queue<Node<T>> holdingQueue = new Queue<>();
    visitedList.add(startingNode);
    holdingQueue.enqueue(startingNode);
    while(!holdingQueue.isEmpty()) {
      Node<T> thisNode = holdingQueue.dequeue();
      List<Edge<T>> edgeList = this.getNeighbors(thisNode);
      for(Edge<T> edge : edgeList) {
        if(!visitedList.contains(edge.getDestination())) {
          visitedList.add(edge.getDestination());
          holdingQueue.enqueue(edge.getDestination());
        }
      }
    }
    return visitedList;
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

  public HashMap<Node<T>, LinkedList<Edge<T>>> getAdjacencyList() {
    return adjacencyList;
  }

  public void setAdjacencyList(HashMap<Node<T>, LinkedList<Edge<T>>> adjacencyList) {
    this.adjacencyList = adjacencyList;
  }

  public int getNodeCount() {
    return nodeCount;
  }

  public void setNodeCount(int nodeCount) {
    this.nodeCount = nodeCount;
  }
}
