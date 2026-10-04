package node;

/**
 * java的链表节点
 *
 * @Author: wangfan
 * @name: ListNode
 * @Date: 2026/10/2
 */
public class ListNode {
    public int value;
    public ListNode next;
    public ListNode prev;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /**
     * 将数组转换为链表,head为链表的头节点
     * @param arr 数组
     * @return 链表头节点
     */
    public static ListNode arrayToListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * 将数组转换为链表,head为链表的头节点,head为空节点
     * @param arr 数组
     * @return 链表头节点
     */
    public static ListNode arrayToListNode2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int j : arr) {
            current.next = new ListNode(j);
            current = current.next;
        }
        return head;
    }
}
