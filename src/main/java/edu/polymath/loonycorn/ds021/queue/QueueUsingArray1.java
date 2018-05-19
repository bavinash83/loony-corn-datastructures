package edu.polymath.loonycorn.ds021.queue;

public class QueueUsingArray1<T> implements Queue<T> {

  private final int SPECIAL_VARIABLE = -1;
  private final int MAX_SIZE = 50;
  private T[] dataArr = (T[]) new Object[MAX_SIZE];
  private int head = SPECIAL_VARIABLE;
  private int tail = SPECIAL_VARIABLE;

  public void enqueue(T data) {
    if (isFull()) {
      throw new QueueOverFlowException();
    }
    int nextTail = (tail + 1) % MAX_SIZE;
    dataArr[nextTail] = data;
    tail = nextTail;
    if (head == SPECIAL_VARIABLE) {
      head = tail;
    }
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new QueueUnderFlowException();
    }
    T data = dataArr[head];
    if (head == tail) {
      head = SPECIAL_VARIABLE;
    } else {
      head = (head + 1) % MAX_SIZE;
    }
    return data;
  }

  public T peek() {
    if (isEmpty()) {
      throw new QueueUnderFlowException();
    }
    T data = dataArr[head];
    return data;
  }

  public boolean offer(T data) {
    if (isFull()) {
      return false;
    }
    int nextTail = (tail + 1) % MAX_SIZE;
    dataArr[nextTail] = data;
    tail = nextTail;
    if (head == SPECIAL_VARIABLE) {
      head = tail;
    }
    return true;
  }

  public boolean isEmpty() {
    return head == SPECIAL_VARIABLE;
  }

  public boolean isFull() {
    int nextTail = (tail + 1) % MAX_SIZE;
    return head == nextTail;
  }

  public int getSize() {
    return head == SPECIAL_VARIABLE ? 0 :
        tail >= head ? (tail - head + 1) : (MAX_SIZE - head) + (tail + 1);
  }

  public int getMaxSize() {
    return MAX_SIZE;
  }
}
