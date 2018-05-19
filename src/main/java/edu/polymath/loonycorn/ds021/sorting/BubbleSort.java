package edu.polymath.loonycorn.ds021.sorting;

public interface BubbleSort {

  static int[] sort(int[] input) {
    Util.print(input);
    int swaps = 0;

    for (int i = 0; i < input.length; i++) {
      boolean didSwap = false;
      for (int j = input.length - 1; j > i; j--) {
        if (input[j] < input[j - 1]) {
          didSwap = true;
          Util.swap(input, j, j - 1);
          swaps++;
        }
      }
      Util.print(input);
      if(!didSwap) break;
    }
    System.out.println("[bubble sort] ["+swaps+"]");
    return input;
  }
}
