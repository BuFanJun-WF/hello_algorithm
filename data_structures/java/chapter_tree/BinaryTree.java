package chapter_tree;

import node.TreeNode;
import utils.PrintUtil;

/**
 * 二叉树测试类
 *
 * @Author: wangfan
 * @name: BinaryTree
 * @Date: 2026/10/6
 */
public class BinaryTree {
    public static void main(String[] args) {
        /* 创建二叉树 */
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        System.out.println("\n初始化二叉树\n");
        PrintUtil.printTree(root);

        /* 插入与删除节点 */
        TreeNode P = new TreeNode(0);
        root.setLeft(P);
        P.setLeft(node2);
        System.out.println("\n插入节点 P 后\n");
        PrintUtil.printTree(root);

        root.setLeft(node2);
        System.out.println("\n删除节点 P 后\n");
        PrintUtil.printTree(root);
    }
}
