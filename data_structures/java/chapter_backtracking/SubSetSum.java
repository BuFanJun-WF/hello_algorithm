package chapter_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给一个目标元素，找出组合中的元素和等于target的子集
 *
 * @Author: wangfan
 * @name: SubSetSum
 * @Date: 2026/10/11
 */
public class SubSetSum {
    /**
     * 回溯法：求解子集的和,数组中是有重复元素的
     * @param track 路径
     * @param target 目标值
     * @param nums 候选集
     * @param start 遍历起始点
     * @param res 结果列表
     */
    private static void backtrackII(List<Integer> track, int target, int[] nums, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        // 剪枝三：从 start 开始遍历，避免重复选择同一元素
        for (int i = start; i < nums.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - nums[i] < 0) {
                break;
            }
            // 剪枝四：如果该元素与左边元素相等，说明该搜索分支重复，直接跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 尝试：做出选择，更新 target, start
            track.add(nums[i]);
            // 进行下一轮选择
            backtrackII(track, target - nums[i], nums, i + 1, res);
            // 回退：撤销选择，恢复到之前的状态
            track.remove(track.size() - 1);
        }
    }

    /**
     * 回溯法：求解子集的和
     * @param track 路径
     * @param target 目标值
     * @param nums 候选集
     * @param start 遍历起始点
     * @param res 结果列表
     */
    private static void backtrackI(List<Integer> track, int target, int[] nums, int start, List<List<Integer>> res) {
        // 子集和等于target时，记录值
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }

        // 遍历所有的选择
        // 剪枝：从start开始遍历，避免生成重复子集
        for (int i = start; i < nums.length; i++) {
            // 剪枝：如果子集和超过了target，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - nums[i] < 0) {
                break;
            }

            // 尝试：做出选择更新状态，更新target，start
            track.add(nums[i]);
            // 进行下一轮的选择
            backtrackI(track, target - nums[i], nums, i + 1, res);
            // 回退：撤销选择，恢复到之前的状态
            track.remove(track.size() - 1);
        }
    }


    /**
     * 求解子集的和
     * 数组中无重复的元素，每个元素可以多次选取
     * @param nums 候选集
     * @param target 目标值
     * @return 所有和等于target的子集
     */
    public static List<List<Integer>> subsetSumI(int[] nums, int target) {
        // 路径组合的子集
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums); // 对 nums 进行排序
        int start = 0; // 遍历起始点
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrackI(track, target, nums, start, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5 };
        int target = 9;

        List<List<Integer>> res = subsetSumI(nums, target);

        System.out.println("输入数组 nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("所有和等于 " + target + " 的子集 res = " + res);
    }
}
