package chapter_heap;

/**
 * 查找数据中第K个最大的元素，数组是从大到小排序，元素中数据可以重复
 *
 * @Author: wangfan
 * @name: Solution
 * @Date: 2026/10/8
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 构建一个k的size的小顶堆，从大到小排序，就是获取顶堆中的最小一个。
        return buildMinHeap(nums, k)[0];
    }

    /** 构建一个size为k的小顶堆，从大到小排序，就是获取顶堆中的最小一个。 */
    public int[] buildMinHeap(int[] nums, int k) {
        int[] heap = new int[k];
        // 遍历整个nums数组，数据放入堆中
        for (int i = 0; i < nums.length; i++) {
            // 构建小顶堆
            push(heap, nums, i);
        }
        return heap;
    }

    public void push(int[] heap, int[] nums, int index) {
        // 判断堆是否已经满了
        if (index >= heap.length) {
            // 自顶向下进行堆化
            // 如果堆顶元素小于要插入的元素，弹出堆顶元素，插入新元素
            if (nums[index] > heap[0]) {
                heap[0] = nums[index];
                // 进行堆化
                siftDown(heap, 0);
            }
        }
        // 堆没有满则需要将数据入堆然后进行堆化
        else {
            // 将数据插入堆的末尾
            heap[index] = nums[index];
            // 进行自底部向顶堆化
            siftUp(heap, index);
        }
    }

    /** * 自顶向下进行堆化 */
    public void siftDown(int[] heap, int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;
            if (leftChild < heap.length && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }
            if (rightChild < heap.length && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }
            if (smallest == index){
                return;
            }
            swap(heap, smallest, index);
            index = smallest;
        }
    }

    /** * 自底部向顶进行堆化 */
    public void siftUp(int[] heap, int index) {
        int n = index;
        // 自底部向顶进行堆化
        while (true) {
            // 获取父节点的索引
            int parent = (n - 1) / 2;
            if (parent < 0 || (heap[n] >= heap[parent])) {
                break;
            }
            swap(heap, parent, n);
            n = parent;
        }
    }

    public void swap(int[] heap, int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7,6,5,4,3,2,1};
        int k = 5;
        Solution solution = new Solution();
        int[] result = solution.buildMinHeap(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
