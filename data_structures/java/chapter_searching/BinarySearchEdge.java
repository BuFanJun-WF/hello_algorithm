package chapter_searching;

/**
 * 二分查找左右边界问题实现
 *
 * @Author: wangfan
 * @name: BinarySearchEdge
 * @Date: 2026/10/8
 */
public class BinarySearchEdge {
    /* 二分查找最左一个target */
    static int binarySearchLeftEdge(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            }
            else if (nums[mid] > target) {
                j = mid - 1;
            }
            else {
                j = mid - 1;
            }
        }

        // 未找到 target ，返回 -1
        if (i == nums.length || nums[i] != target) {
            return -1;
        }
        // 找到 target ，返回索引 i
        return i;
    }

    /* 二分查找最右一个target */
    static int binarySearchRightEdge(int[] nums, int target) {
        // 转化为查找最左一个 target + 1
        // j 指向最右一个 target ，i 指向首个大于 target 的元素(因为是int类型，所以有值的话，那就是首个大于 target)
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target + 1) {
                j = mid - 1;
            }
            else if (nums[mid] < target + 1) {
                i = mid + 1;
            }
            else {
                j = mid - 1;
            }
        }

        // 未找到target的话，返回 -1
        if (i - 1 == -1 || nums[i - 1] != target) {
            return -1;
        }

        // 能找到target
        return i - 1;
    }

    public static void main(String[] args) {
        // 包含重复元素的数组
        int[] nums = { 1, 3, 6, 6, 6, 6, 6, 10, 12, 15 };
        System.out.println("\n数组 nums = " + java.util.Arrays.toString(nums));

        // 二分查找左边界和右边界
        for (int target : new int[] { 6, 7 }) {
            int index = binarySearchLeftEdge(nums, target);
            System.out.println("最左一个元素 " + target + " 的索引为 " + index);
            index = binarySearchRightEdge(nums, target);
            System.out.println("最右一个元素 " + target + " 的索引为 " + index);
        }
    }
}
