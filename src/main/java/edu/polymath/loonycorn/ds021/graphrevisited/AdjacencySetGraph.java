package edu.polymath.loonycorn.ds021.graphrevisited;

import edu.polymath.loonycorn.ds021.queue.Queue;
import edu.polymath.loonycorn.ds021.queue.QueueUsingArray;
import edu.polymath.loonycorn.ds021.stack.Stack;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AdjacencySetGraph implements Graph {
  final static int WEIGHT = 1;
  final Map<Integer, Set<AdjacentVertex>> dataSet;
  final GraphType graphType;
  final Set<Integer> vertices;

  public AdjacencySetGraph(GraphType graphType){
    this.dataSet = new HashMap<>();
    this.vertices = new HashSet<>();
    this.graphType = graphType;
  }

  @Override
  public int numberOfVertices() {
    return vertices.size();
  }

  @Override
  public void addEdge(final int v1, final int v2) {
    addEdge(v1 ,v2, WEIGHT);
  }

  @Override
  public void addEdge(final int v1, final int v2, final int weight) {
    vertices.add(v1);
    vertices.add(v2);

    addDirectedEdge(v1, v2, weight);
    if(graphType == GraphType.UNDIRECTED){
      addDirectedEdge(v2, v1, weight);
    }
  }

  private void addDirectedEdge(final int v1, final int v2, final int weight){
    dataSet.putIfAbsent(v1, new TreeSet<>());
    dataSet.get(v1).add(AdjacentVertex.builder().weight(weight).vertex(v2).build());
  }

  @Override
  public Set<AdjacentVertex> getAdjacentVertices(int v) {
    return dataSet.getOrDefault(v, Collections.EMPTY_SET);
  }

  @Override
  public Stack<Integer> depthFirstTraversal() {
    Stack<Integer> results = new Stack<>(dataSet.size());
    Set<Integer> visited = new HashSet<>();
    depthFirstTraversal(0, visited, results);
    return results;
  }

  private void depthFirstTraversal(int current, Set<Integer> visited, Stack<Integer> results){
    visited.add(current);
    getAdjacentVertices(current).stream()
        .map(AdjacentVertex::getVertex)
        .filter(i -> !visited.contains(i))
        .forEach(i -> depthFirstTraversal(i, visited, results));
    results.push(current);
  }

  @Override
  public Stack<Integer> breadthFirstTraversal() {
    Stack<Integer> results = new Stack<>(dataSet.size());
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new QueueUsingArray<>();
    Consumer<Integer> process = i -> {
      queue.enqueue(i);
      visited.add(i);
      results.push(i);
    };

    process.accept(0);
    while(!queue.isEmpty()){
      getAdjacentVertices(queue.dequeue()).stream()
          .map(AdjacentVertex::getVertex)
          .filter(i -> !visited.contains(i))
          .forEach(process);
    }
    return results;
  }
}
