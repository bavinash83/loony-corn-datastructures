package edu.polymath.loonycorn.ds021.heap;

import java.util.Arrays;
import org.junit.Test;

public class KLargestElementsTest {

  KLargestElements heap = new KLargestElements(10);

  @Test
  public void testAlgo(){
    for(int i=0;i<5000;i++){
      int value = Double.valueOf(Math.random() * 100_000).intValue();
      heap.processElement(value);
      System.out.println(Arrays.toString(heap.getLargeElements()));
    }
  }
}