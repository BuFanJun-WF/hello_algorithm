package chapter_stack_and_queue.stack;

import node.ListNode;

import java.util.NoSuchElementException;

/**
 * 基于链表实现的栈
 *
 * @Author: wangfan
 * @name: LinkedListStack
 * @Date: 2026/10/3
 */
public class LinkedListStack {
    private ListNode stackPeek;
    private int stackSize = 0;

    public LinkedListStack() {
        stackPeek = null;
    }

    /* 获取栈的长度 */
    public int size() {
        return stackSize;
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        return stackSize == 0;
    }

    /* 入栈 */
    public void push(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = stackPeek;
        stackPeek = newNode;
        stackSize++;
    }

    /* 出栈 */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int num = peek();
        stackPeek = stackPeek.next;
        stackSize--;
        return num;
    }

    /* 访问栈顶元素 */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stackPeek.value;
    }

    /* 将 List 转化为 Array 并返回 */
    public int[] toArray() {
        ListNode node = stackPeek;
        int[] res = new int[size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = node.value;
            node = node.next;
        }
        return res;
    }

}
