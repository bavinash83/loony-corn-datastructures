package edu.polymath.loonycorn.ds021.graph;

import edu.polymath.loonycorn.ds021.graph.Graph.GraphType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

  private final int A = 0;
  private final int B = 1;
  private final int C = 2;
  private final int D = 3;
  private final int E = 4;
  private final int F = 5;
  private final int G = 6;

  @Test
  public void directedMatrixGraph() throws Exception {
    Graph graph = new AdjacencyMatrixGraph(7, GraphType.DIRECTED);
    testDirectedGraph(graph);
    System.out.println("Depth first Traversal");
    graph.depthFirstTraversal();
    System.out.println("Breadth first Traversal");
    graph.breadthFirstTraversal();
  }

  @Test
  public void unDirectedMatrixGraph() throws Exception {
    Graph graph = new AdjacencyMatrixGraph(7, GraphType.UNDIRECTED);
    testUnDirectedGraph(graph);
    System.out.println("Depth first Traversal");
    graph.depthFirstTraversal();
    System.out.println("Breadth first Traversal");
    graph.breadthFirstTraversal();
  }

  @Test
  public void directedSetGraph() throws Exception {
    Graph graph = new AdjacencySetGraph(GraphType.DIRECTED);
    testDirectedGraph(graph);
    System.out.println("Depth first Traversal");
    graph.depthFirstTraversal();
    System.out.println("Breadth first Traversal");
    graph.breadthFirstTraversal();
  }

  @Test
  public void unDirectedSetGraph() throws Exception {
    Graph graph = new AdjacencySetGraph(GraphType.UNDIRECTED);
    testUnDirectedGraph(graph);
    System.out.println("Depth first Traversal");
    graph.depthFirstTraversal();
    System.out.println("Breadth first Traversal");
    graph.breadthFirstTraversal();
  }


  private void testDirectedGraph(Graph graph) {
    addEdges(graph);

    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(B, C), graph.getAdjacentVertices(A)));
    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(E), graph.getAdjacentVertices(B)));
    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(D), graph.getAdjacentVertices(C)));
    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(B, E), graph.getAdjacentVertices(D)));
    Assert.assertTrue(CollectionUtils.isEmpty(graph.getAdjacentVertices(E)));
    Assert.assertTrue(CollectionUtils.isEmpty(graph.getAdjacentVertices(F)));
    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(F), graph.getAdjacentVertices(G)));
  }

  private void testUnDirectedGraph(Graph graph) {
    addEdges(graph);

    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(B, C), graph.getAdjacentVertices(A)));
    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(A, D, E), graph.getAdjacentVertices(B)));
    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(A, D), graph.getAdjacentVertices(C)));
    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(B, C, E), graph.getAdjacentVertices(D)));

    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(B, D), graph.getAdjacentVertices(E)));

    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(F), graph.getAdjacentVertices(G)));

    Assert.assertTrue(
        CollectionUtils.isEqualCollection(Arrays.asList(G), graph.getAdjacentVertices(F)));
  }

  // A(0) -> B(1) -> E(4)
  //  |        ^       ^
  //  \/       |       |
  // C(2) -- D(3) -----
  //
  //
  private void addEdges(Graph graph) {
    graph.addEdge(A, B);
    graph.addEdge(A, C);
    graph.addEdge(B, E);
    graph.addEdge(C, D);
    graph.addEdge(D, E);
    graph.addEdge(D, B);
    graph.addEdge(G, F);
  }




}