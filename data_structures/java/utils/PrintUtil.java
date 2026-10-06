package utils;

import node.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /* 打印哈希表 */
    public static <K, V> void printHashMap(Map<K, V> map) {
        for (Map.Entry<K, V> kv : map.entrySet()) {
            System.out.println(kv.getKey() + " -> " + kv.getValue());
        }
    }
}
