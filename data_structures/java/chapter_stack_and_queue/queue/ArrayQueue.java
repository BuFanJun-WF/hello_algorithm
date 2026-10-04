package chapter_stack_and_queue.queue;

/**
 * 基于环形数组实现的队列
 *
 * @Author: wangfan
 * @name: ArrayQueue
 * @Date: 2026/10/3
 */
public class ArrayQueue {
    private int[] nums;
    private int front;
    private int queSize;
    public ArrayQueue(int capacity) {
        nums = new int[capacity];
        front = queSize = 0;
    }

    /* 获取队列的容量 */
    public int getCapacity() {
        return nums.length;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return queSize == 0;
    }

    /* 入队 */
    public void enqueue(int value) {
        if (queSize == getCapacity()) {
            throw new RuntimeException("Queue is full");
        }
        // 计算队尾指针，指向队尾索引 + 1
        // 通过取余操作实现 rear 越过数组尾部后回到头部
        int rear = (front + queSize) % getCapacity();
        nums[rear] = value;
        queSize++;
    }

    /* 出队 */
    public int dequeue() {
        int value = nums[front];
        // 队首指针向后移动一位，若越过尾部，则返回到数组头部
        front = (front + 1) % getCapacity();
        queSize--;
        return value;
    }

    /* 访问队首元素 */
    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return nums[front];
    }

    /* 返回数组 */
    public int[] toArray() {
        // 仅转换有效长度范围内的列表元素
        int[] res = new int[queSize];
        for (int i = 0, j = front; i < queSize; i++, j++) {
            res[i] = nums[j % getCapacity()];
        }
        return res;
    }
}
