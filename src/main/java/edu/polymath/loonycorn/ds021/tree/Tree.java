package edu.polymath.loonycorn.ds021.tree;

import edu.polymath.loonycorn.ds021.queue.Queue;
import edu.polymath.loonycorn.ds021.queue.QueueUsingLinkedList;

public interface Tree<T> {
  Node<T> getRoot();

  default void breadthFirstTraversal(){
    if(getRoot() == null) return;

    Queue<Node<T>> queue = new QueueUsingLinkedList<>();
    queue.enqueue(getRoot());
    while(!queue.isEmpty()){
      Node node = queue.dequeue();
      if(node.getLeft() != null) queue.enqueue(node.getLeft());
      if(node.getRight() != null) queue.enqueue(node.getRight());

      System.out.print(node.getData() + " --> ");
    }
  }

  default void depthFirstPreOrderTraversal(){
    if(getRoot() == null) return;

    dftp(getRoot());
  }

  default void dftp(Node node){
    if(node == null) return;
    System.out.print(node.getData() + " -> ");
    dftp(node.getLeft());
    dftp(node.getRight());
  }

  default void depthFirstInOrderTraversal(){
    if(getRoot() == null) return;

    dfti(getRoot());
  }

  default void dfti(Node node){
    if(node == null) return;
    dfti(node.getLeft());
    System.out.print(node.getData() + " -> ");
    dfti(node.getRight());
  }

  default void depthFirstPostOrderTraversal(){
    if(getRoot() == null) return;

    dftpost(getRoot());
  }

  default void dftpost(Node node){
    if(node == null) return;
    dftpost(node.getLeft());
    dftpost(node.getRight());
    System.out.print(node.getData() + " -> ");
  }

  default int depth(){
    return depth(getRoot());
  }

  default int depth(Node node){
    return node == null ? 0 :
        Integer.max(1 + depth(node.getLeft()), 1 + depth(node.getRight()));
  }

  default void mirror(){
    mirror(getRoot());
  }

  default void mirror(Node node){
    if(node == null)  return;
    else{
      mirror(node.getLeft());
      mirror(node.getRight());
      Node temp = node.getLeft();
      node.setLeft(node.getRight());
      node.setRight(temp);
    }
  }
}
