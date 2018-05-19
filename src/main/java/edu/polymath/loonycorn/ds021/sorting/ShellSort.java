package edu.polymath.loonycorn.ds021.sorting;

public interface ShellSort {

  static int[] sort(int[] input) {
    final int maxPartitions = input.length / 2;
    int swaps = 0;
    for (int increment = maxPartitions; increment > 0; increment = increment /2) {
      for (int startIndex = 0; startIndex < increment; startIndex++) {
        swaps = insertionSort(input, swaps, increment, startIndex);
      }
    }
    System.out.println("[Shell sort] ["+swaps+"]");
    return input;
  }

  static int insertionSort(int[] input, int swaps, int increment, int startIndex) {
    for (int i = startIndex; i < input.length; i = i + increment) {
      for (int j = i + increment; j - increment >= 0 && j < input.length; j = j - increment) {
        if (input[j] < input[j - increment]) {
          Util.swap(input, j, j - increment);
          swaps++;
        } else {
          break;
        }
      }
      Util.print(input);
    }
    return swaps;
  }
}
