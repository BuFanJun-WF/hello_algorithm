package chapter_searching;

/**
 * 二分查找实现
 *
 * @Author: wangfan
 * @name: BinarySearch
 * @Date: 2026/10/8
 */
public class BinarySearch {
    /* 二分查找（双闭区间） */
    static int binarySearch(int[] nums, int target) {
        // 初始化双闭区间 [0, n-1] ，即 i, j 分别指向数组首元素、尾元素
        int i = 0;
        int j = nums.length - 1;
        // 循环，当搜索区间为空时跳出（当 i > j 时为空）
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target < nums[mid]) {
                j = mid - 1;
            }
            else if (target > nums[mid]) {
                i = mid + 1;
            }
            else {
                return mid;
            }
        }
        // 未找到目标元素，返回 -1
        return -1;
    }

    /* 二分查找（左闭右开区间） */
    static int binarySearchLCRO(int[] nums, int target) {
        // 初始化左闭右开区间 [0, n) ，即 i, j 分别指向数组首元素、尾元素+1
        int i = 0, j = nums.length;
        // 循环，当搜索区间为空时跳出（当 i = j 时为空）
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (target < nums[mid]) {
                j = mid;
            }
            else if (target > nums[mid]) {
                i = mid + 1;
            }
            else {
                return mid;
            }
        }
        // 未找到目标元素，返回 -1
        return -1;
    }
    public static void main(String[] args) {
        int target = 6;
        int[] nums = { 1, 3, 6, 8, 12, 15, 23, 26, 31, 35 };

        /* 二分查找（双闭区间） */
        int index = binarySearch(nums, target);
        System.out.println("目标元素 6 的索引 = " + index);

        /* 二分查找（左闭右开区间） */
        index = binarySearchLCRO(nums, target);
        System.out.println("目标元素 6 的索引 = " + index);
    }
}
