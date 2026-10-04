package chapter_stack_and_queue.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 双向队列测试类
 *
 * @Author: wangfan
 * @name: DequeTest
 * @Date: 2026/10/3
 */
public class DequeTest {
    public static void main(String[] args) {
        // /* 初始化双向队列 */
        // Deque<Integer> deque = new ArrayDeque<>();
        // deque.offerLast(3);
        // deque.offerLast(2);
        // deque.offerLast(5);
        // System.out.println("双向队列 deque = " + deque);
        //
        // /* 访问元素 */
        // int peekFirst = deque.peekFirst();
        // System.out.println("队首元素 peekFirst = " + peekFirst);
        // int peekLast = deque.peekLast();
        // System.out.println("队尾元素 peekLast = " + peekLast);
        // System.out.println("双向队列 deque = " + deque);
        //
        // /* 元素入队 */
        // deque.offerLast(4);
        // System.out.println("元素 4 队尾入队后 deque = " + deque);
        // deque.offerFirst(1);
        // System.out.println("元素 1 队首入队后 deque = " + deque);
        //
        // /* 元素出队 */
        // int popLast = deque.poll();
        // System.out.println("队尾出队元素 = " + popLast + "，队尾出队后 deque = " + deque);
        // int popFirst = deque.pollFirst();
        // System.out.println("队首出队元素 = " + popFirst + "，队首出队后 deque = " + deque);
        //
        // /* 获取双向队列的长度 */
        // int size = deque.size();
        // System.out.println("双向队列长度 size = " + size);
        //
        // /* 判断双向队列是否为空 */
        // boolean isEmpty = deque.isEmpty();
        // System.out.println("双向队列是否为空 = " + isEmpty);



        /* 初始化双向队列 */
        LinkedListDeque deque = new LinkedListDeque();
        deque.pushLast(3);
        deque.pushLast(2);
        deque.pushLast(5);
        System.out.println("双向队列 deque = " + Arrays.toString(deque.toArray()));

        /* 访问元素 */
        int peekFirst = deque.peekFirst();
        System.out.println("队首元素 peekFirst = " + peekFirst);
        int peekLast = deque.peekLast();
        System.out.println("队尾元素 peekLast = " + peekLast);

        /* 元素入队 */
        deque.pushLast(4);
        System.out.println("元素 4 队尾入队后 deque = " + Arrays.toString(deque.toArray()));
        deque.pushFirst(1);
        System.out.println("元素 1 队首入队后 deque = " + Arrays.toString(deque.toArray()));

        /* 元素出队 */
        int popLast = deque.popLast();
        System.out.println("队尾出队元素 = " + popLast + "，队尾出队后 deque = " + Arrays.toString(deque.toArray()));
        int popFirst = deque.popFirst();
        System.out.println("队首出队元素 = " + popFirst + "，队首出队后 deque = " + Arrays.toString(deque.toArray()));

        /* 获取双向队列的长度 */
        int size = deque.getDequeSize();
        System.out.println("双向队列长度 size = " + size);

        /* 判断双向队列是否为空 */
        boolean isEmpty = deque.isEmpty();
        System.out.println("双向队列是否为空 = " + isEmpty);
    }
}
