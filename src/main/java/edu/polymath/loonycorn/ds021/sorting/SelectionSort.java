package edu.polymath.loonycorn.ds021.sorting;

public interface SelectionSort {

  static int[] sort(int[] input) {
    int swaps = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = i + 1; j < input.length; j++) {
        if (input[i] > input[j]) {
          Util.swap(input, i, j);
          Util.print(input);
          swaps++;
        }
      }
    }
    System.out.println("[Selection sort] ["+swaps+"]");
    return input;
  }
}
