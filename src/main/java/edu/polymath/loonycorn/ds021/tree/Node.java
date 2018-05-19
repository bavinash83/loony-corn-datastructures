package edu.polymath.loonycorn.ds021.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Node<T> {
  T data;
  Node<T> left;
  Node<T> right;
}
