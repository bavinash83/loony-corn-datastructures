package edu.polymath.loonycorn.ds021.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyMatrixGraph implements Graph {

  int noOfVertices;
  int[][] adjacencyMatrix;
  GraphType graphType;

  public AdjacencyMatrixGraph(int _noOfVertices, GraphType _graphType) {
    this.noOfVertices = _noOfVertices;
    adjacencyMatrix = new int[_noOfVertices][_noOfVertices];
    graphType = _graphType;
  }

  private void fillWithZero() {
    for (int i = 0; i < adjacencyMatrix.length; i++) {
      for (int j = 0; j < adjacencyMatrix.length; j++) {
        adjacencyMatrix[i][j] = 0;
      }
    }
  }

  @Override
  public void addEdge(int v1, int v2) {
    if (isInvalidVertex(v1) || isInvalidVertex(v2)) {
      throw new IllegalVertexException();
    }

    adjacencyMatrix[v1][v2] = 1;
    if (graphType == GraphType.UNDIRECTED) {
      adjacencyMatrix[v2][v1] = 1;
    }
  }

  @Override
  public List<Integer> getAdjacentVertices(int v) {
    if (isInvalidVertex(v)) {
      throw new IllegalVertexException();
    }
    List<Integer> adjacentVertices = new ArrayList<>();
    for (int i = 0; i < adjacencyMatrix[v].length; i++) {
      if (adjacencyMatrix[v][i] == 1) {
        adjacentVertices.add(i);
      }
    }
    Collections.sort(adjacentVertices);
    return adjacentVertices;
  }

  @Override
  public void breadthFirstTraversal() {
    Map<Integer, Boolean> visited = new HashMap<>();
    for (int i = 0; i < adjacencyMatrix.length; i++) {
      breadthFirstTraversal(visited, i);
      System.out.println("");
    }
  }

  @Override
  public void depthFirstTraversal() {
    Map<Integer, Boolean> visited = new HashMap<>();
    for (int i = 0; i < adjacencyMatrix.length; i++) {
      depthFirstTraversal(visited, i);
      System.out.println("");
    }
  }

  private boolean isInvalidVertex(int vertex) {
    return vertex < 0 || vertex >= noOfVertices;
  }

}
