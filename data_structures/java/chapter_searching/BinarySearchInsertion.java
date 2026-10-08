package chapter_searching;

/**
 * 二分查找插入点实现
 *
 * @Author: wangfan
 * @name: BinarySearchInsertion
 * @Date: 2026/10/8
 */
public class BinarySearchInsertion {
    /* 二分查找插入点（无重复元素） */
    static int binarySearchInsertionSimple(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target < nums[mid]) {
                // target 在区间 [i, m-1] 中
                j = mid - 1;
            }
            else if (target > nums[mid]) {
                // target 在区间 [m+1, j] 中
                i = mid + 1;
            }
            else {
                return mid;
            }
        }
        // 没有找到target，返回插入点
        return i;
    }

    /* 二分查找插入点（有重复元素） */
    static int binarySearchInsertion(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target < nums[mid]) {
                j = mid - 1;
            }
            else if (target > nums[mid]) {
                i = mid + 1;
            }
            // 有重复的数字，位置在 mid 的左侧
            else {
                j = mid - 1;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        // 无重复元素的数组
        int[] nums = { 1, 3, 6, 8, 12, 15, 23, 26, 31, 35 };
        System.out.println("\n数组 nums = " + java.util.Arrays.toString(nums));
        // 二分查找插入点
        for (int target : new int[] { 6, 9 }) {
            int index = binarySearchInsertionSimple(nums, target);
            System.out.println("元素 " + target + " 的插入点的索引为 " + index);
        }

        // 包含重复元素的数组
        nums = new int[] { 1, 3, 6, 6, 6, 6, 6, 10, 12, 15 };
        System.out.println("\n数组 nums = " + java.util.Arrays.toString(nums));
        // 二分查找插入点
        for (int target : new int[] { 2, 6, 20 }) {
            int index = binarySearchInsertion(nums, target);
            System.out.println("元素 " + target + " 的插入点的索引为 " + index);
        }
    }
}
