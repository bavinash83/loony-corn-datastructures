package edu.polymath.loonycorn.ds021.graphrevisited;

import edu.polymath.loonycorn.ds021.queue.Queue;
import edu.polymath.loonycorn.ds021.queue.QueueUsingArray;
import edu.polymath.loonycorn.ds021.stack.Stack;
import java.util.HashMap;
import java.util.Map;

public class ShortestPath {
  public Stack<Integer> find(Graph graph, int source, int destination){
    Map<Integer, DistanceBean> distanceBeanMap = createDistanceTable(graph, source);
    if(! distanceBeanMap.containsKey(destination)){
      throw new NoPathExistsException();
    }
    Stack<Integer> path = new Stack<>(graph.numberOfVertices());
    Queue<Integer> queue = new QueueUsingArray<>();
    queue.enqueue(destination);
    while(!queue.isEmpty()){
      int vertex = queue.dequeue();
      int previousVertex = distanceBeanMap.get(vertex).getLastBean();
      path.push(vertex);
      if(previousVertex != source){
        queue.enqueue(previousVertex);
      }
    }
    return path;
  }

  private Map<Integer, DistanceBean> createDistanceTable(Graph graph, int source){
    Map<Integer, DistanceBean> map = new HashMap<>();
    map.put(source, DistanceBean.builder().lastBean(source).distance(0).build());
    Queue<Integer> queue = new QueueUsingArray<>();
    queue.enqueue(source);
    while(!queue.isEmpty()){
      final int index = queue.dequeue();
      final int lastDistance = map.get(index).getDistance();

      graph.getAdjacentVertices(index).stream()
          .map(AdjacentVertex::getVertex)
          .forEach(vertex -> {
            if(!map.containsKey(vertex)){
              map.putIfAbsent(vertex, DistanceBean.builder().lastBean(index).distance(lastDistance+1).build());
              queue.enqueue(vertex);
            }
          });

    }

    return map;
  }
}
