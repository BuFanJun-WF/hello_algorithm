package chapter_stack_and_queue.queue;

import node.ListNode;

/**
 * 基于链表实现的队列
 *
 * @Author: wangfan
 * @name: LinkedListQueue
 * @Date: 2026/10/3
 */
public class LinkedListQueue {
    private ListNode front, rear;
    private int queueSize = 0;

    public LinkedListQueue() {
        front = rear = null;
    }

    /* 获取队列的长度 */
    public int size() {
        return queueSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return queueSize == 0;
    }

    /* 入队 */
    public void enqueue(int item) {
        // 在尾节点添加num
        ListNode node = new ListNode(item);
        if (front == null) {
            front = rear = node;
        }
        else {
            rear.next = node;
            rear = node;
        }
        queueSize++;
    }

    /* 出队 */
    public int dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        int num = front.value;
        front = front.next;
        queueSize--;
        return num;
    }

    /* 访问队列的头节点 */
    public int front() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        return front.value;
    }

    /* 将链表转化为 Array 并返回 */
    public int[] toArray() {
        ListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.value;
            node = node.next;
        }
        return res;
    }
}
