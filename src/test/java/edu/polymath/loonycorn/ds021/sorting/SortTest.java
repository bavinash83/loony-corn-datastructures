package edu.polymath.loonycorn.ds021.sorting;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class SortTest {

  final int[] inputTemplate = new int[]{
      4, 5, 6, 2, 1, 7, 10, 3, 8, 9
  };

  final int[] desendingTemplate = new int[]{
      10,9,8,7,6,5,4,3,2,1
  };

  final int[] sortedTemplate = new int[]{
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10
  };

  @Test
  public void bubbleSort() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            BubbleSort.sort(Arrays.copyOf(inputTemplate, inputTemplate.length))));

  }

  @Test
  public void bubbleDecendingSort() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            BubbleSort.sort(Arrays.copyOf(desendingTemplate, desendingTemplate.length))));

  }

  @Test
  public void selectionSort() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            SelectionSort.sort(Arrays.copyOf(inputTemplate, inputTemplate.length))));

  }

  @Test
  public void insertionSort() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            InsertionSort.sort(Arrays.copyOf(inputTemplate, inputTemplate.length))));
  }

  @Test
  public void insertsionDecendingSort() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            InsertionSort.sort(Arrays.copyOf(desendingTemplate, desendingTemplate.length))));

  }

  @Test
  public void shellSort() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            ShellSort.sort(Arrays.copyOf(inputTemplate, inputTemplate.length))));
  }

  @Test
  public void shellDecending() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            ShellSort.sort(Arrays.copyOf(desendingTemplate, desendingTemplate.length))));
  }

  @Test
  public void mergeSort() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            MergeSort.sort(Arrays.copyOf(inputTemplate, inputTemplate.length))));
  }

  @Test
  public void mergeDecending() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            MergeSort.sort(Arrays.copyOf(desendingTemplate, desendingTemplate.length))));
  }

  @Test
  public void quickSort() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            QuickSort.sort(Arrays.copyOf(inputTemplate, inputTemplate.length))));
  }

  @Test
  public void quickDecending() throws Exception {
    Assert.assertTrue(
        Arrays.equals(sortedTemplate,
            QuickSort.sort(Arrays.copyOf(desendingTemplate, desendingTemplate.length))));
  }

  @Test
  public void search(){
    for(int i=0;i<sortedTemplate.length;i++){
      Assert.assertEquals(i, Search.findIndex(sortedTemplate, sortedTemplate[i]));
    }

    for(int i=0;i<50;i++){
      Double value;
      do{
        value = Math.random()*100;
      }while(value<11);
      Assert.assertEquals(-1, Search.findIndex(sortedTemplate, value.intValue()));
    }
  }
}