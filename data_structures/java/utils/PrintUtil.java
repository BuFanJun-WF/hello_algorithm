package utils;

import node.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印工具类
 *
 * @Author: wangfan
 * @name: PrintUtil
 * @Date: 2026/10/2
 */
public class PrintUtil {
    /* 打印链表 */
    public static void printLinkedList(ListNode head) {
        List<String> list = new ArrayList<>();
        while (head != null) {
            list.add(String.valueOf(head.value));
            head = head.next;
        }
        System.out.println(String.join(" -> ", list));
    }
}
