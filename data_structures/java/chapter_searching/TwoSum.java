package chapter_searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算数组中是否存在两数之和
 *
 * @Author: wangfan
 * @name: TwoSum
 * @Date: 2026/10/8
 */
public class TwoSum {
    /* 方法一：暴力枚举 */
    static int[] twoSumBruteForce(int[] nums, int target) {
        int size = nums.length;
        // 两层循环，时间复杂度为 O(n^2)
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return new int[0];
    }

    /* 方法二：辅助哈希表 */
    static int[] twoSumHashTable(int[] nums, int target) {
        int size = nums.length;
        // 辅助哈希表，空间复杂度为 O(n)
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < size - 1; i++) {
            if (dic.containsKey(target - nums[i])) {
                return new int[] { dic.get(target - nums[i]), i };
            }
            dic.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = {2, 7, 11, 15};
        int target = 13;

        // ====== Driver Code ======
        // 方法一
        int[] res = twoSumBruteForce(nums, target);
        System.out.println("方法一 res = " + Arrays.toString(res));
        // 方法二
        res = twoSumHashTable(nums, target);
        System.out.println("方法二 res = " + Arrays.toString(res));
    }
}
