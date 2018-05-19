package edu.polymath.loonycorn.ds021.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Node<T extends Comparable<T>> {

  @NonNull
  T data;
  Node<T> next;
}
