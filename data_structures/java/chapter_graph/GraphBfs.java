package chapter_graph;

import node.Vertex;

import java.util.*;

/**
 * 使用邻接表表示图，实现广度优先遍历
 *
 * @Author: wangfan
 * @name: GraphBfs
 * @Date: 2026/10/8
 */
public class GraphBfs {
    /* 广度优先遍历 */
    public static List<Vertex> graphBFS(GraphAdjacencyList graph, Vertex start) {
        // 顶点遍历列表
        List<Vertex> result = new ArrayList<>();
        // 哈希集合，用于记录已被访问过的顶点
        Set<Vertex> visited = new HashSet<>();
        visited.add(start);

        // 队列用于实现广度优先遍历
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            // 队首移出队列
            Vertex current = queue.poll();
            result.add(current);
            for(Vertex neighbor : graph.adjList.get(current)) {
                if (visited.contains(neighbor)) {
                    // 跳过已经被访问过的节点
                    continue;
                }
                // 标记该顶点已被访问
                visited.add(neighbor);
                // 只入队未访问的顶点
                queue.offer(neighbor);
            }
        }
        // 返回顶点遍历列表
        return result;
    }
    public static void main(String[] args) {
        /* 初始化无向图 */
        Vertex[] v = Vertex.valsToVets(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        Vertex[][] edges = { { v[0], v[1] }, { v[0], v[3] }, { v[1], v[2] }, { v[1], v[4] },
                { v[2], v[5] }, { v[3], v[4] }, { v[3], v[6] }, { v[4], v[5] },
                { v[4], v[7] }, { v[5], v[8] }, { v[6], v[7] }, { v[7], v[8] } };
        GraphAdjacencyList graph = new GraphAdjacencyList(edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 广度优先遍历 */
        List<Vertex> res = graphBFS(graph, v[4]);
        System.out.println("\n广度优先遍历（BFS）顶点序列为");
        System.out.println(Vertex.vetsToVals(res));
    }
}
