package chapter_stack_and_queue.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列测试类
 *
 * @Author: wangfan
 * @name: QueueTest
 * @Date: 2026/10/3
 */
public class QueueTest {
    public static void main(String[] args) {
        /* 初始化队列 */
        Queue<Integer> queue = new LinkedList<>();

        /* 元素入队 */
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);
        System.out.println("队列 queue = " + queue);

        /* 访问队首元素 */
        System.out.println("队首元素 = " + queue.peek());
        /* 元素出队 */
        int pop = queue.poll();
        System.out.println("出队元素 pop = " + pop + "，出队后 queue = " + queue);
        /* 获取队列的长度 */
        int size = queue.size();
        System.out.println("队列长度 size = " + size);

        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();
        System.out.println("队列是否为空 = " + isEmpty);
    }
}
