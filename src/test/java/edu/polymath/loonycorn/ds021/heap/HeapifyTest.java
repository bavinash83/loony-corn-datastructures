package edu.polymath.loonycorn.ds021.heap;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapifyTest {

  Integer[] rawData;
  public final int SIZE = 100_000;


  @Before
  public void before() {
    rawData = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      rawData[i] = Double.valueOf(Math.random() * SIZE).intValue();
    }
  }

  @Test
  public void testHeapSort() {
    Integer[] unSortedArr = Arrays.copyOf(rawData, rawData.length);
    System.out.println(Arrays.toString(Arrays.copyOf(unSortedArr,100)));
    Heap.heapSort(unSortedArr);
    System.out.println(Arrays.toString(Arrays.copyOf(unSortedArr,100)));
    int minLastValue = Integer.MIN_VALUE;

    for (int i = 0; i < unSortedArr.length; i++) {
      int value = unSortedArr[i];
      Assert.assertTrue(value >= minLastValue);
      minLastValue = value;
    }
  }

  @Test
  public void testMaxHeap() {
    Heap<Integer> maxHeap;

    maxHeap = Heap.maxHeapify(Arrays.copyOf(rawData, rawData.length));

    int maxLastValue = Integer.MAX_VALUE;
    Assert.assertTrue(maxHeap.isFull());
    Assert.assertFalse(maxHeap.isEmpty());
    while (!maxHeap.isEmpty()) {
      int maxValue = maxHeap.remove();
      Assert.assertTrue(maxLastValue >= maxValue);
    }
    Assert.assertFalse(maxHeap.isFull());
    Assert.assertTrue(maxHeap.isEmpty());
  }
}