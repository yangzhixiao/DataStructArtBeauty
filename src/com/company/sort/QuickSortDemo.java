package com.company.sort;

public class QuickSortDemo {

    public static void quickSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int pivot = a[r];
        int n = r - p + 1;

        int storeIndex = p;
        for (int i = p; i < r; i++) {
            if (a[i] < pivot) {
                int temp = a[i];
                a[i] = a[storeIndex];
                a[storeIndex] = temp;
                storeIndex++;
            }
        }
        int temp = a[storeIndex];
        a[storeIndex] = pivot;
        a[r] = temp;

        quickSort(a, p, storeIndex - 1);
        quickSort(a, storeIndex + 1, r);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 7, 6, 9, 2, 1, 8, 5, 0 };
        BubbleSortDemo.printArr(arr);
        quickSort(arr, 0, arr.length-1);
        BubbleSortDemo.printArr(arr);
    }
}
