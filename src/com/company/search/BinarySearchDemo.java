package com.company.search;

/**
 * 二分查找法
 */
public class BinarySearchDemo {

    /**
     * 循环实现
     */
    public static int binarySearch(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (value == a[mid]) {
                return mid;
            }
            if (start == end) {
                return -1;
            }
            if (value < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }

    /**
     * 递归实现
     */
    public static int binarySearch2(int[] a, int start, int end, int value) {
        int mid = (start + end) / 2;
        if (a[mid] == value) {
            return mid;
        }
        if (start == end) {
            return -1;
        }
        if (value > a[mid]) {
            return binarySearch2(a, mid + 1, end, value);
        } else {
            return binarySearch2(a, start, mid - 1, value);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 1, 3, 6, 9, 11, 45, 89, 112, 332, 555 };
        System.out.println(binarySearch(a, 3));
        System.out.println(binarySearch(a, 45));
        System.out.println(binarySearch(a, 112));
        System.out.println(binarySearch(a, 99));
        System.out.println();
        System.out.println(binarySearch2(a, 0, a.length - 1, 3));
        System.out.println(binarySearch2(a, 0, a.length - 1, 45));
        System.out.println(binarySearch2(a, 0, a.length - 1, 112));
        System.out.println(binarySearch2(a, 0, a.length - 1, 99));
    }

}
