package edu.polymath.loonycorn.ds021.queue;

public class QueueUsingLinkedList<T> implements Queue<T> {

  private Element<T> head;
  private Element<T> tail;
  private int maxSize = 100;
  private int currentSize = 0;

  public void enqueue(T data) {
    if (currentSize == maxSize) {
      throw new QueueOverFlowException();
    }
    Element<T> last = new Element<T>(data, null);
    if (currentSize == 0) {
      head = last;
      tail = last;
    } else {
      tail.setNext(last);
      tail = last;
    }
    currentSize++;
  }

  public T dequeue() {
    if (currentSize == 0) {
      throw new QueueUnderFlowException();
    }
    T data = head.getData();
    head = head.getNext();
    currentSize--;
    return data;
  }

  public T peek() {
    if (currentSize == 0) {
      throw new QueueUnderFlowException();
    }
    T data = head.getData();
    return data;
  }

  public boolean offer(T data) {
    if (currentSize == maxSize) {
      return false;
    }
    Element<T> last = new Element<T>(data, null);
    if (currentSize == 0) {
      head = last;
      tail = last;
    } else {
      tail.setNext(last);
      tail = last;
    }
    currentSize++;
    return true;
  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public boolean isFull() {
    return currentSize == maxSize;
  }

  public int getSize() {
    return currentSize;
  }

  public int getMaxSize() {
    return maxSize;
  }
}
