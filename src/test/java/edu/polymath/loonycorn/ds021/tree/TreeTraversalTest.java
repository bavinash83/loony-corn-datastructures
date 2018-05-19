package edu.polymath.loonycorn.ds021.tree;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTraversalTest {

//              0
//      10              11
//  20      21      22      23
//30  31  32  33  34  35  36  37

  Node<Integer> head = null;
  Tree<Integer> tree;

  @Before
  public void before() {
    Map<Integer, Node<Integer>> nodeMap = new HashMap<>();
    for (int i = 3; i >=0 ; i--) {
      for (int j = 0; j < Math.pow(2, i); j++) {
        int value = j + 10*i;
        int left = (j*2) + 10*(i+1);
        int right= (j*2) + 10*(i+1) + 1;
        nodeMap.put(value,
            new Node<>(value,
                nodeMap.get(left),nodeMap.get(right)));
      }
    }
    head = nodeMap.get(0);
    tree = new Tree<Integer>() {
      @Override
      public Node<Integer> getRoot() {
        return head;
      }
    };
  }

  @Test
  public void breadthFirstTraversal(){
    tree.breadthFirstTraversal();
  }

  @Test
  public void depthFirstInOrderTraversal(){
    tree.depthFirstInOrderTraversal();
  }

  @Test
  public void depthFirstPostOrderTraversal(){
    tree.depthFirstPostOrderTraversal();
  }

  @Test
  public void depthFirstPreOrderTraversal(){
    tree.depthFirstPreOrderTraversal();
  }

  @Test
  public void depth() {
    Assert.assertEquals(4, tree.depth());
  }

  @Test
  public void mirror(){
    System.out.println("depthFirstTraversal before mirror");
    tree.breadthFirstTraversal();
    tree.mirror();
    System.out.println("depthFirstTraversal after mirror");
    tree.breadthFirstTraversal();
  }
}