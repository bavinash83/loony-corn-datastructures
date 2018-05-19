package edu.polymath.loonycorn.ds021.tree;

import edu.polymath.loonycorn.ds021.linkedlist.LinkedList;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

  Node<T> root;

  @Override
  public Node<T> getRoot() {
    return this.root;
  }

  public void insert(T value) {
    if (root == null) {
      root = new Node<>(value, null, null);
    } else {
      insert(value, root);
    }
  }

  private void insert(T value, Node<T> root) {
    if (value.compareTo(root.getData()) <= 0) {
      if (root.getLeft() == null) {
        root.setLeft(new Node<>(value, null, null));
      } else {
        insert(value, root.getLeft());
      }
    } else {
      if (root.getRight() == null) {
        root.setRight(new Node<>(value, null, null));
      } else {
        insert(value, root.getRight());
      }
    }
  }

  public boolean lookup(T value) {
    if (root == null) {
      return false;
    } else {
      return lookup(value, root);
    }
  }

  private boolean lookup(T value, Node<T> root) {
    if (value.compareTo(root.getData()) == 0) {
      return true;
    } else if (value.compareTo(root.getData()) < 0) {
      if (root.getLeft() == null) {
        return false;
      } else {
        return lookup(value, root.getLeft());
      }
    } else {
      if (root.getRight() == null) {
        return false;
      } else {
        return lookup(value, root.getRight());
      }
    }
  }

  public T getMinimum(Node<T> node) {
    return
        node.getLeft() == null ? node.getData() : getMinimum(node.getLeft());
  }

  public T getMinimum() {
    return root == null ? null : getMinimum(root);
  }


  /*public T getMinimum(){
    if(root == null) return null;
    else{
      Node<T> current = root;
      while(current.left != null){
        current = current.left;
      }
      return current.data;
    }
  }*/

  public T getMaximum() {
    if (root == null) {
      return null;
    } else {
      Node<T> currentNode = root;
      while (currentNode.getRight() != null) {
        currentNode = currentNode.right;
      }
      return currentNode.data;
    }
  }

  public LinkedList<T> inRange(T min, T max){
    if (min.compareTo(max) > 0) {
      return null;
    }
    LinkedList<T> results = new LinkedList<>();
    inRange(results, root, min, max);
    return results;
  }

  public void inRange(LinkedList<T> results,Node<T> node, T min, T max) {
    if (node == null) {
      return;
    } else {
      T data = node.getData();

      if (data.compareTo(min) >= 0) {
        inRange(results, node.getLeft(), min, max);
      }

      if (data.compareTo(min) >= 0 && data.compareTo(max) <= 0) {
        results.addNode(data);
      }

      if (data.compareTo(max) <= 0) {
        inRange(results, node.getRight(), min, max);
      }
    }
  }



}
