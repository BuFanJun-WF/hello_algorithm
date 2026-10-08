package chapter_graph;

import node.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 使用邻接表来实现图，深度优先遍历
 *
 * @Author: wangfan
 * @name: GraphDfs
 * @Date: 2026/10/8
 */
public class GraphDfs {
    public static List<Vertex> graphDFS(GraphAdjacencyList graph, Vertex start) {
        // 顶点遍历序列
        List<Vertex> result = new ArrayList<Vertex>();
        // 哈希集合，用于记录已被访问过的顶点
        Set<Vertex> visited = new HashSet<Vertex>();
        dfs(graph, visited, result, start);
        return result;
    }

    public static void dfs(GraphAdjacencyList graph, Set<Vertex> visited, List<Vertex> result, Vertex current) {
        visited.add(current);
        result.add(current);
        for (Vertex neighbor : graph.adjList.get(current)) {
            if (visited.contains(neighbor)) {
                continue;
            }
            // 递归访问未被访问过的邻接顶点
            dfs(graph, visited, result, neighbor);
        }
    }

    public static void main(String[] args) {
        /* 初始化无向图 */
        Vertex[] v = Vertex.valsToVets(new int[] { 0, 1, 2, 3, 4, 5, 6 });
        Vertex[][] edges = { { v[0], v[1] }, { v[0], v[3] }, { v[1], v[2] },
                { v[2], v[5] }, { v[4], v[5] }, { v[5], v[6] } };
        GraphAdjacencyList graph = new GraphAdjacencyList(edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 深度优先遍历 */
        List<Vertex> res = graphDFS(graph, v[0]);
        System.out.println("\n深度优先遍历（DFS）顶点序列为");
        System.out.println(Vertex.vetsToVals(res));
    }
}
