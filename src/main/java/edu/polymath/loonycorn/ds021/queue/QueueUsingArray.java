package edu.polymath.loonycorn.ds021.queue;

public class QueueUsingArray<T> implements Queue<T> {

  private final int maxSize = 100;
  private int currentSize = 0;
  private T[] dataArr = (T[]) new Object[maxSize];
  private int head = -1;
  private int tail = -1;

  private int next(final int current) {
    return current == (maxSize - 1) ? 0 : (current + 1);
  }

  public void enqueue(T data) {
    if (currentSize == maxSize) {
      throw new QueueOverFlowException();
    }
    tail = next(tail);
    dataArr[tail] = data;
    if (head == -1) {
      head = tail;
    }
    currentSize++;
  }

  public T dequeue() {
    if (currentSize == 0) {
      throw new QueueUnderFlowException();
    }
    T data = dataArr[head];
    head = next(head);
    currentSize--;
    return data;
  }

  public T peek() {
    if (currentSize == 0) {
      throw new QueueUnderFlowException();
    }
    T data = dataArr[head];
    return data;
  }

  public boolean offer(T data) {
    if (currentSize == maxSize) {
      return false;
    }
    tail = next(tail);
    dataArr[tail] = data;
    if (head == -1) {
      head = tail;
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
