package chapter_stack_and_queue.stack;

import java.util.ArrayList;

/**
 * 基于数组实现栈
 *
 * @Author: wangfan
 * @name: ArrayStack
 * @Date: 2026/10/3
 */
public class ArrayStack {
    private ArrayList<Integer> stack;

    public ArrayStack() {
        // 初始化列表（动态数组）
        stack = new ArrayList<>();
    }

    /* 获取栈的长度 */
    public int size() {
        return stack.size();
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /* 入栈 */
    public void push(int val) {
        stack.add(val);
    }
    /* 出栈 */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size()-1);
    }

    /* 访问栈顶元素 */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size()-1);
    }

    /* 将 List 转化为 Array 并返回 */
    public Object[] toArray() {
        return stack.toArray();
    }
}
