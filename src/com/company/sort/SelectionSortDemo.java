package com.company.sort;

public class SelectionSortDemo {

    public static void selectionSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int min = arr[j];
            int m = j;
            for (; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    m = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[m] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 7, 6, 9, 2, 1, 8, 5, 0 };
        BubbleSortDemo.printArr(arr);
        selectionSort(arr);
        BubbleSortDemo.printArr(arr);
    }

}
