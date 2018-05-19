package edu.polymath.loonycorn.ds021.stack;

public class Stack<T> {

  final int maxSize;
  int currentSize = 0;
  Element<T> top;

  public Stack(int _maxSize) {
    this.maxSize = _maxSize;
  }

  public void push(T data) throws StackOverflowException {
    if (currentSize == maxSize) {
      throw new StackOverflowException();
    }
    Element<T> element = new Element<T>(data, top);
    top = element;
    currentSize++;
  }

  public T pop() throws StackUnderflowException {
    if (currentSize == 0) {
      throw new StackUnderflowException();
    }
    T currentData = top.getData();
    top = top.getNext();
    currentSize--;
    return currentData;
  }

  public T peek() throws StackUnderflowException {
    if (currentSize == 0) {
      throw new StackUnderflowException();
    }
    return top.getData();
  }

  public boolean isFull() {
    return currentSize == maxSize;
  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public int getCurrentSize() {
    return this.currentSize;
  }
}
