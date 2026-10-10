package chapter_sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @Author: wangfan
 * @name: SelectionSort
 * @Date: 2026/10/9
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        // 外循环 未排序区间为[i, arr.length)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 内循环 找到未排序区间中的最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 标记在j到arr.lengthq区间中最小的值的索引
                    minIndex = j;
                }
            }
            // 将该最小元素与未排序区间的首个元素交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 1, 5, 2 };
        selectionSort(nums);
        System.out.println("选择排序完成后 nums = " + Arrays.toString(nums));
    }
}
