package datastructures.graph;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

  @Test
  public void testCreateGraph() {
    Graph<Integer> testGraph = new Graph<>(10);

    assertEquals(0,testGraph.getNodeCount());
    assertEquals(0,testGraph.size());
    assertEquals(0,testGraph.adjacencyList.size());
  }

  @Test
  public void testAddNode() throws Exception {
    Graph<Integer> testGraph = new Graph<>(10);
    Node<Integer> testNode4 = testGraph.addNode(4);
    Node<Integer> testNode6 = testGraph.addNode(6);

    assertEquals(2,testGraph.size());
    assertEquals(0,testGraph.adjacencyList.get(testNode4).size());

    Exception exception = assertThrows(Exception.class, () -> testGraph.addNode(4));
    assertEquals("This value is already in the graph.",exception.getMessage());
  }

  @Test
  public void testAddEdge() throws Exception {
    Graph<Integer> testGraph = new Graph<>(10);
    Node<Integer> testNode2 = testGraph.addNode(2);
    Node<Integer> testNode4 = testGraph.addNode(4);
    Node<Integer> testNode6 = testGraph.addNode(6);
    Node<Integer> testNode8 = testGraph.addNode(8);
    Node<Integer> testNode5 = new Node<>(5);
    testGraph.addEdge(testNode4,testNode6);
    testGraph.addEdge(testNode2,testNode8,3);

    assertEquals(6,testGraph.adjacencyList.get(testNode4).getFirst().getDestination().getValue());
    assertEquals(3,testGraph.adjacencyList.get(testNode2).getFirst().getWeight());

    Exception exception = assertThrows(Exception.class, () -> testGraph.addEdge(testNode4,testNode5));
    assertEquals("Both nodes must be in the graph.",exception.getMessage());
  }

  @Test
  public void testGetNodes() throws Exception {
    Graph<Integer> testGraph = new Graph<>(10);
    Node<Integer> testNode2 = testGraph.addNode(2);
    Node<Integer> testNode4 = testGraph.addNode(4);
    Node<Integer> testNode6 = testGraph.addNode(6);
    Node<Integer> testNode8 = testGraph.addNode(8);

    assertEquals(4,testGraph.getNodes().size());
    assertTrue(testGraph.getNodes().contains(testNode2) && testGraph.getNodes().contains(testNode4) && testGraph.getNodes().contains(testNode6) && testGraph.getNodes().contains(testNode8));
  }

  @Test
  public void testGetNeighbors() throws Exception {
    Graph<Integer> testGraph = new Graph<>(10);
    Node<Integer> testNode2 = testGraph.addNode(2);
    Node<Integer> testNode4 = testGraph.addNode(4);
    Node<Integer> testNode6 = testGraph.addNode(6);
    Node<Integer> testNode8 = testGraph.addNode(8);
    testGraph.addEdge(testNode2,testNode6);
    testGraph.addEdge(testNode2,testNode4);
    testGraph.addEdge(testNode2,testNode8,3);

    assertEquals(3,testGraph.getNeighbors(testNode2).size());
    assertEquals(6,testGraph.getNeighbors(testNode2).get(0).getDestination().getValue());
    assertEquals(4,testGraph.getNeighbors(testNode2).get(1).getDestination().getValue());
    assertEquals(3,testGraph.getNeighbors(testNode2).get(2).getWeight());
  }

  @Test
  public void testBusinessTrip() throws Exception {
    Graph<String> routeMap = new Graph<>(8);
    Node<String> seattleNode = routeMap.addNode("Seattle");
    Node<String> vancouverNode = routeMap.addNode("Vancouver");
    Node<String> anchorageNode = routeMap.addNode("Anchorage");
    Node<String> boiseNode = routeMap.addNode("Boise");
    Node<String> denverNode = routeMap.addNode("Denver");
    Node<String> laNode = routeMap.addNode("Los Angeles");
    Node<String> slcNode = routeMap.addNode("Salt Lake City");
    Node<String> portlandNode = routeMap.addNode("Portland");
    routeMap.addEdge(seattleNode,vancouverNode,110);
    routeMap.addEdge(seattleNode,boiseNode,90);
    routeMap.addEdge(seattleNode,portlandNode,150);
    routeMap.addEdge(seattleNode,laNode,200);
    routeMap.addEdge(seattleNode,denverNode,125);
    routeMap.addEdge(anchorageNode,vancouverNode,105);
    routeMap.addEdge(anchorageNode,boiseNode,75);
    routeMap.addEdge(vancouverNode,anchorageNode,105);
    routeMap.addEdge(vancouverNode,seattleNode,110);
    routeMap.addEdge(boiseNode,seattleNode,90);
    routeMap.addEdge(portlandNode,seattleNode,150);
    routeMap.addEdge(laNode,seattleNode,200);
    routeMap.addEdge(denverNode,seattleNode,125);
    routeMap.addEdge(denverNode,slcNode,140);
    routeMap.addEdge(slcNode,denverNode,140);

    String[] trip125 = new String[]{"Seattle","Denver"};
    String[] trip235 = new String[]{"Vancouver","Seattle","Denver"};
    String[] tripNull = new String[]{"Seattle","Salt Lake City"};
    String[] tripAll = new String[]{"Salt Lake City","Denver","Seattle","Los Angeles","Seattle","Portland","Seattle","Boise","Anchorage","Vancouver"};
    assertEquals(125,Graph.businessTrip(routeMap,trip125));
    assertEquals(235,Graph.businessTrip(routeMap,trip235));
    assertEquals(1160,Graph.businessTrip(routeMap,tripAll));
    assertNull(Graph.businessTrip(routeMap,tripNull));
  }

  @Test
  public void testBreadthFirst() throws Exception {
    Graph<Integer> testGraph = new Graph<>(6);
    Node<Integer> node1 = testGraph.addNode(1);
    Node<Integer> node2 = testGraph.addNode(2);
    Node<Integer> node3 = testGraph.addNode(3);
    Node<Integer> node4 = testGraph.addNode(4);
    Node<Integer> node5 = testGraph.addNode(5);
    Node<Integer> node6 = testGraph.addNode(6);
    testGraph.addEdge(node1,node2);
    testGraph.addEdge(node1,node3);
    testGraph.addEdge(node1,node4);
    testGraph.addEdge(node2,node3);
    testGraph.addEdge(node2,node5);
    testGraph.addEdge(node2,node6);
    testGraph.addEdge(node3,node2);
    testGraph.addEdge(node3,node4);
    testGraph.addEdge(node4,node1);
    testGraph.addEdge(node4,node2);
    testGraph.addEdge(node5,node6);

    HashSet<Node<Integer>> startAt1 = testGraph.breadthFirst(node1);
    HashSet<Node<Integer>> startAt1again = testGraph.breadthFirst(node1);
    HashSet<Node<Integer>> startAt3 = testGraph.breadthFirst(node3);
    HashSet<Node<Integer>> startAt5 = testGraph.breadthFirst(node5);

    assertEquals(startAt1again.toString(),startAt1.toString());
//    assertFalse(startAt3.toString().equals(startAt1.toString()));
    assertTrue(startAt5.contains(node1) && startAt5.contains(node2) && startAt5.contains(node3) && startAt5.contains(node4) && startAt5.contains(node5) && startAt5.contains(node6));

  }

}
