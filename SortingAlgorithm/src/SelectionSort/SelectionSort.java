package SelectionSort;

import BubbleSort.BubbleSort;

import java.util.Arrays;

public class SelectionSort {
    public void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            int min_idx = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] < arr[min_idx]){
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,5,9,6,3,1};
        System.out.println ( "Array is " + Arrays.toString ( arr ) );
        SelectionSort ss = new SelectionSort ();
        ss.selectionSort(arr);
        System.out.println ("Sorted Array is " + Arrays.toString ( arr ));
    }

}
