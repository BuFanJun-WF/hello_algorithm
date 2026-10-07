package chapter_tree;

import com.sun.source.tree.Tree;
import node.TreeNode;
import utils.PrintUtil;

/**
 * 平衡二叉搜索树：因为二叉搜索树在经过删除或者插入节点后可能会劣化
 * 失衡节点的平衡因子  子节点的平衡因子  应采用的旋转方法
 * >1 (左偏树)        ≥0             右旋
 * >1 (左偏树)        <0             先左旋后右旋
 * < —1 (右偏树)      ≤0             左旋
 * < —1 (右偏树)      >0             先右旋后左旋
 * 节点的平衡因子（balance factor）定义为节点左子树的高度减去右子树的高度。
 * @Author: wangfan
 * @name: AVLTree
 * @Date: 2026/10/6
 */
public class AVLTree {
    private TreeNode root;

    /* 获取节点的高度 */
    public int getHeight(TreeNode node) {
        // 空节点高度为 -1 ，叶节点高度为 0
        return node == null ? -1 : node.getHeight();
    }

    /* 更新节点的高度 */
    public void updateHeight(TreeNode node) {
        // 节点的高度等于其高度较大的子节点的高度加 1
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
    }

    /* 获取平衡因子 */
    public int getBalanceFactor(TreeNode node) {
        // 空节点平衡因子为0
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    /* 右旋操作 */
    private TreeNode rightRotate(TreeNode node) {
        // 获取左子树节点
        TreeNode child = node.getLeft();
        // 获取左子树节点的右子节点
        TreeNode grandChild = child.getRight();
        // 以child为原点，将node进行向右旋转
        child.setRight(node);
        node.setLeft(grandChild);

        // 更新节点高度
        updateHeight(node);
        updateHeight(child);
        // 返回选择后子树的根节点
        return child;
    }

    /* 左旋操作 */
    private TreeNode leftRotate(TreeNode node) {
        // 获取右子树节点
        TreeNode child = node.getRight();
        // 获取右子树的左节点
        TreeNode grandChild = child.getLeft();
        // 以child为原点，将node进行向左旋转
        child.setLeft(node);
        node.setRight(grandChild);

        // 更新节点高度
        updateHeight(node);
        updateHeight(child);
        // 返回选择后子树的根节点
        return child;
    }

    /* 执行旋转操作，使该子树重新恢复平衡 */
    private TreeNode rotate(TreeNode node) {
        // 获取节点的平衡因子
        int balanceFactor = getBalanceFactor(node);
        // 左偏树
        if (balanceFactor > 1) {
            // 左子树平衡因子 ≥ 0，右旋
            if (getBalanceFactor(node.getLeft()) >= 0) {
                // 右旋
                return rightRotate(node);
            }
            else {
                // 先左旋后右旋
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
        }
        // 右偏树
        if (balanceFactor < -1) {
            // 右子树平衡因子 ≤ 0，左旋
            if (getBalanceFactor(node.getRight()) <= 0) {
                // 左旋
                return leftRotate(node);
            }
            else {
                // 先右旋后左旋
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }
        // 平衡因子在 -1 到 1 之间，则该子树已经平衡，返回根节点
        return node;
    }

    /* 插入节点 */
    public void insert(int value) {
        root = insertHelper(root, value);
    }

    /* 递归插入节点（辅助方法） */
    private TreeNode insertHelper(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.getValue()) {
            node.setLeft(insertHelper(node.getLeft(), val));
        }
        else if (val > node.getValue()) {
            node.setRight(insertHelper(node.getRight(), val));
        }
        else {
            // 重复节点不插入，直接返回
            return node;
        }
        updateHeight(node); // 更新节点高度
        // 执行旋转操作，使该子树重新恢复平衡
        return rotate(node);
    }

    /* 删除节点 */
    public void remove(int val) {
        root = removeHelper(root, val);
    }

    /* 递归删除节点（辅助方法） */
    private TreeNode removeHelper(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.getValue()) {
            node.setLeft(removeHelper(node.getLeft(), val));
        }
        else if (val > node.getValue()) {
            node.setRight(removeHelper(node.getRight(), val));
        }
        else {
            // 找到待删除节点，进行删除
            if (node.getLeft() == null && node.getRight() == null) {
                // 待删除节点为叶节点，则直接删除
                return null;
            }
            else if (node.getLeft() == null) {
                // 待删除节点只有右子节点，则用右子节点替换待删除节点
                return node.getRight();
            }
            else if (node.getRight() == null) {
                // 待删除节点只有左子节点，则用左子节点替换待删除节点
                return node.getLeft();
            }
            else {
                // 待删除节点有两个子节点，则将中序遍历的下个节点删除，则用右子树的最小节点替换待删除节点
                TreeNode temp = node.getRight();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
                // 替换节点值
                node.setValue(temp.getValue());
                // 删除右子树的最小节点
                node.setRight(removeHelper(node.getRight(), temp.getValue()));
            }
        }
        updateHeight(node); // 更新节点高度
        // 执行旋转操作，使该子树重新恢复平衡
        return rotate(node);
    }

    /* 查找节点 */
    public TreeNode search(int val) {
        TreeNode cur = root;
        // 循环查找，越过叶节点后跳出
        while (cur != null) {
            // 目标节点在 cur 的右子树中
            if (cur.getValue() < val)
                cur = cur.getRight();
                // 目标节点在 cur 的左子树中
            else if (cur.getValue() > val)
                cur = cur.getLeft();
                // 找到目标节点，跳出循环
            else
                break;
        }
        // 返回目标节点
        return cur;
    }

    static void testInsert(AVLTree tree, int val) {
        tree.insert(val);
        System.out.println("\n插入节点 " + val + " 后，AVL 树为");
        PrintUtil.printTree(tree.root);
    }

    static void testRemove(AVLTree tree, int val) {
        tree.remove(val);
        System.out.println("\n删除节点 " + val + " 后，AVL 树为");
        PrintUtil.printTree(tree.root);
    }

    public static void main(String[] args) {
        /* 初始化空 AVL 树 */
        AVLTree avlTree = new AVLTree();

        /* 插入节点 */
        // 请关注插入节点后，AVL 树是如何保持平衡的
        testInsert(avlTree, 1);
        testInsert(avlTree, 2);
        testInsert(avlTree, 3);
        testInsert(avlTree, 4);
        testInsert(avlTree, 5);
        testInsert(avlTree, 8);
        testInsert(avlTree, 7);
        testInsert(avlTree, 9);
        testInsert(avlTree, 10);
        testInsert(avlTree, 6);

        /* 插入重复节点 */
        testInsert(avlTree, 7);

        /* 删除节点 */
        // 请关注删除节点后，AVL 树是如何保持平衡的
        testRemove(avlTree, 8); // 删除度为 0 的节点
        testRemove(avlTree, 5); // 删除度为 1 的节点
        testRemove(avlTree, 4); // 删除度为 2 的节点

        /* 查询节点 */
        TreeNode node = avlTree.search(7);
        System.out.println("\n查找到的节点对象为 " + node + "，节点值 = " + node.getValue());
    }
}
