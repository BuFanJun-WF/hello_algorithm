package chapter_array_and_linkedlist;

import node.ListNode;
import utils.PrintUtil;

/**
 * 链表的实现
 *
 * @Author: wangfan
 * @name: LinkedList
 * @Date: 2026/10/2
 */
public class LinkedList {
    /** 在链表的节点 n0 之后插入节点 P */
    public static void insert(ListNode head, ListNode p){
        ListNode n1 = head.next;
        p.next = n1;
        head.next = p;
    }

    /** 删除链表的节点 n0 之后的第一个节点 */
    public static void remove(ListNode head){
        if (head.next == null) {
            return;
        }

        ListNode p = head.next.next;
        head.next = p;
    }

    /** 访问链表中索引为index的节点 */
    public static ListNode access(ListNode head, int index){
        if (head == null) {
            return null;
        }
        ListNode p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    /** 查找链表中值为value的节点的索引 */
    public static int find(ListNode head, int value){
        if (head == null) {
            return -1;
        }
        int index = -1;
        while (head != null) {
            index++;
            if (head.value == value) {
                return index;
            }
            head = head.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        /* 初始化一个链表 */
        // 初始化各个节点
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        // 构建节点之间的连接
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println("初始化的链表为：");
        PrintUtil.printLinkedList(n0);

        /* 插入节点 */
        insert(n0, new ListNode(0));
        System.out.println("插入节点后的链表为");
        PrintUtil.printLinkedList(n0);

        /* 删除节点 */
        remove(n0);
        System.out.println("删除节点后的链表为");
        PrintUtil.printLinkedList(n0);

        /* 访问节点 */
        ListNode node = access(n0, 3);
        System.out.println("链表中索引 3 处的节点的值 = " + node.value);

        /* 查找节点 */
        int index = find(n0, 2);
        System.out.println("链表中值为 2 的节点的索引 = " + index);
    }
}
