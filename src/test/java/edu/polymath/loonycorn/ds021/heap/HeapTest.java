package edu.polymath.loonycorn.ds021.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {

  public final int SIZE = 100_000;
  Heap<Integer> minHeap;
  Heap<Integer> maxHeap;
  int minimumValue = Integer.MAX_VALUE;
  int maximumValue = Integer.MIN_VALUE;

  @Before
  public void before() throws Exception {
    minHeap = Heap.createMinHeap(Integer.class, SIZE);
    maxHeap = Heap.createMaxHeap(Integer.class, SIZE);
    for (int i = 0; i < SIZE; i++) {
      int value = Double.valueOf(Math.random() * SIZE).intValue();
      minHeap.insert(value);
      maxHeap.insert(value);
      if (value < minimumValue) {
        minimumValue = value;
      }
      if (value > maximumValue) {
        maximumValue = value;
      }
    }
  }

  @Test
  public void minValue(){
    System.out.println("Minimum value test");
    System.out.println(minimumValue);
    System.out.println(minHeap.getMinValue());
    System.out.println(maxHeap.getMinValue());
  }

  @Test
  public void maxValue(){
    System.out.println("Maximum value test");
    System.out.println(maximumValue);
    System.out.println(minHeap.getMaxElement());
    System.out.println(maxHeap.getMaxElement());
  }
  @Test
  public void remove() throws Exception {
    int minLastValue = -1;
    int maxLastValue = SIZE + 1;

    Assert.assertTrue(minHeap.isFull());
    Assert.assertTrue(maxHeap.isFull());
    Assert.assertFalse(minHeap.isEmpty());
    Assert.assertFalse(maxHeap.isEmpty());

    while (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
      int minValue = minHeap.remove();
      int maxValue = maxHeap.remove();
      Assert.assertTrue(minLastValue <= minValue);
      Assert.assertTrue(maxLastValue >= maxValue);
      maxLastValue = maxValue;
      minLastValue = minValue;
    }
    Assert.assertFalse(minHeap.isFull());
    Assert.assertFalse(maxHeap.isFull());
    Assert.assertTrue(minHeap.isEmpty());
    Assert.assertTrue(maxHeap.isEmpty());
  }

}