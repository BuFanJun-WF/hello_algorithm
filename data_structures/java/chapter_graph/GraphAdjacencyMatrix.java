package chapter_graph;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基于邻接矩阵实现的无向图
 *
 * @Author: wangfan
 * @name: GraphAdjacencyMatrix
 * @Date: 2026/10/8
 */
public class GraphAdjacencyMatrix {
    // 顶点列表，元素表示“顶点值”，索引代表“顶点索引”
    List<Integer> vertices;
    // 邻接矩阵，行列索引对应‘顶点索引’
    List<List<Integer>> adjacencyMatrix;

    /* 构造方法 */
    public GraphAdjacencyMatrix(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjacencyMatrix = new ArrayList<>();

        // 添加顶点
        for (int val : vertices) {
            addVertex(val);
        }
        // 添加边
        // 请注意，edges 元素代表顶点索引，即对应 vertices 元素索引
        for (int[] e : edges) {
            addEdge(e[0], e[1]);
        }
    }

    /* 获取顶点数量 */
    public int size() {
        return vertices.size();
    }

    /* 添加顶点 */
    public void addVertex(int v) {
        int n = size();
        // 向顶点列表中添加新顶点的值
        vertices.add(v);

        // 在邻接矩阵中添加1行
        List<Integer> newRow = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            newRow.add(0);
        }
        adjacencyMatrix.add(newRow);

        // 在邻接矩阵中添加1列
        for (List<Integer> row : adjacencyMatrix) {
            row.add(0);
        }
    }

    /* 删除顶点 */
    public void removeVertex(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        // 在顶点列表中移除索引 index 的顶点
        vertices.remove(index);
        // 在邻接矩阵中删除索引 index 的行
        adjacencyMatrix.remove(index);
        // 在邻接矩阵中删除索引 index 的列
        for (List<Integer> row : adjacencyMatrix) {
            row.remove(index);
        }
    }

    /* 添加边 */
    // 参数 i, j 对应 vertices 元素索引
    public void addEdge(int i, int j) {
        // 索引越界与相等处理
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j)
            throw new IndexOutOfBoundsException();
        // 在无向图中，邻接矩阵关于主对角线对称，即满足 (i, j) == (j, i)
        adjacencyMatrix.get(i).set(j, 1);
        adjacencyMatrix.get(j).set(i, 1);
    }

    /* 删除边 */
    // 参数 i, j 对应 vertices 元素索引
    public void removeEdge(int i, int j) {
        // 索引越界与相等处理
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j)
            throw new IndexOutOfBoundsException();
        adjacencyMatrix.get(i).set(j, 0);
        adjacencyMatrix.get(j).set(i, 0);
    }

    /* 打印邻接矩阵 */
    public void print() {
        System.out.print("顶点列表 = ");
        System.out.println(vertices);
        System.out.println("邻接矩阵 =");
        PrintUtil.printMatrix(adjacencyMatrix);
    }

    public static void main(String[] args) {
        /* 初始化无向图 */
        // 请注意，edges 元素代表顶点索引，即对应 vertices 元素索引
        int[] vertices = { 1, 3, 2, 5, 4 };
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 3, 4 } };
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(vertices, edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 添加边 */
        // 顶点 1, 2 的索引分别为 0, 2
        graph.addEdge(0, 2);
        System.out.println("\n添加边 1-2 后，图为");
        graph.print();

        /* 删除边 */
        // 顶点 1, 3 的索引分别为 0, 1
        graph.removeEdge(0, 1);
        System.out.println("\n删除边 1-3 后，图为");
        graph.print();

        /* 添加顶点 */
        graph.addVertex(6);
        System.out.println("\n添加顶点 6 后，图为");
        graph.print();

        /* 删除顶点 */
        // 顶点 3 的索引为 1
        graph.removeVertex(1);
        System.out.println("\n删除顶点 3 后，图为");
        graph.print();
    }

}
