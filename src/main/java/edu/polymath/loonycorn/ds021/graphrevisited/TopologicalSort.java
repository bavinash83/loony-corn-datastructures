package edu.polymath.loonycorn.ds021.graphrevisited;

import edu.polymath.loonycorn.ds021.queue.Queue;
import edu.polymath.loonycorn.ds021.queue.QueueUsingArray;
import edu.polymath.loonycorn.ds021.stack.Stack;

public class TopologicalSort {

  public Stack<Integer> sort(Graph graph) {
    Stack<Integer> result = new Stack<>(graph.numberOfVertices());
    Queue<Integer> queue = new QueueUsingArray<>();
    int[] inDegrees = computeInDegree(graph);
    for (int i = 0; i < inDegrees.length; i++) {
      if (inDegrees[i] == 0) {
        queue.enqueue(i);
      }
    }

    while (!queue.isEmpty()) {
      int index = queue.dequeue();
      result.push(index);
      graph.getAdjacentVertices(index).stream()
          .map(AdjacentVertex::getVertex)
          .forEach(vertex -> {
            inDegrees[vertex] -= 1;
            if (inDegrees[vertex] == 0) {
              queue.enqueue(vertex);
            }
          });
    }

    if(result.getCurrentSize() != graph.numberOfVertices()){
      throw new LoopExistsException();
    }

    return result;
  }

  private int[] computeInDegree(Graph graph) {
    int[] inDegrees = new int[graph.numberOfVertices()];
    for (int i = 0; i < graph.numberOfVertices(); i++) {
      graph.getAdjacentVertices(i).stream()
          .forEach(adjacentVertex -> inDegrees[adjacentVertex.getVertex()] += 1);
    }
    return inDegrees;
  }
}
