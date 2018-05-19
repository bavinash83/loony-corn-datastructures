package edu.polymath.loonycorn.ds021.sorting;

import java.util.Arrays;

public interface MergeSort {


  static int[] sort(int[] input){
    if(input.length == 1){
      return input;
    }
    else{
      int[][] splitted = split(input);
      int[] first = sort(splitted[0]);
      int[] second = sort(splitted[1]);
      int[] merged = merge(first, second);
      return merged;
    }
  }

  static int[] merge(int[] first, int[] second) {
    int[] merged = new int[first.length + second.length];
    int firstIndex = 0;
    int secondIndex = 0;
    for (int i = 0; i < merged.length; i++) {
      if(firstIndex == first.length){
        merged[i] = second[secondIndex];
        secondIndex++;
      }else if(secondIndex == second.length){
        merged[i] = first[firstIndex];
        firstIndex++;
      }else if(first[firstIndex] <= second[secondIndex]){
        merged[i] = first[firstIndex];
        firstIndex++;
      }else{
        merged[i] = second[secondIndex];
        secondIndex++;
      }
    }
    return merged;
  }

  static int[][] split(int[] input) {
    return new int[][]{
        Arrays.copyOfRange(input, 0, input.length / 2),
        Arrays.copyOfRange(input, input.length / 2, input.length)
    };
  }
}
