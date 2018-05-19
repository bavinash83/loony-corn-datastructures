package edu.polymath.loonycorn.ds021.queue;

public interface Queue<T> {

  public void enqueue(T data);

  public T dequeue();

  public T peek();

  public boolean offer(T data);

  public boolean isEmpty();

  public boolean isFull();

  public int getSize();

  public int getMaxSize();
}
