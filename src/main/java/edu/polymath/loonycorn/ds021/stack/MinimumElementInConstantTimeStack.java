package edu.polymath.loonycorn.ds021.stack;

public class MinimumElementInConstantTimeStack<T extends Comparable<T>> {

  Stack<T> dataStack = new Stack<T>(100);
  Stack<T> nextMinimumStack = new Stack<T>(100);

  public void push(T t) {
    dataStack.push(t);
    if (nextMinimumStack.isEmpty() || nextMinimumStack.peek().compareTo(t) > 0) {
      nextMinimumStack.push(t);
    }
  }

  public T pop() {
    T t = dataStack.pop();
    if (nextMinimumStack.peek().compareTo(t) == 0) {
      nextMinimumStack.pop();
    }
    return t;
  }

  public T peekMinimum() {
    return nextMinimumStack.peek();
  }

  public T peek() {
    return dataStack.peek();
  }

}
