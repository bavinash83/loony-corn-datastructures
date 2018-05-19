package edu.polymath.loonycorn.ds021.graphrevisited;

import static java.util.stream.Collectors.toSet;

import edu.polymath.loonycorn.ds021.queue.Queue;
import edu.polymath.loonycorn.ds021.queue.QueueUsingArray;
import edu.polymath.loonycorn.ds021.stack.Stack;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdjacencyMatrixGraph implements Graph {

  private static final int WEIGHT = 1;

  private final int numberOfNodes;
  private final GraphType graphType;
  private final AdjacentVertex matrix[][];


  public AdjacencyMatrixGraph(int numberOfNodes,
      GraphType graphType) {
    this.numberOfNodes = numberOfNodes;
    this.graphType = graphType;
    matrix = new AdjacentVertex[numberOfNodes][numberOfNodes];
  }

  @Override
  public int numberOfVertices() {
    return matrix.length;
  }

  @Override
  public void addEdge(int v1, int v2) {
    addEdge(v1, v2, WEIGHT);
  }

  @Override
  public void addEdge(int v1, int v2, int weight) {
    addDirectedEdge(v1, v2, weight);
    if (graphType == GraphType.UNDIRECTED) {
      addDirectedEdge(v2, v1, weight);
    }
  }

  private void addDirectedEdge(int v1, int v2, int w) {
    matrix[v1][v2] =
        AdjacentVertex.builder().vertex(v2).weight(w).build();
  }

  @Override
  public Set<AdjacentVertex> getAdjacentVertices(int v) {
    return Arrays.stream(matrix[v]).filter(Objects::nonNull)
        .collect(Collectors.toCollection(TreeSet::new));
  }

  @Override
  public Stack<Integer> depthFirstTraversal() {
    //Setup variables
    final int startIndex = 0;
    final boolean[] visited = new boolean[matrix.length];
    final Stack<Integer> result = new Stack<>(matrix.length);

    //Call depthFirstTraversal recursively
    depthFirstTraversal(startIndex, visited, result);

    return result;
  }

  private void depthFirstTraversal(int current, boolean[] visited, Stack<Integer> results){

    visited[current] = true;

    getAdjacentVertices(current).stream()
        .map(AdjacentVertex::getVertex)
        .filter(i -> !visited[i])
        .forEach(i -> depthFirstTraversal(i, visited, results));

    results.push(current);
  }

  @Override
  public Stack<Integer> breadthFirstTraversal() {
    //Setup variables
    final int startIndex = 0;
    final boolean[] visited = new boolean[matrix.length];
    final Queue<Integer> queue = new QueueUsingArray<>();
    final Stack<Integer> result = new Stack<>(matrix.length);
    final Consumer<Integer> processVertex = i -> {
      result.push(i);
      queue.enqueue(i);
      visited[i] = true;
    };

    //Add first element to start of
    processVertex.accept(startIndex);

    //Start add & emptying the queue in breadthFirst Order
    while (!queue.isEmpty()) {
      int index = queue.dequeue();
      getAdjacentVertices(index).stream()
          .map(AdjacentVertex::getVertex)
          .filter(i -> !visited[i])
          .forEach(processVertex);
    }
    return result;
  }


}
