package chapter_divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求解汉诺塔问题
 *
 * @Author: wangfan
 * @name: Hanota
 * @Date: 2026/10/10
 */
public class Hanota {
    /* 移动一个圆盘 */
    static void move(List<Integer> src, List<Integer> tar) {
        // 从 src 顶部拿出一个圆盘
        Integer pan = src.remove(src.size() - 1);
        // 将圆盘放入 tar 顶部
        tar.add(pan);
    }

    public static void dfs(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        // 如果A只剩下一个圆盘，则直接将其移动到C
        if (n == 1) {
            move(A, C);
            return;
        }

        // 子问题：将A顶部的n-1个盘子借助C移动到B
        dfs(n - 1, A, C, B);
        // 将A顶部的1个盘子移动到C
        move(A, C);
        // 子问题：将B顶部的n-1个盘子借助A移动到C
        dfs(n - 1, B, A, C);
    }


    public static void solveHanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();

        // 将A顶部的n个盘子借助B移动到C
        dfs(n, A, B, C);
    }

    public static void main(String[] args) {
        // 列表尾部是柱子顶部
        List<Integer> A = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        System.out.println("初始状态下：");
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("C = " + C);

        solveHanota(A, B, C);

        System.out.println("圆盘移动完成后：");
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("C = " + C);
    }
}
