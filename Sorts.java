import java.util.*;

public class Sorts
{
  public void bubbleSort(int[] list)
  {
    //your code here
    for (int outer = 0; outer < list.length - 1; outer++)
    {
      for (int inner = 0; inner < list.length-outer-1; inner++)
      {
        if (list[inner] > list[inner + 1])
        {
          //swap list[inner] & list[inner+1]
          int temp = list[inner];
          list[inner] = list[inner + 1];
          list[inner + 1] = temp;
        }
      }
    }
  }

  public void selectionSort(int[] list)
  {
    //your code here
    int flag, temp;
    for(int outer =0; outer <list.length-1; outer++)
    {
      flag = outer;
      for(int inner = outer+1; inner < list.length; inner++)
      {
        if(list[inner] < list[flag])
        {
          flag = inner;
        }
      }
      temp = list[outer];
      list[outer] = list[flag];
      list[flag] = temp;
    }
  }

  public void insertionSort(int[] list)
  {
    //your code here
    for (int outer = 1; outer < list.length; outer++)
    {
      int position = outer;
      int key = list[position];
      // Shift larger values to the right
      while (position > 0 && list[position - 1] > key)
        {
          list[position] = list[position - 1];
          position--;
        }
      list[position] = key;
    }
  }

  private void merge(int[] a, int first, int mid, int last)
  {
    //your code here
    int [] temp = new int[a.length];
    mid = (first+last)/2;
    int nA = first;
    int nB = mid +1;
    for(int i = first; i<= last; i++)
    {
      if(nA > mid)
      {
        temp[i] = a[nB];
        nB++;
      }
      else if(nB > last)
      {
        temp[i] = a[nA];
        nA++;
      }
      else if(a[nA] > a[nB])
      {
        temp[i] = a[nB];
        nB++;
      }
      else
      {
        temp[i] = a[nA];
        nA++;
      }
    }
    for(int i = first; i<= last; i++)
    {
      a[i] = temp[i];
    }
  }

  public void mergeSort(int[] a, int first, int last)
  {
    int middle = first + (last - first) / 2;
    if(first < last)
     {
        mergeSort(a, first, middle); //fist half
        mergeSort(a, middle+1, last); //second half
     } 
     merge(a, first, middle+1 , last);
  }
}

