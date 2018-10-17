package com.company.sort;

/**
 * 归并排序
 */
public class MergeSortDemo {

    public static int[] mergeSort(int[] arr, int q, int r) {

        // 当前片段总数
        int n = r - q + 1;

        if (n <= 1) {
            return new int[] { arr[q] };
        }

        if (n == 2) {
            if (arr[r] < arr[q]) {
                return new int[] { arr[r], arr[q] };
            } else {
                return new int[] { arr[q], arr[r] };
            }
        }

        // 分割点
        int m = n / 2;

        int[] arrLeft = mergeSort(arr, q, q + m - 1);
        int[] arrRight = mergeSort(arr, q + m, r);

        int[] temp = new int[n];

        int i = 0, j = 0, k = 0;
        while (k < n) {
            if (i == arrLeft.length) {
                temp[k] = arrRight[j];
                j++;
                k++;
                continue;
            }
            if (j == arrRight.length) {
                temp[k] = arrLeft[i];
                i++;
                k++;
                continue;
            }
            if (arrLeft[i] < arrRight[j]) {
                temp[k] = arrLeft[i];
                i++;
                k++;
            } else {
                temp[k] = arrRight[j];
                j++;
                k++;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 7, 6, 9, 2, 1, 8, 5, 0 };
        BubbleSortDemo.printArr(arr);
        arr = mergeSort(arr, 0, arr.length - 1);
        BubbleSortDemo.printArr(arr);
    }

}
