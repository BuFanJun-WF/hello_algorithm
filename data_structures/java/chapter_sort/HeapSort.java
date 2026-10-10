package chapter_sort;

import java.util.Arrays;

/**
 * 堆排序：构建一个大顶堆，将堆顶元素跟最后一个元素进行交换，然后忽略最后一个元素，再顶向下进行堆化
 *
 * @Author: wangfan
 * @name: HeapSort
 * @Date: 2026/10/9
 */
public class HeapSort {
    /* 堆的长度为n，从节点i开始，从顶至底进行堆化 */
    public static void siftDown(int[] nums, int n, int i) {
        while (true) {
            // 判断节点i, l, r中的值最大节点，记为max
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            int max = i;
            if (l < n && nums[l] > nums[max]) {
                max = l;
            }
            if (r < n && nums[r] > nums[max]) {
                max = r;
            }

            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (max == i)
                break;

            // 交换两个节点
            int temp = nums[max];
            nums[max] = nums[i];
            nums[i] = temp;

            // 然后再循环向下堆化
            i = max;
        }
    }

    public static void heapSort(int[] nums) {
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = nums.length / 2 -1; i>=0; i--) {
            siftDown(nums, nums.length, i);
        }

        // 从堆中提取最大的元素，放到末尾，然后循环n-1轮
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 以根节点为起点，从顶到底进行堆化
            siftDown(nums, i, 0);
        }
    }


    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 1, 5, 2 };
        heapSort(nums);
        System.out.println("堆排序完成后 nums = " + Arrays.toString(nums));
    }
}
