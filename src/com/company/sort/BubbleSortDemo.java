package com.company.sort;

/**
 * 冒泡排序
 */
public class BubbleSortDemo {

    public static void bubbleSort(int[] arr) {
        if (arr.length == 1) {
            return;
        }

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 7, 6, 9, 2, 1, 8, 5, 0 };
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        System.out.println();

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
