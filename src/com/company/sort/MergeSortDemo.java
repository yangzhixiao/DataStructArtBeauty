package com.company.sort;

/**
 * 归并排序
 */
public class MergeSortDemo {

    public static void mergeSort(int[] arr, int p, int r) {

        // 当前片段总数
        int n = r - p + 1;

        if (n <= 1) {
            return;
        }

        if (n == 2) {
            if (arr[r] < arr[p]) {
                int temp = arr[r];
                arr[r] = arr[p];
                arr[p] = temp;
            }
            return;
        }

        // 分割点
        int q = p + n / 2;

        mergeSort(arr, p, q - 1);
        mergeSort(arr, q, r);

        int[] temp = new int[n];

        int i = p, j = q, k = 0;
        while (k < n) {
            // 左边已经没有元素，之间拷贝右边
            if (i > q - 1) {
                temp[k] = arr[j++];
                k++;
                continue;
            }
            // 右边已经没有元素，之间拷贝左边
            if (j > r) {
                temp[k] = arr[i++];
                k++;
                continue;
            }
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        // 复制到原来p到r之间
        for (int index = 0; index < n; index++) {
            arr[p + index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 7, 6, 9, 2, 1, 8, 5, 0 };
        BubbleSortDemo.printArr(arr);
        mergeSort(arr, 0, arr.length - 1);
        BubbleSortDemo.printArr(arr);
    }

}
