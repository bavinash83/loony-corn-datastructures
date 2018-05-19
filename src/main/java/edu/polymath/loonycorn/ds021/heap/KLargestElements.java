package edu.polymath.loonycorn.ds021.heap;

public class KLargestElements {

  final Heap<Integer> heap;

  public KLargestElements() {
    this(10);
  }

  public KLargestElements(int k) {
    heap = Heap.createMinHeap(Integer.class, k);
  }

  public void processElement(Integer number) {
    if (!heap.isFull() || number > heap.getHighestPriority()) {
      if(heap.isFull()){
        heap.remove();
      }
      heap.insert(number);
    }
  }

  public Integer[] getLargeElements() {
    return heap.cloneData();
  }
}
