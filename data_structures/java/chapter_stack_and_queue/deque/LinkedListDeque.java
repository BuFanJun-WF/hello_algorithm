package chapter_stack_and_queue.deque;

import node.ListNode;

/**
 * 基于双向链表实现的双向队列
 *
 * @Author: wangfan
 * @name: LinkedListDeque
 * @Date: 2026/10/3
 */
public class LinkedListDeque {
    private ListNode front, rear;
    private int dequeSize = 0;
    public LinkedListDeque() {
        front = rear = null;
    }

    /* 获取双向队列的长度 */
    public int getDequeSize() {
        return dequeSize;
    }

    /* 判断双向队列是否为空 */
    public boolean isEmpty() {
        return dequeSize == 0;
    }

    /* 入队 */
    public void enqueue(int value, boolean isFront) {
        ListNode newNode = new ListNode(value);
        // 队列为空就要直接插入
        if (isEmpty()) {
            front = rear = newNode;
        }
        // 队列头部插入
        else if (isFront) {
            // 将节点添加到链表头部
            front.prev = newNode;
            newNode.next = front;
            front = newNode;
        }
        // 队列尾部插入
        else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        dequeSize++;
    }

    /* 队首入队 */
    public void pushFirst(int num) {
        enqueue(num, true);
    }

    /* 队尾入队 */
    public void pushLast(int num) {
        enqueue(num, false);
    }

    /* 出队 */
    public int dequeue(boolean isFront) {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }

        int value;
        if (isFront) {
            value = front.value;
            // 删除头节点
            if (front.next != null) {
                front = front.next;
                front.prev = null;
            }
        }
        else {
            value = rear.value;
            if (rear.prev != null) {
                rear = rear.prev;
                rear.next = null;
            }
        }
        dequeSize--;
        return value;
    }

    /* 队首出队 */
    public int popFirst() {
        return dequeue(true);
    }

    /* 队尾出队 */
    public int popLast() {
        return dequeue(false);
    }

    /* 访问队首元素 */
    public int peekFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return front.value;
    }

    /* 访问队尾元素 */
    public int peekLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return rear.value;
    }

    /* 返回数组用于打印 */
    public int[] toArray() {
        ListNode node = front;
        int[] res = new int[getDequeSize()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.value;
            node = node.next;
        }
        return res;
    }
}
