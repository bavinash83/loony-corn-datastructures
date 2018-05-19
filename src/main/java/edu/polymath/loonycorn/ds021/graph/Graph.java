package edu.polymath.loonycorn.ds021.graph;

import edu.polymath.loonycorn.ds021.linkedlist.LinkedList;
import edu.polymath.loonycorn.ds021.queue.Queue;
import edu.polymath.loonycorn.ds021.queue.QueueUsingLinkedList;
import java.util.List;
import java.util.Map;

public interface Graph {

  enum GraphType{
    DIRECTED,
    UNDIRECTED;
  }

  void addEdge(int v1, int v2);

  List<Integer> getAdjacentVertices(int v);

  void depthFirstTraversal();

  void breadthFirstTraversal();

  default void depthFirstTraversal(Map<Integer, Boolean> visited, int currentNode){
    if(visited.getOrDefault(currentNode, Boolean.FALSE)){
      return;
    }
    visited.put(currentNode, true);
    List<Integer> adjacentVertices = getAdjacentVertices(currentNode);
    adjacentVertices.stream().forEach(node -> depthFirstTraversal(visited, node));
    System.out.print("-> " + currentNode);
  }

  default void breadthFirstTraversal(Map<Integer, Boolean> visited, int currentNode){
    if(visited.getOrDefault(currentNode, Boolean.FALSE)){
      return;
    }
    Queue<Integer> queue = new QueueUsingLinkedList<>();
    queue.enqueue(currentNode);
    visited.put(currentNode, true);

    while(!queue.isEmpty()){
      Integer node = queue.dequeue();
      System.out.print("-> "+ node);
      List<Integer> adjacentVertices = getAdjacentVertices(node);

      adjacentVertices.stream()
          .filter(vertex -> ! visited.getOrDefault(vertex, Boolean.FALSE))
          .forEach(vertex -> {
            queue.enqueue(vertex);
            visited.put(vertex, true);
          });
    }
  }
}
