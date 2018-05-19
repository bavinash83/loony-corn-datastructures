package edu.polymath.loonycorn.ds021.linkedlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LinkedList<T extends Comparable<T>> implements Serializable {

  Node<T> head;

  public void addNode(final T data) {
    Node<T> node = new Node<T>(data, null);
    if (head == null) {
      head = node;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.getNext();
      }
      current.setNext(node);
    }
  }

  public T pop() {
    if (head == null) {
      return null;
    } else {
      Node<T> first = head;
      head = head.getNext();
      return first.getData();
    }
  }

  public int size() {
    int count = 0;
    Node<T> curr = head;
    while (curr != null) {
      curr = curr.getNext();
      count++;
    }
    return count;
  }

  public void print() {
    if (head == null) {
      System.out.println("Empty Linkedlist");
    } else {
      Node<T> curr = head;
      int counter = 0;
      while (curr != null) {
        System.out.printf("node[%d] = %s\t->\t", counter, curr.getData().toString());
        curr = curr.getNext();
        counter++;
      }
      System.out.println("END");
    }
  }

  public void deleteLinkedList() {
    head = null;
  }

  public void insertNth(final int index, final T data) {
    if (index == 0) {
      Node<T> node = new Node(data, head);
      head = node;
      return;
    } else {
      int counter = 0;
      Node<T> curr = head;
      while (curr != null && counter < index - 1) {
        curr = curr.getNext();
        counter++;
      }
      if (curr != null) {
        Node<T> node = new Node(data, curr.getNext());
        curr.setNext(node);
      }
    }
  }

  public T getNth(final int index) {
    int counter = 0;
    Node<T> curr = head;
    while (curr != null && counter < index) {
      curr = curr.getNext();
      counter++;
    }
    if (curr != null) {
      return curr.getData();
    }
    return null;
  }

  public void insertSorted(T data) {
    if (head == null || head.getData().compareTo(data) > 0) {
      Node<T> node = new Node<T>(data, head);
      head = node;
      return;
    } else {
      Node curr = head.getNext();
      Node previous = head;
      while (curr != null) {
        if (previous.getData().compareTo(data) <= 0 && curr.getData().compareTo(data) >= 0) {
          Node<T> node = new Node<T>(data, curr);
          previous.setNext(node);
          return;
        }
        //last lines
        previous = curr;
        curr = curr.getNext();
      }
      Node<T> node = new Node<T>(data, null);
      previous.setNext(node);
    }
  }

  public void appendList(LinkedList<T> list) {
    if (head == null) {
      head = list.head;
    }
    Node current = list.head;
    while (current != null) {
      addNode((T) current.getData());
      current = current.getNext();
    }
  }

  public List<LinkedList<T>> frontBackSplit() {
    Node front = null;
    Node back = null;
    if (head != null && head.getNext() != null) {
      Node<T> slow = head;
      Node<T> fast = head;
      while (fast != null) {
        fast = fast.getNext();
        if (fast == null) {
          break;
        }
        fast = fast.getNext();
        if (fast == null) {
          break;
        }
        slow = slow.getNext();
      }
      front = head;
      back = slow.getNext();
      slow.setNext(null);
    } else if (head != null && head.getNext() == null) {
      front = head;
    }
    List<LinkedList<T>> list = new ArrayList<LinkedList<T>>();
    LinkedList<T> frontList = new LinkedList<T>();
    frontList.head = front;
    LinkedList<T> backList = new LinkedList<T>();
    backList.head = back;
    list.add(frontList);
    list.add(backList);
    return list;
  }

  public void removeDuplicates() {
    Node current = head;
    while (current != null && current.next != null) {
      if (current.getData().compareTo(current.next.getData()) == 0) {
        current.setNext(current.getNext().getNext());
      } else {
        current = current.getNext();
      }
    }
  }

  public void changedHead(LinkedList<T> destinationList) {
    if (destinationList == null || head == null) {
      return;
    } else {
      T previousHeadOFThisList = pop();
      if (destinationList.head == null) {
        destinationList.addNode(previousHeadOFThisList);
      } else {
        Node<T> newHeadForDestinationList = new Node<T>(previousHeadOFThisList,
            destinationList.head);
        destinationList.head = newHeadForDestinationList;
      }
    }
  }

  public LinkedList<T> sortedMergeList(LinkedList<T> otherList) {
    if (otherList == null) {
      return this;
    } else if (this.head == null) {
      return otherList;
    } else {
      LinkedList<T> newList = new LinkedList<T>();
      Node<T> thisCurrent = head;
      Node<T> otherCurrent = otherList.head;
      while (thisCurrent != null || otherCurrent != null) {
        if (thisCurrent == null) {
          newList.addNode(otherCurrent.getData());
          otherCurrent = otherCurrent.getNext();
        } else if (otherCurrent == null) {
          newList.addNode(thisCurrent.getData());
          thisCurrent = thisCurrent.getNext();
        } else {
          T thisData = thisCurrent.getData();
          T otherData = otherCurrent.getData();
          if (thisData.compareTo(otherData) == 0) {
            newList.addNode(thisData);
            newList.addNode(otherData);
            thisCurrent = thisCurrent.getNext();
            otherCurrent = otherCurrent.getNext();
          } else if (thisData.compareTo(otherData) < 0) {
            newList.addNode(thisData);
            thisCurrent = thisCurrent.getNext();
          } else {
            newList.addNode(otherData);
            otherCurrent = otherCurrent.getNext();
          }
        }
      }
      return newList;
    }
  }

  public void reverseList() {
    if (head == null || head.next == null) {
      return;
    } else {
      Node currentNode = head;
      Node previousNode = null;
      while (currentNode != null) {
        Node holdNode = currentNode.next;
        currentNode.next = previousNode;
        previousNode = currentNode;
        currentNode = holdNode;
      }
      head = previousNode;
    }
  }

}
