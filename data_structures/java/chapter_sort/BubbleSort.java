package chapter_sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @Author: wangfan
 * @name: BubbleSort
 * @Date: 2026/10/9
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        // 外循环：未排序的区间是[0,i)
        for(int i = arr.length - 1; i >0; i--) {
            // 内循环：比较相邻的元素并交换位置
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortWithFlag(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
            // 如果没有发生交换，说明数组已经有序，提前退出
            if (flag == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 1, 5, 2 };
        bubbleSort(nums);
        System.out.println("冒泡排序完成后 nums = " + Arrays.toString(nums));

        int[] nums1 = { 4, 1, 3, 1, 5, 2 };
        bubbleSortWithFlag(nums1);
        System.out.println("冒泡排序完成后 nums1 = " + Arrays.toString(nums1));
    }
}
