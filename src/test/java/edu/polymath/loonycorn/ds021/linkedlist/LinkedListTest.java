package edu.polymath.loonycorn.ds021.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

public class LinkedListTest {

  @Test
  public void addNode() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    n.addNode(3);
    n.addNode(4);
    n.addNode(5);
    n.addNode(10);

    System.out.println("Printing all nodes through printnode function");
    n.print(); //  to print all the nodes

    assertEquals(4, n.size());

  }

  @Test
  public void pop() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    assertNull(n.pop());
    assertEquals(0, n.size());
    n.addNode(3);
    n.addNode(4);
    n.addNode(5);
    n.addNode(10);

    n.print(); //  to print all the nodes
    assertEquals(new Integer(3), n.pop());
    assertEquals(3, n.size());

    n.print(); //  to print all the nodes
    assertEquals(new Integer(4), n.pop());
    assertEquals(2, n.size());

    n.print(); //  to print all the nodes
    assertEquals(new Integer(5), n.pop());
    assertEquals(1, n.size());

    n.print(); //  to print all the nodes
    assertEquals(new Integer(10), n.pop());
    assertEquals(0, n.size());

    n.print(); //  to print all the nodes
    assertNull(n.pop());
    assertEquals(0, n.size());
    assertNull(n.pop());
    assertEquals(0, n.size());
    assertNull(n.pop());
    assertEquals(0, n.size());
  }

  @Test
  public void getNth() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    assertNull(n.getNth(50));
    n.addNode(3);
    n.addNode(4);
    n.addNode(5);
    n.addNode(10);
    assertEquals(new Integer(3), n.getNth(0));
    assertEquals(new Integer(4), n.getNth(1));
    assertEquals(new Integer(5), n.getNth(2));
    assertEquals(new Integer(10), n.getNth(3));
    assertNull(null, n.getNth(4));
  }

  @Test
  public void insertNth() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    assertEquals(0, n.size());
    n.insertNth(50, 10);
    assertEquals(0, n.size());

    n.insertNth(0, 10);
    assertEquals(1, n.size());
    assertEquals(new Integer(10), n.getNth(0));
    assertEquals(1, n.size());
    assertEquals(new Integer(10), n.pop());
    assertEquals(0, n.size());

    n.addNode(3);
    n.addNode(4);
    n.addNode(5);
    n.addNode(10);

    assertEquals(new Integer(3), n.getNth(0));
    assertEquals(4, n.size());
    n.insertNth(0, 30);
    assertEquals(5, n.size());
    assertEquals(new Integer(30), n.getNth(0));
    assertEquals(new Integer(3), n.getNth(1));

    assertEquals(5, n.size());
    n.insertNth(50, 10);
    assertEquals(5, n.size());

    assertEquals(new Integer(10), n.getNth(4));
    assertNull(n.getNth(5));
    n.insertNth(4, 300);
    assertEquals(new Integer(300), n.getNth(4));
    assertEquals(new Integer(10), n.getNth(5));
  }

  @Test
  public void insertSorted() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    n.insertSorted(-500);
    n.insertSorted(-600);
    n.insertSorted(-550);
    n.insertSorted(300);
    n.insertSorted(200);
    n.insertSorted(100);
    n.insertSorted(0);
    n.insertSorted(-700);
    n.insertSorted(800);
    n.insertSorted(200);
    n.print();

    Integer previousValue = null;
    Integer currentValue = null;
    do {
      currentValue = n.pop();
      if (previousValue != null && currentValue != null) {
        assertTrue(
            "Failed with Previous Value: " + previousValue + " Current Value:" + currentValue,
            currentValue.compareTo(previousValue) >= 0);
      }
      previousValue = currentValue;
    } while (currentValue != null);

  }

  @Test
  public void appendList() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    n.addNode(3);
    n.addNode(4);
    n.addNode(5);
    n.addNode(10);

    LinkedList<Integer> n1 = new LinkedList<Integer>();
    n1.addNode(-3);
    n1.addNode(-4);
    n1.addNode(-5);
    n1.addNode(-10);

    n.appendList(n1);
    assertEquals(new Integer(3), n.pop());
    assertEquals(new Integer(4), n.pop());
    assertEquals(new Integer(5), n.pop());
    assertEquals(new Integer(10), n.pop());
    assertEquals(new Integer(-3), n.pop());
    assertEquals(new Integer(-4), n.pop());
    assertEquals(new Integer(-5), n.pop());
    assertEquals(new Integer(-10), n.pop());
    assertNull(n.pop());
  }

  @Test
  public void frontBackSplit() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    n.addNode(3);
    n.addNode(4);
    n.addNode(5);
    n.addNode(10);
    List<LinkedList<Integer>> ll = n.frontBackSplit();
    assertEquals(new Integer(3), ll.get(0).pop());
    assertEquals(new Integer(4), ll.get(0).pop());
    assertNull(ll.get(0).pop());
    assertEquals(new Integer(5), ll.get(1).pop());
    assertEquals(new Integer(10), ll.get(1).pop());
    assertNull(ll.get(1).pop());

    LinkedList<Integer> n1 = new LinkedList<Integer>();
    n1.addNode(-3);
    n1.addNode(-4);
    n1.addNode(-5);
    n1.addNode(-10);
    n1.addNode(-20);
    ll = n1.frontBackSplit();
    assertEquals(new Integer(-3), ll.get(0).pop());
    assertEquals(new Integer(-4), ll.get(0).pop());
    assertEquals(new Integer(-5), ll.get(0).pop());
    assertNull(ll.get(0).pop());
    assertEquals(new Integer(-10), ll.get(1).pop());
    assertEquals(new Integer(-20), ll.get(1).pop());
    assertNull(ll.get(1).pop());

    LinkedList<Integer> n2 = new LinkedList<Integer>();
    ll = n2.frontBackSplit();
    assertNull(ll.get(0).pop());
    assertNull(ll.get(1).pop());

    LinkedList<Integer> n3 = new LinkedList<Integer>();
    n3.addNode(500);
    ll = n3.frontBackSplit();
    assertEquals(new Integer(500), ll.get(0).pop());
    assertNull(ll.get(0).pop());
    assertNull(ll.get(1).pop());
  }

  @Test
  public void removeDuplicates() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    assertEquals(0, n.size());
    n.removeDuplicates();
    assertEquals(0, n.size());

    n.insertSorted(3);
    n.removeDuplicates();
    assertEquals(1, n.size());
    assertEquals(new Integer(3), n.getNth(0));

    n.insertSorted(10);
    n.insertSorted(5);
    n.insertSorted(3);
    n.insertSorted(-100);
    n.insertSorted(3);
    n.insertSorted(100);
    n.insertSorted(100);
    n.insertSorted(100);
    n.insertSorted(100);

    n.removeDuplicates();
    assertEquals(new Integer(-100), n.pop());
    assertEquals(new Integer(3), n.pop());
    assertEquals(new Integer(5), n.pop());
    assertEquals(new Integer(10), n.pop());
    assertEquals(new Integer(100), n.pop());
    assertNull(n.pop());

  }

  @Test
  public void changedHead() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    LinkedList<Integer> n1 = new LinkedList<Integer>();
    assertEquals(0, n.size());
    assertEquals(0, n1.size());
    n.changedHead(n1);
    assertEquals(0, n.size());
    assertEquals(0, n1.size());

    n.addNode(3);
    assertEquals(1, n.size());
    n.changedHead(n1);
    assertEquals(0, n.size());
    assertEquals(new Integer(3), n1.pop());

    n.addNode(4);
    n.addNode(5);
    n.addNode(10);

    n1.addNode(-3);
    n1.addNode(-4);
    n1.addNode(-5);
    n1.addNode(-10);
    n1.addNode(-20);

    assertEquals(3, n.size());
    n.changedHead(n1);
    assertEquals(2, n.size());
    assertEquals(new Integer(4), n1.pop());

    n.changedHead(n1);
    assertEquals(1, n.size());
    assertEquals(new Integer(5), n1.pop());

    n.changedHead(n1);
    assertEquals(0, n.size());
    assertEquals(new Integer(10), n1.pop());

    n.changedHead(n1);
    assertEquals(0, n.size());
    assertEquals(new Integer(-3), n1.pop());
  }


  @Test
  public void sortedMergeList() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    LinkedList<Integer> n1 = new LinkedList<Integer>();
    n.insertSorted(1);
    n.insertSorted(5);
    n.insertSorted(5);
    n.insertSorted(7);
    n.insertSorted(19);

    n1.insertSorted(3);
    n1.insertSorted(5);
    n1.insertSorted(6);
    n1.insertSorted(9);
    n1.insertSorted(14);
    n1.insertSorted(19);
    n1.insertSorted(20);

    LinkedList<Integer> mergedList = n.sortedMergeList(n1);
    assertEquals(new Integer(1), mergedList.pop());
    assertEquals(new Integer(3), mergedList.pop());
    assertEquals(new Integer(5), mergedList.pop());
    assertEquals(new Integer(5), mergedList.pop());
    assertEquals(new Integer(5), mergedList.pop());
    assertEquals(new Integer(6), mergedList.pop());
    assertEquals(new Integer(7), mergedList.pop());
    assertEquals(new Integer(9), mergedList.pop());
    assertEquals(new Integer(14), mergedList.pop());
    assertEquals(new Integer(19), mergedList.pop());
    assertEquals(new Integer(19), mergedList.pop());
    assertEquals(new Integer(20), mergedList.pop());
    assertNull(mergedList.pop());

    n1.deleteLinkedList();
    mergedList = n.sortedMergeList(n1);
    assertEquals(new Integer(1), mergedList.pop());
    assertEquals(new Integer(5), mergedList.pop());
    assertEquals(new Integer(5), mergedList.pop());
    assertEquals(new Integer(7), mergedList.pop());
    assertEquals(new Integer(19), mergedList.pop());
    assertNull(mergedList.pop());

    n1.deleteLinkedList();
    n1.insertSorted(3);
    n1.insertSorted(5);
    n1.insertSorted(6);
    n1.insertSorted(9);
    mergedList = n1.sortedMergeList(null);
    assertEquals(new Integer(3), mergedList.pop());
    assertEquals(new Integer(5), mergedList.pop());
    assertEquals(new Integer(6), mergedList.pop());
    assertEquals(new Integer(9), mergedList.pop());
    assertNull(mergedList.pop());

    n1.deleteLinkedList();
    n.deleteLinkedList();
    n.insertSorted(3);
    n.insertSorted(5);
    mergedList = n1.sortedMergeList(n);
    assertEquals(new Integer(3), mergedList.pop());
    assertEquals(new Integer(5), mergedList.pop());
    assertNull(mergedList.pop());
  }

  @Test
  public void reverseList() throws Exception {
    LinkedList<Integer> n = new LinkedList<Integer>();
    n.insertSorted(1);
    n.insertSorted(5);
    n.insertSorted(5);
    n.insertSorted(7);
    n.insertSorted(19);
    n.reverseList();
    assertEquals(new Integer(19), n.pop());
    assertEquals(new Integer(7), n.pop());
    assertEquals(new Integer(5), n.pop());
    assertEquals(new Integer(5), n.pop());
    assertEquals(new Integer(1), n.pop());
    assertNull(n.pop());

    n.deleteLinkedList();
    n.reverseList();
    assertNull(n.pop());

    n.insertSorted(1);
    n.reverseList();
    assertEquals(new Integer(1), n.pop());
    n.print();

  }
}