package datastructures.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

  @Test
  public void testCreateGraph() {
    Graph<Integer> testGraph = new Graph<>(10);

    assertEquals(0,testGraph.getNodeCount());
    assertEquals(0,testGraph.size());
    assertEquals(0,testGraph.adjacencyLists.size());
  }

  @Test
  public void testAddNode() throws Exception {
    Graph<Integer> testGraph = new Graph<>(10);
    Node<Integer> testNode4 = testGraph.addNode(4);
    Node<Integer> testNode6 = testGraph.addNode(6);

    assertEquals(2,testGraph.size());
    assertEquals(0,testGraph.adjacencyLists.get(testNode4).size());

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

    assertEquals(6,testGraph.adjacencyLists.get(testNode4).getFirst().getDestination().getValue());
    assertEquals(3,testGraph.adjacencyLists.get(testNode2).getFirst().getWeight());

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
}
