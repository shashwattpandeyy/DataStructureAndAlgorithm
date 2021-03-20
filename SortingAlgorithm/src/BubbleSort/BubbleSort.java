package BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0;  j < arr.length - i -1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,9,6,3,1};
        System.out.println ( "Array is " + Arrays.toString ( arr ) );
        BubbleSort bs = new BubbleSort ();
        bs.bubbleSort (arr);
        System.out.println ("Sorted Array is " + Arrays.toString ( arr ));

    }
}
