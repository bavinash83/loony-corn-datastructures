package edu.polymath.loonycorn.ds021.queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueUsingStackTest {

  @Test
  public void scenario1() {
    QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
    Assert.assertTrue(queue.isEmpty());
    Assert.assertFalse(queue.isFull());

    for (int i = 0; i < queue.getMaxSize(); i++) {
      System.out.println(i);
      queue.enqueue(i);
      Assert.assertEquals(0, queue.peek().intValue());
      Assert.assertEquals(i + 1, queue.getSize());
      if (i < queue.getMaxSize() - 1) {
        Assert.assertFalse(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
      } else {
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.isFull());
      }
    }

    Assert.assertTrue(queue.isFull());
    for (int i = 0; i < queue.getMaxSize(); i++) {
      Assert.assertEquals(i, queue.dequeue().intValue());
      Assert.assertEquals(queue.getMaxSize() - (i + 1), queue.getSize());

      if (i == queue.getMaxSize() - 1) {
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
      } else {
        Assert.assertFalse(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(i + 1, queue.peek().intValue());
      }

    }

    for (int i = 0; i < queue.getMaxSize(); i++) {
      queue.enqueue(i);
      Assert.assertEquals(0, queue.peek().intValue());
      Assert.assertEquals(i + 1, queue.getSize());
      if (i < queue.getMaxSize() - 1) {
        Assert.assertFalse(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
      } else {
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.isFull());
      }
    }

    Assert.assertTrue(queue.isFull());
    for (int i = 0; i < queue.getMaxSize(); i++) {
      Assert.assertEquals(i, queue.dequeue().intValue());
      Assert.assertEquals(queue.getMaxSize() - (i + 1), queue.getSize());

      if (i == queue.getMaxSize() - 1) {
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
      } else {
        Assert.assertFalse(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(i + 1, queue.peek().intValue());
      }

    }
  }

  @Test(expected = QueueOverFlowException.class)
  public void scenario2() {
    QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
    for (int i = 0; i < queue.getMaxSize() + 1; i++) {
      queue.enqueue(i);
    }
  }

  @Test(expected = QueueUnderFlowException.class)
  public void scenario3() {
    QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
    for (int i = 0; i < queue.getMaxSize(); i++) {
      queue.enqueue(i);
    }
    for (int i = 0; i < queue.getMaxSize() + 1; i++) {
      Assert.assertEquals(i, queue.dequeue().intValue());
    }
  }

  @Test(expected = QueueUnderFlowException.class)
  public void scenario4() {
    QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
    queue.dequeue();
  }

  @Test(expected = QueueUnderFlowException.class)
  public void scenario5() {
    QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
    queue.peek();
  }

  @Test
  public void scenario6() {
    QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
    for (int i = 0; i < queue.getMaxSize(); i++) {
      Assert.assertTrue(queue.offer(i));
    }

    Assert.assertFalse(queue.offer(101));
    Assert.assertFalse(queue.offer(102));
    Assert.assertFalse(queue.offer(103));
  }
}