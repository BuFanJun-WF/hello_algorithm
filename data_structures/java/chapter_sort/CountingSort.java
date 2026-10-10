package chapter_sort;

import java.util.Arrays;

/**
 * 计数排序
 * 前缀和表示“小于等于当前数字的元素总数”
 * @Author: wangfan
 * @name: CountingSort
 * @Date: 2026/10/9
 */
public class CountingSort {
    /* 计数排序 */
    // 简单实现，无法用于排序对象
    public static void countingSortNaive(int[] nums) {
        // 1.统计数组最大的元素m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }

        // 2.统计各个数字出现的次数
        // counter[i] 表示数字 i 出现的次数
        int[] count = new int[m + 1];
        for (int num : nums) {
            count[num]++;
        }

        // 3.遍历counter,将各个元素填入原来的nums中
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = count[i]; j > 0; j--, index++) {
                nums[index] = i;
            }
        }
    }

    /* 计数排序 */
    // 完整实现，可排序对象，并且是稳定排序
    public static void countingSort(int[] nums) {
        // 1.统计数组最大的元素m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }

        // 2.统计各个数字出现的次数
        // counter[i] 表示数字 i 出现的次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }

        // 3.求前缀和，将‘出现次数’转化为该数组出现的最后位置的索引
        // 也就是counter[i] - 1表示数字 i 出现的最后位置的索引
        for (int i = 1; i <= m; i++) {
            counter[i] = counter[i] + counter[i-1];
        }

        // 4.倒序遍历原始数组nums,将元素填入正确的位置
        // 倒序是为了保证排序的稳定性
        int n = nums.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // 获取对应的元素
            int num = nums[i];
            // 获取的索引
            int lastestIndex = counter[num] - 1;
            // 将 num 放置到对应索引处
            result[lastestIndex] = num;
            // 令前缀和自减 1 ，得到下次放置 num 的索引
            counter[num]--;
        }

        // 使用结果数组 res 覆盖原数组 nums
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 2, 0, 4, 0, 2, 2, 4 };
        countingSortNaive(nums);
        System.out.println("计数排序（无法排序对象）完成后 nums = " + Arrays.toString(nums));

        int[] nums1 = { 1, 0, 1, 2, 0, 4, 0, 2, 2, 4 };
        countingSort(nums1);
        System.out.println("计数排序完成后 nums1 = " + Arrays.toString(nums1));
    }
}
