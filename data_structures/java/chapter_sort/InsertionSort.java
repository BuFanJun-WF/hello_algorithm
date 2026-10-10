package chapter_sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @Author: wangfan
 * @name: InsertionSort
 * @Date: 2026/10/9
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        // 外循环：已排序区间为 [0, i-1]
        for (int i = 1; i < arr.length; i++) {
            int base = arr[i];
            int j = i - 1;
            // 内循环：将 base 插入到已排序区间 [0, i-1] 中的正确位置
            while (j >= 0 && arr[j] > base) {
                // 将 nums[j] 向右移动一位
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = base;
        }
    }
    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 1, 5, 2 };
        insertionSort(nums);
        System.out.println("插入排序完成后 nums = " + Arrays.toString(nums));
    }
}
