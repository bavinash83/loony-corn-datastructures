package edu.polymath.loonycorn.ds021.graphrevisited;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AdjacentVertex implements Comparable<AdjacentVertex>{
  int vertex;
  int weight;

  @Override
  public int compareTo(AdjacentVertex o) {
    return Integer.compare(vertex, o.vertex);
  }
}
