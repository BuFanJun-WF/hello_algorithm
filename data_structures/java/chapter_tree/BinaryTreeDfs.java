package chapter_tree;

import node.TreeNode;
import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 前序、中序、后序遍历：二叉树的深度优先搜索
 *
 * @Author: wangfan
 * @name: BinaryTreeDfs
 * @Date: 2026/10/6
 */
public class BinaryTreeDfs {
    // 初始化列表，用于存储遍历序列
    public static List<Integer> list = new ArrayList<>();

    /* 前序遍历 */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问优先级：根节点 -> 左子树 -> 右子树
        list.add(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /* 中序遍历 */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问优先级：左子树 -> 根节点 -> 右子树
        inOrder(root.getLeft());
        list.add(root.getValue());
        inOrder(root.getRight());
    }

    /* 后序遍历 */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问优先级：左子树 -> 右子树 -> 根节点
        postOrder(root.getLeft());
        postOrder(root.getRight());
        list.add(root.getValue());
    }

    public static void main(String[] args) {
        /* 初始化二叉树 */
        // 这里借助了一个从数组直接生成二叉树的函数
        TreeNode root = TreeNode.listToTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("\n初始化二叉树\n");
        PrintUtil.printTree(root);

        /* 前序遍历 */
        list.clear();
        preOrder(root);
        System.out.println("\n前序遍历的节点打印序列 = " + list);

        /* 中序遍历 */
        list.clear();
        inOrder(root);
        System.out.println("\n中序遍历的节点打印序列 = " + list);

        /* 后序遍历 */
        list.clear();
        postOrder(root);
        System.out.println("\n后序遍历的节点打印序列 = " + list);
    }
}
