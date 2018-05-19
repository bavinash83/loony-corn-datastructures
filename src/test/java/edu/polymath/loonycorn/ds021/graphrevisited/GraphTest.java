package edu.polymath.loonycorn.ds021.graphrevisited;


import edu.polymath.loonycorn.ds021.graphrevisited.Graph.GraphType;
import edu.polymath.loonycorn.ds021.stack.Stack;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

  private final int WEIGHT = 1;
  private final int A = 0;
  private final int B = 1;
  private final int C = 2;
  private final int D = 3;
  private final int E = 4;
  private final int F = 5;
  private final int G = 6;
  private final AdjacentVertex vx_A = AdjacentVertex.builder().vertex(A).weight(WEIGHT).build();
  private final AdjacentVertex vx_B = AdjacentVertex.builder().vertex(B).weight(WEIGHT).build();
  private final AdjacentVertex vx_C = AdjacentVertex.builder().vertex(C).weight(WEIGHT).build();
  private final AdjacentVertex vx_D = AdjacentVertex.builder().vertex(D).weight(WEIGHT).build();
  private final AdjacentVertex vx_E = AdjacentVertex.builder().vertex(E).weight(WEIGHT).build();
  private final AdjacentVertex vx_F = AdjacentVertex.builder().vertex(F).weight(WEIGHT).build();
  private final AdjacentVertex vx_G = AdjacentVertex.builder().vertex(G).weight(WEIGHT).build();



  // A(0) -> B(1) -> E(4)
  //  |        ^       ^
  //  \/       |       |
  // C(2) -- D(3) -----
  // G(6) -- F(5)
  //
  private Stack<Integer> shortestPath(GraphType graphType, Implementation implementation, int source, int destination){
    Graph graph = createAdjacentMatrixGraph(graphType, implementation);
    return new ShortestPath().find(graph, source, destination);
  }

  @Test
  public void shortestPath_Directed_Set_Graph(){
    Stack<Integer> path = shortestPath(GraphType.DIRECTED, Implementation.SET, 0,4);
    while( !path.isEmpty() ){
      System.out.println(path.pop());
    }
  }

  @Test
  public void topologicalSort_Directed_Set_Graph(){
    topologicalSort_Graph(Implementation.SET);
  }

  @Test
  public void topologicalSort_Directed_Matrix_Graph(){
    topologicalSort_Graph(Implementation.MATRIX);
  }

  @Test(expected = LoopExistsException.class)
  public void topologicalSortException_Directed_Set(){
    topologicalSortException(Implementation.SET);
  }

  @Test(expected = LoopExistsException.class)
  public void topologicalSortException_Directed_Matrix(){
    topologicalSortException(Implementation.MATRIX);
  }

  @Test
  public void getVertices_Directed_Set_Graph() {
    getVertices(GraphType.DIRECTED, Implementation.SET);
  }

  @Test
  public void getVertices_UnDirected_Set_Graph() {
    getVertices(GraphType.UNDIRECTED, Implementation.SET);
  }

  @Test
  public void getVertices_Directed_Matrix_Graph() {
    getVertices(GraphType.DIRECTED, Implementation.MATRIX);
  }

  @Test
  public void getVertices_UnDirected_Matrix_Graph() {
    getVertices(GraphType.UNDIRECTED, Implementation.MATRIX);
  }

  private void getVertices(GraphType graphType, Implementation implementation) {
    Assert.assertEquals(7,
        createAdjacentMatrixGraph(graphType, implementation).numberOfVertices());

  }

  @Test
  public void breadthFirstTraversal_Directed_Set_Graph() {
    breadthFirstTraversal_Directed_Graph(Implementation.SET);
  }

  @Test
  public void depthFirstTraversal_Directed_Set_Graph() {
    depthFirstTraversal_Directed_Graph(Implementation.SET);
  }

  @Test
  public void breadthFirstTraversal_UnDirected_Set_Graph() {
    breadthFirstTraversal_UnDirected_Graph(Implementation.SET);
  }

  @Test
  public void depthFirstTraversal_UnDirected_Set_Graph() {
    depthFirstTraversal_UnDirected_Graph(Implementation.SET);
  }

  @Test
  public void breadthFirstTraversal_Directed_Matrix_Graph() {
    breadthFirstTraversal_Directed_Graph(Implementation.MATRIX);
  }

  @Test
  public void depthFirstTraversal_Directed_Matrix_Graph() {
    depthFirstTraversal_Directed_Graph(Implementation.MATRIX);
  }

  @Test
  public void breadthFirstTraversal_UnDirected_Matrix_Graph() {
    breadthFirstTraversal_UnDirected_Graph(Implementation.MATRIX);
  }

  @Test
  public void depthFirstTraversal_UnDirected_Matrix_Graph() {
    depthFirstTraversal_UnDirected_Graph(Implementation.MATRIX);
  }

  @Test
  public void getAdjacentVertices_Directed_SET_Graph() {
    getAdjacentVerticesDirected(Implementation.SET);
  }

  @Test
  public void getAdjacentVertices_Directed_Matrix_Graph() {
    getAdjacentVerticesDirected(Implementation.MATRIX);
  }

  @Test
  public void getAdjacentVertices_UN_Directed_Matrix_Set() {
    getAdjacentVerticesUndirected(Implementation.SET);
  }

  @Test
  public void getAdjacentVertices_UN_Directed_Matrix_Graph() {
    getAdjacentVerticesUndirected(Implementation.MATRIX);
  }

  private void breadthFirstTraversal_Directed_Graph(Implementation implementation) {
    Graph graph = createAdjacentMatrixGraph(GraphType.DIRECTED, implementation);
    Stack<Integer> breadthFirstTraversal = graph.breadthFirstTraversal();
    Assert.assertEquals(D, breadthFirstTraversal.pop().intValue());
    Assert.assertEquals(E, breadthFirstTraversal.pop().intValue());
    Assert.assertEquals(C, breadthFirstTraversal.pop().intValue());
    Assert.assertEquals(B, breadthFirstTraversal.pop().intValue());
    Assert.assertEquals(A, breadthFirstTraversal.pop().intValue());
    Assert.assertTrue(breadthFirstTraversal.isEmpty());
  }

  private void depthFirstTraversal_Directed_Graph(Implementation implementation) {
    Graph graph = createAdjacentMatrixGraph(GraphType.DIRECTED, implementation);
    Stack<Integer> depthFirstTraversal = graph.depthFirstTraversal();
    Assert.assertEquals(A, depthFirstTraversal.pop().intValue());
    Assert.assertEquals(C, depthFirstTraversal.pop().intValue());
    Assert.assertEquals(D, depthFirstTraversal.pop().intValue());
    Assert.assertEquals(B, depthFirstTraversal.pop().intValue());
    Assert.assertEquals(E, depthFirstTraversal.pop().intValue());
    Assert.assertTrue(depthFirstTraversal.isEmpty());
  }

  private void breadthFirstTraversal_UnDirected_Graph(Implementation implementation) {
    Graph graph = createAdjacentMatrixGraph(GraphType.UNDIRECTED, implementation);
    Stack<Integer> breadthFirstTraversal = graph.breadthFirstTraversal();
    Assert.assertEquals(E, breadthFirstTraversal.pop().intValue());
    Assert.assertEquals(D, breadthFirstTraversal.pop().intValue());
    Assert.assertEquals(C, breadthFirstTraversal.pop().intValue());
    Assert.assertEquals(B, breadthFirstTraversal.pop().intValue());
    Assert.assertEquals(A, breadthFirstTraversal.pop().intValue());
    Assert.assertTrue(breadthFirstTraversal.isEmpty());
  }

  private void depthFirstTraversal_UnDirected_Graph(Implementation implementation) {
    Graph graph = createAdjacentMatrixGraph(GraphType.UNDIRECTED, implementation);
    Stack<Integer> depthFirstTraversal = graph.depthFirstTraversal();
    Assert.assertEquals(A, depthFirstTraversal.pop().intValue());
    Assert.assertEquals(B, depthFirstTraversal.pop().intValue());
    Assert.assertEquals(D, depthFirstTraversal.pop().intValue());
    Assert.assertEquals(E, depthFirstTraversal.pop().intValue());
    Assert.assertEquals(C, depthFirstTraversal.pop().intValue());
    Assert.assertTrue(depthFirstTraversal.isEmpty());
  }

  private void getAdjacentVerticesDirected(Implementation implementation) {
    Graph graph = createAdjacentMatrixGraph(GraphType.DIRECTED, implementation);
    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_B, vx_C), graph.getAdjacentVertices(A)));
    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_E), graph.getAdjacentVertices(B)));
    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_D), graph.getAdjacentVertices(C)));
    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_B, vx_E), graph.getAdjacentVertices(D)));

    Assert.assertTrue(
        CollectionUtils.isEmpty(graph.getAdjacentVertices(E)));

    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_F), graph.getAdjacentVertices(G)));

    Assert.assertTrue(
        CollectionUtils.isEmpty(graph.getAdjacentVertices(F)));
  }

  private void getAdjacentVerticesUndirected(Implementation implementation) {
    Graph graph = createAdjacentMatrixGraph(GraphType.UNDIRECTED, implementation);
    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_B, vx_C), graph.getAdjacentVertices(A)));
    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_A, vx_D, vx_E), graph.getAdjacentVertices(B)));
    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_A, vx_D), graph.getAdjacentVertices(C)));
    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_B, vx_C, vx_E), graph.getAdjacentVertices(D)));

    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_B, vx_D), graph.getAdjacentVertices(E)));

    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_F), graph.getAdjacentVertices(G)));

    Assert.assertTrue(
        SetUtils.isEqualSet(asSet(vx_G), graph.getAdjacentVertices(F)));
  }

  private void topologicalSortException(Implementation implementation){
    Graph graph = implementation == Implementation.MATRIX ?
        new AdjacencyMatrixGraph(7, GraphType.DIRECTED) :
        new AdjacencySetGraph(GraphType.DIRECTED);

    graph.addEdge(A, B);
    graph.addEdge(A, C);
    graph.addEdge(B, E);
    graph.addEdge(C, D);
    graph.addEdge(E, D);
    graph.addEdge(D, B);
    graph.addEdge(G, F);

    new TopologicalSort().sort(graph);
  }

  private void topologicalSort_Graph(Implementation implementation){
    TopologicalSort sortAlgo= new TopologicalSort();
    Stack<Integer> result = sortAlgo
        .sort(createAdjacentMatrixGraph(GraphType.DIRECTED, implementation));
    Assert.assertEquals(E, result.pop().intValue());
    Assert.assertEquals(B, result.pop().intValue());
    Assert.assertEquals(D, result.pop().intValue());
    Assert.assertEquals(F, result.pop().intValue());
    Assert.assertEquals(C, result.pop().intValue());
    Assert.assertEquals(G, result.pop().intValue());
    Assert.assertEquals(A, result.pop().intValue());
    Assert.assertTrue(result.isEmpty());
  }

  // A(0) -> B(1) -> E(4)
  //  |        ^       ^
  //  \/       |       |
  // C(2) -- D(3) -----
  // G(6) -- F(5)
  //
  private Graph createAdjacentMatrixGraph(GraphType graphType, Implementation implementation) {
    Graph graph = implementation == Implementation.MATRIX ?
        new AdjacencyMatrixGraph(7, graphType) :
        new AdjacencySetGraph(graphType);
    graph.addEdge(A, B);
    graph.addEdge(A, C);
    graph.addEdge(B, E);
    graph.addEdge(C, D);
    graph.addEdge(D, E);
    graph.addEdge(D, B);
    graph.addEdge(G, F);
    return graph;
  }

  private <T> Set<T> asSet(T... vertices) {
    return new HashSet<>(Arrays.asList(vertices));
  }

  enum Implementation {
    SET, MATRIX;
  }
}
