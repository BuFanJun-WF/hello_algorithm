package chapter_stack_and_queue.deque;

/**
 * 基于环形数组实现的双向队列
 *
 * @Author: wangfan
 * @name: ArrayDeque
 * @Date: 2026/10/3
 */
public class ArrayDeque {
    private int[] nums;
    // 队狩指针，指向队首元素
    private int front;
    private int dequeSize;

    /** 构造方法 */
    public ArrayDeque(int capacity) {
        this.nums = new int[capacity];
        this.front = this.dequeSize = 0;
    }

    /* 获取双向队列的容量 */
    public int getCapacity() {
        return this.nums.length;
    }

    /* 获取双向队列的长度 */
    public int size() {
        return this.dequeSize;
    }

    /* 判断双向队列是否为空 */
    public boolean isEmpty() {
        return this.dequeSize == 0;
    }

    /* 计算环形数组索引 */
    private int index(int i) {
        // 通过取余操作实现数组首尾相连
        // 当 i 越过数组尾部后，回到头部
        // 当 i 越过数组头部后，回到尾部
        return (i + getCapacity()) % getCapacity();
    }

    /* 队首入队 */
    public void pushFront(int value) {
        if (dequeSize == getCapacity()) {
            throw new IndexOutOfBoundsException("Deque is full");
        }
        // 队首指针向前移动一位
        // 通过取余操作实现 front 越过数组头部后回到尾部
        front = index(front - 1);

        // 将value添加到队首
        nums[front] = value;
        dequeSize++;
    }

    /* 队尾入队 */
    /* 队首入队 */
    public void pushLast(int value) {
        if (dequeSize == getCapacity()) {
            throw new IndexOutOfBoundsException("Deque is full");
        }
        // 队首指针向后移动一位
        // 通过取余操作实现 front 越过数组头部后回到尾部
        front = index(front + dequeSize);

        // 将value添加到队首
        nums[front] = value;
        dequeSize++;
    }

    /* 队首出队 */
    public int popFront() {
        int num = peekFront();
        front = index(front + 1);
        dequeSize--;
        return num;
    }

    /* 队尾出队 */
    /* 队尾出队 */
    public int popLast() {
        int num = peekLast();
        dequeSize--;
        return num;
    }

    /* 访问队首元素 */
    public int peekFront() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Deque is empty");
        return nums[front];
    }

    /* 访问队尾元素 */
    public int peekLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Deque is empty");
        return nums[index(front + dequeSize - 1)];
    }

    /* 返回数组用于打印 */
    public int[] toArray() {
        // 仅转换有效长度范围内的列表元素
        int[] res = new int[dequeSize];
        for (int i = 0, j = front; i < dequeSize; i++, j++) {
            res[i] = nums[index(j)];
        }
        return res;
    }
}
