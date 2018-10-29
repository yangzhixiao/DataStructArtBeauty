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
        while (start <= end) {
            int mid = (start + end) / 2;
            if (value == a[mid]) {
                return mid;
            }
            if (value < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
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

    /**
     * 寻找第一个等于给定的值
     */
    public static int findFirst(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (value <= a[mid]) {
                if (mid != 0 && a[mid - 1] != value) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找最后一个等于给定的值
     */
    public static int findLast(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (value >= a[mid]) {
                if (mid != a.length - 1 && a[mid + 1] != value) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找第一个大于等于给定的值
     */
    public static int findFirstGreaterEqual(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找最后一个小于等于给定的值
     */
    public static int findLastLessEqual(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] <= value) {
                if (mid == a.length - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        }
        return -1;
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
        System.out.println();

        int[] a2 = new int[]{ 1, 3, 6, 9, 9, 9, 9, 11, 45, 89, 112, 332, 555 };
        System.out.println("第一个：" + findFirst(a2, 9));
        System.out.println("第最后一个：" + findLast(a2, 9));

        System.out.println();
        int[] a3 = new int[]{ 1, 3, 6, 9, 9, 9, 9, 11, 45, 89, 112, 332, 555 };
        System.out.println("第一个大于等于10：" + findFirstGreaterEqual(a3, 10));
        System.out.println("最后一个小等于于40：" + findLastLessEqual(a3, 40));
    }

}
