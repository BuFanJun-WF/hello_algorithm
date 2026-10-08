package utils;

import node.ListNode;
import node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 打印工具类
 *
 * @Author: wangfan
 * @name: PrintUtil
 * @Date: 2026/10/2
 */
class Trunk {
    Trunk prev;
    String str;

    Trunk(Trunk prev, String str) {
        this.prev = prev;
        this.str = str;
    }
};
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

    /* 打印二叉树 */
    public static void printTree(TreeNode root) {
        printTree(root, null, false);
    }

    /**
     * 打印二叉树
     * This tree printer is borrowed from TECHIE DELIGHT
     * https://www.techiedelight.com/c-program-print-binary-tree/
     */
    public static void printTree(TreeNode root, Trunk prev, boolean isRight) {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.getRight(), trunk, true);

        if (prev == null) {
            trunk.str = "———";
        } else if (isRight) {
            trunk.str = "/———";
            prev_str = "   |";
        } else {
            trunk.str = "\\———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.getValue());

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.getLeft(), trunk, false);
    }
    public static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    /* 打印矩阵（Array） */
    public static <T> void printMatrix(T[][] matrix) {
        System.out.println("[");
        for (T[] row : matrix) {
            System.out.println("  " + row + ",");
        }
        System.out.println("]");
    }

    /* 打印矩阵（List） */
    public static <T> void printMatrix(List<List<T>> matrix) {
        System.out.println("[");
        for (List<T> row : matrix) {
            System.out.println("  " + row + ",");
        }
        System.out.println("]");
    }

    /* 打印堆（优先队列） */
    public static void printHeap(Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>(queue);
        System.out.print("堆的数组表示：");
        System.out.println(list);
        System.out.println("堆的树状表示：");
        TreeNode root = TreeNode.listToTree(list);
        printTree(root);
    }

}
