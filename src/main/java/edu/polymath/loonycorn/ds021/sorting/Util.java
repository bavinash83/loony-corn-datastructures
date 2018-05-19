package edu.polymath.loonycorn.ds021.sorting;

import java.util.Arrays;

public interface Util {

  static void swap(int[] array, int iIndex, int jIndex) {
    int temp = array[iIndex];
    array[iIndex] = array[jIndex];
    array[jIndex] = temp;
  }

  static void print(int[] array) {
    System.out.println(Arrays.toString(array));
  }
}
