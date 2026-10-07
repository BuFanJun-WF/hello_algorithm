package chapter_tree;

import com.sun.tools.javac.Main;
import node.Pair;
import node.TreeNode;
import utils.PrintUtil;

/**
 * 二叉搜索树实现
 *
 * @Author: wangfan
 * @name: BinarySearchTree
 * @Date: 2026/10/6
 */
public class BinarySearchTree {
    private TreeNode root;
    /* 构造方法 */
    public BinarySearchTree() {
        // 初始化空树
        root = null;
    }

    /* 获取二叉树根节点 */
    public TreeNode getRoot() {
        return root;
    }

    /* 查找节点 */
    public TreeNode search(int num) {
        TreeNode cur = root;
        // 循环查找，越过叶节点后跳出
        while (cur != null) {
            if (cur.getValue() < num) {
                cur = cur.getRight();
            }
            else if (cur.getValue() > num) {
                cur = cur.getLeft();
            }
            else {
                break;
            }
        }
        return cur;
    }

    /* 插入节点 */
    public void insert(int num) {
        // 如果树为空，则初始化根节点
        if (root == null) {
            root = new TreeNode(num);
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            // 找到重复节点，直接返回
            if (cur.getValue() == num) {
                return;
            }

            pre = cur;
            if (cur.getValue() < num) {
                cur = cur.getRight();
            }
            else {
                cur = cur.getLeft();
            }
        }

        // 插入节点
        TreeNode node = new TreeNode(num);
        if (pre.getValue() < num) {
            pre.setRight(node);
        }
        else {
            pre.setLeft(node);
        }
    }

    /* 删除节点 */
    public void remove(int num) {
        // 若树为空，则直接返回
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.getValue() == num) {
                break;
            }
            pre = cur;
            if (cur.getValue() < num) {
                cur = cur.getRight();
            }
            else {
                cur = cur.getLeft();
            }
        }

        // 如果没有找到值，则直接返回
        if (cur == null) {
            return;
        }

        // 判断子节点的数量，子节点数量为0或1相同的操作
        if (cur.getLeft() == null || cur.getRight() == null) {
            TreeNode child = cur.getLeft() != null ? cur.getLeft() : cur.getRight();
            // 删除节点
            if (cur != root) {
                if (pre.getLeft() == cur) {
                    pre.setLeft(child);
                }
                else {
                    pre.setRight(child);
                }
            }
            else {
                // 要删除的节点为根节点
                root = child;
            }
        }
        // 子节点的数量为2的情况
        else {
            // 获取中序遍历中cur的下一个节点
            TreeNode tmp = cur.getRight();
            while (tmp.getLeft() != null) {
                tmp = tmp.getLeft();
            }
            // 递归删除节点tmp
            remove(tmp.getValue());
            // 用tmp覆盖掉cur
            cur.setValue(tmp.getValue());
        }
    }

    public static void main(String[] args) {
        /* 初始化二叉搜索树 */
        BinarySearchTree bst = new BinarySearchTree();
        // 请注意，不同的插入顺序会生成不同的二叉树，该序列可以生成一个完美二叉树
        int[] nums = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
        for (int num : nums) {
            bst.insert(num);
        }
        System.out.println("\n初始化的二叉树为\n");
        PrintUtil.printTree(bst.getRoot());

        /* 查找节点 */
        TreeNode node = bst.search(7);
        System.out.println("\n查找到的节点对象为 " + node + "，节点值 = " + node.getValue());

        /* 插入节点 */
        bst.insert(16);
        System.out.println("\n插入节点 16 后，二叉树为\n");
        PrintUtil.printTree(bst.getRoot());

        /* 删除节点 */
        bst.remove(1);
        System.out.println("\n删除节点 1 后，二叉树为\n");
        PrintUtil.printTree(bst.getRoot());
        bst.remove(2);
        System.out.println("\n删除节点 2 后，二叉树为\n");
        PrintUtil.printTree(bst.getRoot());
        bst.remove(4);
        System.out.println("\n删除节点 4 后，二叉树叉树为\n");
        PrintUtil.printTree(bst.getRoot());
    }
}
