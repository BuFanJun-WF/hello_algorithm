package chapter_sort;

import java.util.Arrays;

/**
 * 归并排序：归并排序跟二叉树中的后序遍历很相似，对于将两个有序的链表合并成一个大链表有天然优势
 *
 * @Author: wangfan
 * @name: MergeSort
 * @Date: 2026/10/9
 */
public class MergeSort {
    /* 合并左子数组和右子数组 */
    private static void merge(int[] nums, int left, int mid, int right) {
        // 左子数组区间为 [left, mid], 右子数组区间为 [mid+1, right]
        // 创建一个临时数组 tmp ，用于存放合并后的结果
        int[] temp = new int[right - left + 1];
        // 初始化左子数组和右子数组的起始索引
        int i = left, j = mid + 1, k = 0;
        // 合并阶段, 当左右子数组都还有元素时，进行比较并将较小的元素复制到临时数组中
        while(i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
                k++;
            }
            else {
                temp[k] = nums[j];
                j++;
                k++;
            }
        }
        // 当左子数组还有元素时，将它们复制到临时数组中
        while(i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        // 当右子数组还有元素时，将它们复制到临时数组中
        while(j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        // 将临时数组 tmp 中的元素复制回原数组 nums 的对应区间
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    public static void mergeSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) {
            // 当子数组长度为1时终止递归
            return;
        }

        // 划分阶段
        // 计算中点位置
        int mid = left + (right - left) / 2;
        // 递归左子数组
        mergeSort(nums, left, mid);
        // 递归右子数组
        mergeSort(nums, mid + 1, right);
        // 合并阶段
        merge(nums, left, mid, right);
    }


    public static void main(String[] args) {
        /* 归并排序 */
        int[] nums = { 7, 3, 2, 6, 0, 1, 5, 4 };
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("归并排序完成后 nums = " + Arrays.toString(nums));
    }
}
