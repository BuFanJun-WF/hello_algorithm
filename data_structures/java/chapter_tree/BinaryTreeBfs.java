package chapter_tree;

import node.TreeNode;
import utils.PrintUtil;

import java.util.*;

/**
 * 层序遍历：二叉树的广度优先搜索
 *
 * @Author: wangfan
 * @name: BinaryTreeBfs
 * @Date: 2026/10/6
 */
public class BinaryTreeBfs {
    /* 层序遍历 */
    public static List<Integer> levelOrder(TreeNode root) {
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 队列出队
            TreeNode node = queue.poll();
            list.add(node.getValue());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        /* 初始化二叉树 */
        // 这里借助了一个从数组直接生成二叉树的函数
        TreeNode root = TreeNode.listToTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("\n初始化二叉树\n");
        PrintUtil.printTree(root);

        /* 层序遍历 */
        List<Integer> list = levelOrder(root);
        System.out.println("\n层序遍历的节点打印序列 = " + list);
    }
}
