package chapter_stack_and_queue.stack;

import java.util.Stack;

/**
 * 栈测试
 *
 * @Author: wangfan
 * @name: StackTest
 * @Date: 2026/10/3
 */
public class StackTest {
    public static void main(String[] args) {
        /* 初始化栈 */
        Stack<Integer> stack = new Stack<>();

        /* 元素入栈 */
        stack.push(1);
        stack.push(2);
        stack.push(3);

        /* 元素出栈 */
        int pop = stack.pop();
        System.out.println("出栈元素 pop = " + pop + "，出栈后 stack = " + stack);
        System.out.println("栈顶元素为：" + stack.peek());
        System.out.println("栈的大小为：" + stack.size());
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println("栈的元素为：" + stack);
    }
}
