package chapter_divide_and_conquer;

import node.TreeNode;
import utils.PrintUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过前序遍历和中序遍历构造出完整的二叉树
 *
 * @Author: wangfan
 * @name: BuildTree
 * @Date: 2026/10/10
 */
public class BuildTree {
    public static TreeNode dfs(int[] preorder, Map<Integer, Integer> inorderMap, int preorderStart, int inorderStart, int inorderEnd) {
        // 子树区间为空为终止
        if (inorderEnd - inorderStart < 0) {
            return null;
        }
        // 初始化根节点
        TreeNode root = new TreeNode(preorder[preorderStart]);
        // 查询根节点在中序遍历中的索引
        int rootIndex = inorderMap.get(preorder[preorderStart]);
        // 递归构建左子树
        root.setLeft(dfs(preorder, inorderMap,preorderStart + 1, inorderStart, rootIndex - 1));
        // 递归构建右子树
        root.setRight(dfs(preorder, inorderMap,preorderStart + rootIndex - inorderStart + 1, rootIndex + 1, inorderEnd));
        return root;
    }

    /* 构造二叉树 */
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化哈希表，存储中序遍历元素到索引之间的映射关系
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        // 通过前序遍历的元素确定首元素，然后获取中序遍历的索引判断左右子树的元素各自的数量
        TreeNode root = dfs(preorder,inorderMap, 0, 0, inorder.length - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 2, 1, 7 };
        int[] inorder = { 9, 3, 1, 2, 7 };
        System.out.println("前序遍历 = " + Arrays.toString(preorder));
        System.out.println("中序遍历 = " + Arrays.toString(inorder));

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("构建的二叉树为：");
        PrintUtil.printTree(root);
    }
}
