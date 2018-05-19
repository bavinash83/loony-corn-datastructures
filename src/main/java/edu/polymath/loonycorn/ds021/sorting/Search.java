package edu.polymath.loonycorn.ds021.sorting;

public interface Search {
  static int findIndex(int[] sortedInput, int value){
    return findIndex(sortedInput, value, 0, sortedInput.length-1);
  }

  static int findIndex(int[] sortedInput, int value, int start, int end){
    if(start == end) return value == sortedInput[start] ? start : -1;
    int middleIndex = (start+end)/2;
    int middleValue = sortedInput[middleIndex];
    if(value == middleValue) return middleIndex;
    else if(value < middleValue) return findIndex(sortedInput, value, start, middleIndex-1);
    else if(value > middleValue) return findIndex(sortedInput, value, middleIndex+1, end);
    else return -1;
  }
}
