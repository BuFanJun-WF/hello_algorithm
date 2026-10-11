package chapter_backtracking;

import java.util.*;

/**
 * 全排列问题：第一种为无重复元素，第二种为有重复元素
 * 表示找出其中元素的所有可能的排列组合
 * @Author: wangfan
 * @name: Permutations
 * @Date: 2026/10/11
 */
public class Permutations {

    /**
     * 全排列II：有重复元素
     * 表示找出其中元素的所有可能的排列组合
     * @param track 当前路径
     * @param nums 候选集
     * @param used 剪枝标志
     * @param result 记录结果
     */
    public static void backTrackII(List<Integer> track, int[] nums, boolean[] used, List<List<Integer>> result) {
        // 判断当前路径下的长度是否等于元素的个数，等于则记录解
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        // 遍历所有的元素
        Set<Integer> duplicated = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int choice = track.get(i);
            // 剪枝：不允许重复选择元素 并且 不允许重复选择相等的元素
            if (!used[i] && !duplicated.contains(choice)) {
                // 尝试：做出选择更新状态
                // 记录选择过的元素值
                duplicated.add(choice);
                used[i] = true;
                track.add(choice);

                // 进行下一轮的选择
                backTrackI(track, nums, used, result);

                // 回退：撤销选择，恢复到之前的状态
                used[i] = false;
                track.remove(track.size() - 1);
            }
        }
    }

    /**
     * 全排列I：无重复元素
     * 表示找出其中元素的所有可能的排列组合
     * @param track 当前路径
     * @param nums 候选集
     * @param used 剪枝标志
     * @param result 记录结果
     */
    public static void backTrackI(List<Integer> track, int[] nums, boolean[] used, List<List<Integer>> result) {
        // 判断当前路径下的长度是否等于元素的个数，等于则记录解
        if (track.size() == nums.length) {
            result.add(new ArrayList<Integer>(track));
            return;
        }

        // 遍历所有的元素
        for (int i = 0; i < nums.length; i++) {
            int choice = nums[i];
            // 剪枝：不允许重复选择元素
            if (!used[i]) {
                // 尝试：做出选择更新状态
                used[i] = true;
                track.add(choice);

                // 进行下一轮的选择
                backTrackI(track, nums, used, result);

                // 回退：撤销选择，恢复到之前的状态
                used[i] = false;
                track.remove(track.size() - 1);
            }
        }
    }


    /** 全排列I：无重复元素 */
    public static List<List<Integer>> permutationsI(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrackI(new ArrayList<Integer>(), nums, new boolean[nums.length], result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        List<List<Integer>> res = permutationsI(nums);

        System.out.println("输入数组 nums = " + Arrays.toString(nums));
        System.out.println("所有排列 res = " + res);
    }
}
