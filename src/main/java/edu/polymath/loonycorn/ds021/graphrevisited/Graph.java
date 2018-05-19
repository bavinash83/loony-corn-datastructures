package edu.polymath.loonycorn.ds021.graphrevisited;

import edu.polymath.loonycorn.ds021.stack.Stack;
import java.util.Set;

public interface Graph {

  enum GraphType{
    DIRECTED,
    UNDIRECTED;
  }

  void addEdge(int v1, int v2, int weight);

  void addEdge(int v1, int v2);

  int numberOfVertices();

  Set<AdjacentVertex> getAdjacentVertices(int v);

  Stack<Integer> depthFirstTraversal();

  Stack<Integer> breadthFirstTraversal();


}
