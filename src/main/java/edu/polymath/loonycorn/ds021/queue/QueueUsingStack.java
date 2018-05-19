package edu.polymath.loonycorn.ds021.queue;

import edu.polymath.loonycorn.ds021.stack.Stack;

public class QueueUsingStack<T> implements Queue<T> {

  private final int MAX_SIZE = 50;
  private Stack<T> pushStack = new Stack<T>(MAX_SIZE);
  private Stack<T> popStack = new Stack<T>(MAX_SIZE);

  public void enqueue(T data) {
    if (pushStack.isFull()) {
      throw new QueueOverFlowException();
    }
    pushStack.push(data);
  }

  public T dequeue() {
    if (pushStack.isEmpty()) {
      throw new QueueUnderFlowException();
    }
    while (!pushStack.isEmpty()) {
      popStack.push(pushStack.pop());
    }
    T data = popStack.pop();
    while (!popStack.isEmpty()) {
      pushStack.push(popStack.pop());
    }
    return data;
  }

  public T peek() {
    if (pushStack.isEmpty()) {
      throw new QueueUnderFlowException();
    }
    while (!pushStack.isEmpty()) {
      popStack.push(pushStack.pop());
    }
    T data = popStack.peek();
    while (!popStack.isEmpty()) {
      pushStack.push(popStack.pop());
    }
    return data;
  }

  public boolean offer(T data) {
    if (pushStack.isFull()) {
      return false;
    }
    pushStack.push(data);
    return true;
  }

  public boolean isEmpty() {
    return pushStack.isEmpty() && popStack.isEmpty();
  }

  public boolean isFull() {
    return pushStack.isFull() || popStack.isFull();
  }

  public int getSize() {
    return pushStack.getCurrentSize();
  }

  public int getMaxSize() {
    return MAX_SIZE;
  }
}
