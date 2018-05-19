package edu.polymath.loonycorn.ds021.sorting;

public interface QuickSort {

  static int[] sort(int[] input){
    quickSort(input, 0, input.length-1);
    return input;
  }

  static void quickSort(int[] input, int low, int high){
    if(low>high)return;
    int pivotIndex = partision(input, low, high);
    quickSort(input, low, pivotIndex-1);
    quickSort(input, pivotIndex+1, high);
  }

  static int partision(int[] input,final int low,final int high){
    int pivot = input[low];
    int l = low;
    int h = high;
    while(l < h){
      while(input[l] <= pivot && l<h){
        l++;
      }
      while(input[h] > pivot){
        h--;
      }
      if(l < h){
        Util.swap(input, l, h);
      }
    }
    Util.swap(input, low, h);
    System.out.print(pivot + "  --  " );
    Util.print(input);
    return h;
  }

}
