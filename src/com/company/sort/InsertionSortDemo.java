package com.company.sort;

public class InsertionSortDemo {

    public static void insertionSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (;j >= 0; j--) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 7, 6, 9, 2, 1, 8, 5, 0 };
        BubbleSortDemo.printArr(arr);
        insertionSort(arr);
        BubbleSortDemo.printArr(arr);
    }

}
