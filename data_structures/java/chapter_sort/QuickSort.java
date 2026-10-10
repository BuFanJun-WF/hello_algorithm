package chapter_sort;

import java.util.Arrays;

/**
 * 快速排序：分治的方法
 *
 * @Author: wangfan
 * @name: QuickSort
 * @Date: 2026/10/9
 */
public class QuickSort {
    /* 元素交换 */
    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /** 哨兵基准数划分 */
    public static int partition(int[] nums, int left, int right) {
        // 以nums[left]为基准树
        int i = left;
        int j = right;
        while (i < j) {
            // 从右向左找首个小于基准数的元素
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            // 从左向右找首个大于基准数的元素
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        // 此时，i==j,将基准数交换至两子数组的分界线
        swap(nums, i, left);
        return i;
    }

    public static void quickSort(int[] nums, int left, int right) {
        // 子数组长度为 1 时终止递归
        if (left >= right) {
            return;
        }
        // 哨兵划分
        int pivot = partition(nums, left, right);
        // 递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /* 选取三个候选元素的中位数 */
    static int medianThree(int[] nums, int left, int mid, int right) {
        int l = nums[left], m = nums[mid], r = nums[right];
        // m 在 l 和 r 之间
        if (((l <= m) && (m <= r)) || (r <= m && m <= l) ) {
            return mid;
        }
        // l 在 m 和 r 之间
        if ((m <= l && l <= r) || (r <= l && l <= m)) {
            return left;
        }
        return right;
    }
    /* 中位基准数优化 */
    public static int partitionMedian(int[] nums, int left, int right) {
        // 获取三个候选元素的中位数
        int mid = medianThree(nums, left, (left + (right - left) / 2), right);
        // 将中位数交换到数组最左端
        swap(nums, left, mid);
        return partition(nums, left, right);
    }

    public static void quickSortMedian(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 获取哨兵分划
        int pivot = partitionMedian(nums, left, right);
        quickSortMedian(nums, left, pivot - 1);
        quickSortMedian(nums, pivot + 1, right);
    }

    /* 快速排序（递归深度优化） */
    public static void quickSortTailCall(int[] nums, int left, int right) {
        // 子树组长度为1时终止
        while (left < right) {
            // 获取哨兵分划
            int pivot = partitionMedian(nums, left, right);
            // 对两个子数组中较短的那个执行快速排序
            if (pivot - left < right - pivot) {
                // 递归排序左子数组
                quickSortTailCall(nums, left, pivot - 1);
                // 剩余未排序区间为 [pivot + 1, right]
                left = pivot + 1;
            }
            else {
                // 递归排序右子数组
                quickSortTailCall(nums, pivot + 1, right);
                // 剩余未排序区间为 [left, pivot - 1]
                right = pivot - 1;
            }
        }
    }

    public static void main(String[] args) {
        /* 快速排序 */
        int[] nums = { 2, 4, 1, 0, 3, 5 };
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序完成后 nums = " + Arrays.toString(nums));

        /* 快速排序（中位基准数优化） */
        int[] nums1 = { 2, 4, 1, 0, 3, 5 };
        quickSortMedian(nums1, 0, nums1.length - 1);
        System.out.println("快速排序（中位基准数优化）完成后 nums1 = " + Arrays.toString(nums1));

        /* 快速排序（递归深度优化） */
        int[] nums2 = { 2, 4, 1, 0, 3, 5 };
        quickSortTailCall(nums2, 0, nums2.length - 1);
        System.out.println("快速排序（递归深度优化）完成后 nums2 = " + Arrays.toString(nums2));
    }
}
