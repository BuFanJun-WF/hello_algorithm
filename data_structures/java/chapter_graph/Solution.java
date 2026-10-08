package chapter_graph;

import java.util.*;

/**
 *
 * @Author: wangfan
 * @name: Solution
 * @Date: 2026/10/8
 */
public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 创建邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        // 使用队列存储广度遍历每一层的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (current == destination) {
                return true;
            }
            for (Integer neighbor : adj.get(current)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
                visited.add(neighbor);
            }
        }
        return false;
    }
}
