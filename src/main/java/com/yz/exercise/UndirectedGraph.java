package com.yz.exercise;
import java.util.*;

/**
 * 无向图
 * @author yu.zh-neu
 * @create 2023-07-06 21:11
 */

public class UndirectedGraph {
    private int V; // 图中顶点的数量
    private List<List<Integer>> adjList; // 邻接表表示图
    private boolean[] visited; // 记录节点是否被访问过
    private int[] color; // 记录节点的颜色，0表示未着色，大于0表示已着色的颜色
    private int maxColors; // 最大可使用的颜色数

    public UndirectedGraph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new LinkedList<>());
        }
        visited = new boolean[V];
        color = new int[V];
        maxColors = 0;
    }

    // 添加边
    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    // 深度优先搜索
    private void dfs(int v, int c) {
        visited[v] = true;
        color[v] = c;

        List<Integer> neighbors = adjList.get(v);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                int availableColor = 1;
                while (availableColor <= maxColors && hasAdjacentColor(neighbor, availableColor)) {
                    availableColor++;
                }
                if (availableColor > maxColors) {
                    maxColors++;
                }
                dfs(neighbor, availableColor);
            }
        }
    }

    // 检查相邻节点是否已经着色
    private boolean hasAdjacentColor(int v, int c) {
        List<Integer> neighbors = adjList.get(v);
        for (int neighbor : neighbors) {
            if (color[neighbor] == c) {
                return true;
            }
        }
        return false;
    }

    // 计算可颜色个数
    public int calculateColorCount() {
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                maxColors = 1;
                dfs(i, 1);
            }
        }
        return maxColors;
    }

    public static void main(String[] args) {
        int V = 5; // 图中顶点的数量
        UndirectedGraph graph = new UndirectedGraph(V);

        // 添加边
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // 计算可颜色个数
        int colorCount = graph.calculateColorCount();

        System.out.println("可使用的颜色个数为: " + colorCount);
    }
}

