package edu.polymath.loonycorn.ds021.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.Value;

public class AdjacencySetGraph implements Graph {

  private final static Node EMPTY_NODE = new Node(-1, Collections.EMPTY_SET);

  final Map<Integer, Node> vertices;
  final GraphType graphType;

  public AdjacencySetGraph(GraphType _graphType) {
    vertices = new HashMap<>();
    graphType = _graphType;
  }

  @Override
  public void addEdge(int v1, int v2) {
    vertices.putIfAbsent(v1, new Node(v1, new HashSet<>()));
    vertices.putIfAbsent(v2, new Node(v2, new HashSet<>()));
    vertices.get(v1).getAdjacentNodes().add(vertices.get(v2));
    if (graphType == GraphType.UNDIRECTED) {
      vertices.get(v2).getAdjacentNodes().add(vertices.get(v1));
    }
  }

  @Override
  public List<Integer> getAdjacentVertices(int v) {
    return vertices.getOrDefault(v, EMPTY_NODE)
        .getAdjacentNodes().stream()
        .map(Node::getNodeIndex)
        .sorted()
        .collect(Collectors.toList());
  }

  @Override
  public void depthFirstTraversal(){
    Map<Integer, Boolean> visted = new HashMap<>();
    vertices.keySet().stream()
        .forEach(vertex -> {
          depthFirstTraversal(visted, vertex);
          System.out.println("");
        });
  }

  @Override
  public void breadthFirstTraversal() {
    Map<Integer, Boolean> visted = new HashMap<>();
    vertices.keySet().stream()
        .forEach(vertex -> {
          breadthFirstTraversal(visted, vertex);
          System.out.println("");
        });
  }

  @Value
  @EqualsAndHashCode(exclude = "adjacentNodes")
  private static class Node {
    int nodeIndex;
    Set<Node> adjacentNodes;
  }


}


