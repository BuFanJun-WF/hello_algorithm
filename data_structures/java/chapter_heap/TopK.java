package chapter_heap;

import utils.PrintUtil;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 基于堆查找数组中最大的k个元素
 *
 * @Author: wangfan
 * @name: TopK
 * @Date: 2026/10/8
 */
public class TopK {
    public static Queue<Integer> findTopK(int[] nums, int k) {
        // 初始化小顶堆
        Queue<Integer> heap = new PriorityQueue<>();
        // 将数组的前 k 个元素入堆
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        // 从第 k+1 个元素开始，保持堆的长度为 k
        for (int i = k; i < nums.length; i++) {
            // 若当前元素大于堆顶元素，则将堆顶元素出堆、当前元素入堆
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap;
    }
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int k = 3;
        Queue<Integer> topK = findTopK(nums, k);
        System.out.println("最大的 " + k + " 个元素为");
        PrintUtil.printHeap(topK);
    }
}
