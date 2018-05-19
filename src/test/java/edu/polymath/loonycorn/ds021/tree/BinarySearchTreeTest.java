package edu.polymath.loonycorn.ds021.tree;

import edu.polymath.loonycorn.ds021.linkedlist.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

  public final int SIZE = 100000;
  BinarySearchTree<Integer> bst;
  int[] values;
  int minimum = 100001;
  int maximum = -1;
  int totalInRangeOf100to500 = 0;
  int MIN_RANGE = 100;
  int MAX_RANGE = 500;

  @Before
  public void before() {
    bst = new BinarySearchTree<>();
    values = new int[SIZE];
    for (int i = 0; i < SIZE; i++) {
      int value = Double.valueOf(Math.random() * 100000).intValue();
      if (value < minimum) {
        minimum = value;
      }
      if (value > maximum) {
        maximum = value;
      }
      if (value >= MIN_RANGE && value <= MAX_RANGE) {
        totalInRangeOf100to500 += value;
      }
      bst.insert(value);
      values[i] = value;
    }
  }

  @Test
  public void insert() throws Exception {
    testInsert(bst.getRoot());
  }

  @Test
  public void lookup() throws Exception {
    for (int i = 0; i < values.length; i++) {
      Assert.assertTrue(bst.lookup(values[i]));
    }
    Assert.assertFalse(bst.lookup(-100));
    Assert.assertFalse(bst.lookup(-100000));

  }

  private void testInsert(Node<Integer> root) {
    Node<Integer> left = root.getLeft();
    Node<Integer> right = root.getRight();
    Integer data = root.getData();

    if (left != null) {
      Assert.assertTrue(data.compareTo(left.data) >= 0);
      testInsert(left);
    }

    if (right != null) {
      Assert.assertTrue(data.compareTo(right.getData()) < 0);
      testInsert(right);
    }
  }

  @Test
  public void getMinimum() throws Exception {
    Assert.assertEquals(minimum, bst.getMinimum().intValue());
  }

  @Test
  public void getMaximum() throws Exception {
    Assert.assertEquals(maximum, bst.getMaximum().intValue());
  }

  @Test
  public void range() throws Exception {
    LinkedList<Integer> range = bst.inRange(100, 500);
    Integer i = null;
    int total = 0;
    do {
      i = range.pop();
      total = total + (i == null ? 0 : i);
    } while (i != null);
    Assert.assertEquals(totalInRangeOf100to500, total);
  }
}