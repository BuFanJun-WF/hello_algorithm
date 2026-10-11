package chapter_divide_and_conquer;

import com.sun.tools.javac.Main;

import java.text.DateFormatSymbols;

/**
 * 二分查找递归的写法
 *
 * @Author: wangfan
 * @name: BinarySearchRecur
 * @Date: 2026/10/10
 */
public class BinarySearchRecur {

    public static int dfs(int[] nums, int target, int left, int right) {
        // 如果区间为空，则代表没有找到目标元素，则返回-1
        if (left > right) {
            return -1;
        }
        // 计算中间值位置
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] < target) {
            return dfs(nums, target, mid + 1, right);
        }
        else {
            return dfs(nums, target, left, mid - 1);
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        // 求解问题f(n-1)
        return dfs(nums, target, 0, n - 1);
    }

    public static void main(String[] args) {
        int target = 6;
        int[] nums = { 1, 3, 6, 8, 12, 15, 23, 26, 31, 35 };

        // 二分查找（双闭区间）
        int index = binarySearch(nums, target);
        System.out.println("目标元素 6 的索引 = " + index);
    }
}
