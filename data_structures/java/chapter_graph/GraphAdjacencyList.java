package chapter_graph;

import node.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于邻接表实现无向图
 *
 * @Author: wangfan
 * @name: GraphAdjacencyList
 * @Date: 2026/10/8
 */
public class GraphAdjacencyList {
    // 邻接表，key：顶点，value：该顶点的所有邻接顶点
    public Map<Vertex, List<Vertex>> adjList;

    /* 构造方法 */
    public GraphAdjacencyList(Vertex[][] edges) {
        this.adjList = new HashMap<>();
        // 添加所有的顶点和边
        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    /* 获取顶点数量 */
    public int size() {
        return adjList.size();
    }

    /* 添加顶点 */
    public void addVertex(Vertex vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
        }
    }

    /* 删除顶点 */
    public void removeVertex(Vertex vet) {
        if (!adjList.containsKey(vet))
            throw new IllegalArgumentException();
        // 在邻接表中删除顶点 vet 对应的链表
        adjList.remove(vet);
        // 遍历其他顶点的链表，删除所有包含 vet 的边
        for (List<Vertex> list : adjList.values()) {
            list.remove(vet);
        }
    }

    /* 添加边 */
    public void addEdge(Vertex from, Vertex to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to))
            throw new IllegalArgumentException();
        // 添加边 from -> to
        adjList.get(from).add(to);
        // 添加边 to -> from
        adjList.get(to).add(from);
    }

    /* 删除边 */
    public void removeEdge(Vertex from, Vertex to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to))
            throw new IllegalArgumentException();
        // 删除边 from -> to
        adjList.get(from).remove(to);
        // 删除边 to -> from
        adjList.get(to).remove(from);
    }

    /* 打印邻接表 */
    public void print() {
        System.out.println("邻接表 =");
        for (Map.Entry<Vertex, List<Vertex>> pair : adjList.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Vertex vertex : pair.getValue())
                tmp.add(vertex.val);
            System.out.println(pair.getKey().val + ": " + tmp + ",");
        }
    }

    public static void main(String[] args) {
        /* 初始化无向图 */
        Vertex[] v = Vertex.valsToVets(new int[] { 1, 3, 2, 5, 4 });
        Vertex[][] edges = { { v[0], v[1] }, { v[0], v[3] }, { v[1], v[2] },
                { v[2], v[3] }, { v[2], v[4] }, { v[3], v[4] } };
        GraphAdjacencyList graph = new GraphAdjacencyList(edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 添加边 */
        // 顶点 1, 2 即 v[0], v[2]
        graph.addEdge(v[0], v[2]);
        System.out.println("\n添加边 1-2 后，图为");
        graph.print();

        /* 删除边 */
        // 顶点 1, 3 即 v[0], v[1]
        graph.removeEdge(v[0], v[1]);
        System.out.println("\n删除边 1-3 后，图为");
        graph.print();

        /* 添加顶点 */
        Vertex v5 = new Vertex(6);
        graph.addVertex(v5);
        System.out.println("\n添加顶点 6 后，图为");
        graph.print();

        /* 删除顶点 */
        // 顶点 3 即 v[1]
        graph.removeVertex(v[1]);
        System.out.println("\n删除顶点 3 后，图为");
        graph.print();
    }
}
