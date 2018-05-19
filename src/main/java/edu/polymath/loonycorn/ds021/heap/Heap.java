package edu.polymath.loonycorn.ds021.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class Heap<T extends Comparable<T>> {

  T[] data;
  private final BiPredicate<Integer, Integer> maxHeapNature = (parentIndex, childIndex) ->
      getValue(parentIndex).compareTo(getValue(childIndex)) < 0;
  private final BiPredicate<Integer, Integer> minHeapNature = (parentIndex, childIndex) ->
      getValue(parentIndex).compareTo(getValue(childIndex)) > 0;
  int size = 0;
  private BiPredicate<Integer, Integer> heapNature;


  private Heap(Class<T> clazz, int size) {
    data = (T[]) Array.newInstance(clazz, size);
  }

  private Heap(T[] rawData) {
    data = rawData;
    size = rawData.length;
  }


  public static <T extends Comparable<T>> Heap<T> createMinHeap(Class<T> clazz, int size) {
    Heap<T> heap = new Heap<T>(clazz, size);
    heap.heapNature = heap.minHeapNature;
    return heap;
  }


  public static <T extends Comparable<T>> Heap<T> createMaxHeap(Class<T> clazz, int size) {
    Heap<T> heap = new Heap<T>(clazz, size);
    heap.heapNature = heap.maxHeapNature;
    return heap;
  }

  public static <T extends Comparable<T>> Heap<T> maxHeapify(T[] rawData) {
    Heap<T> heap = new Heap<T>(rawData);
    heap.heapNature = heap.maxHeapNature;
    heap.heapify();
    return heap;
  }

  public static <T extends Comparable<T>> T[] heapSort(T[] rawData) {
    Heap<T> heap = maxHeapify(rawData);
    for (int i = rawData.length - 1; i >= 0; i--) {
      rawData[i] = heap.remove();
    }
    return rawData;
  }

  T getMaxElement() {
    if (isEmpty()) {
      throw new HeapEmptyException();
    }
    if (heapNature == maxHeapNature) {
      return getHighestPriority();
    } else {
      int firstLeafNode = parent(size -1 ) + 1;
      T maxValue = getHighestPriority();
      for (int i = firstLeafNode; i < size; i++) {
        if (getValue(i).compareTo(maxValue) > 0) {
          maxValue = getValue(i);
        }
      }
      return maxValue;
    }
  }

  T getMinValue() {
    if (isEmpty()) {
      throw new HeapEmptyException();
    }
    if (heapNature == minHeapNature) {
      return getHighestPriority();
    } else {
      int firstLeafNode = parent(size - 1) + 1;
      T minValue = getHighestPriority();
      for(int i = firstLeafNode; i < size; i++){
        if(getValue(i).compareTo(minValue) < 0){
          minValue = getValue(i);
        }
      }
      return minValue;
    }
  }


  void heapify() {
    for (int i = data.length - 1; i >= 0; i--) {
      siftDown(parent(i));
    }
  }

  int left(int currentIndex) {
    int leftChildIndex = (currentIndex * 2) + 1;
    return leftChildIndex >= size ? -1 : leftChildIndex;
  }

  int right(int currentIndex) {
    int rightChildIndex = (currentIndex * 2) + 2;
    return rightChildIndex >= size ? -1 : rightChildIndex;
  }

  int parent(int currentIndex) {
    if (currentIndex < 0 || currentIndex > size) {
      return -1;
    }
    return (currentIndex - 1) / 2;
  }

  void swap(int i, int j) {
    T value = data[i];
    data[i] = data[j];
    data[j] = value;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == data.length;
  }

  T getValue(int index) {
    return data[index];
  }

  public void siftUp(int childIndex) {
    int parentIndex = parent(childIndex);
    if (parentIndex == -1) {
      return;
    }
    if (heapNature.test(parentIndex, childIndex)) {
      swap(parentIndex, childIndex);
      siftUp(parentIndex);
    }
    return;
  }

  public void siftDown(int parentIndex) {
    int leftChildIndex = left(parentIndex);
    int rightChildIndex = right(parentIndex);
    int childIndex = -1;

    if (leftChildIndex != -1 && rightChildIndex != -1) {
      childIndex = heapNature.test(rightChildIndex, leftChildIndex)
          ? leftChildIndex : rightChildIndex;
    } else if (leftChildIndex != -1) {
      childIndex = leftChildIndex;
    } else if (rightChildIndex != -1) {
      childIndex = rightChildIndex;
    }

    if (childIndex == -1) {
      return;
    }

    if (heapNature.test(parentIndex, childIndex)) {
      swap(parentIndex, childIndex);
      siftDown(childIndex);
    }
    return;
  }

  public void insert(T value) {
    if (isFull()) {
      throw new HeapFullException();
    }
    data[size] = value;
    siftUp(size);
    size++;
  }

  public T remove() {
    T value = getHighestPriority();
    data[0] = getValue(size - 1);
    size--;
    siftDown(0);
    return value;
  }

  public T getHighestPriority() {
    if (isEmpty()) {
      throw new HeapEmptyException();
    }
    T value = getValue(0);
    return value;
  }

  public T[] cloneData(){
    return Arrays.copyOf(data, data.length);
  }


}
