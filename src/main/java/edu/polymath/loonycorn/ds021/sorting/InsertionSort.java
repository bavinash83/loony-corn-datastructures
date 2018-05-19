package edu.polymath.loonycorn.ds021.sorting;

public interface InsertionSort {

  static int[] sort(int[] input) {
    int swaps = 0;
    for (int i = 1; i < input.length; i++) {
      for (int j = i; j > 0; j--) {
        if (input[j] < input[j - 1]) {
          Util.swap(input, j, j - 1);
          swaps++;
        } else {
          break;
        }
      }
      Util.print(input);
    }
    System.out.println("[Insertion sort] ["+swaps+"]");
    return input;
  }
}
