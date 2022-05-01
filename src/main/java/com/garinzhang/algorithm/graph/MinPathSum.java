package com.garinzhang.algorithm.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-path-sum/">64. 最小路径和</a> <br/>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。<br/>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]] <br/>
 * 输出：7 <br/>
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 主要用这个问题来练习Dijkstra算法
 *
 * @author Zhang Jialin
 * @date 2022-04-30
 */
public class MinPathSum {

    /**
     * 空间复杂度: O()
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        // 1. 初始化
        // 1.1 vertexMap: 用于存储vertex的引用，并提供时间复杂度O(1)的查找性能
        int size = grid.length * grid[0].length;
        Map<String, Vertex> vertexMap = new HashMap<>(size);
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                vertexMap.put(getVertexKey(j, i), new Vertex(j, i));
            }
        }
        Vertex start = vertexMap.get(getVertexKey(0, 0));
        start.dist = grid[0][0];
        // 1.2 minHeap: 用于存储(s, u)已知的最短路径d[u]，并能快速拿到现有的最短路径
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(size, (v1, v2) -> -(v1.dist - v2.dist));
        minHeap.add(start);
        // 2. 图广度优先遍历
        while (!minHeap.isEmpty()) {
            Vertex minDisVertex = minHeap.poll();
            String[] adjKeyArr = getAdjKey(grid, minDisVertex);
            for (String adjKey : adjKeyArr) {
                if (adjKey == null) {
                    continue;
                }
                Vertex adjVertex = vertexMap.get(adjKey);
                int newPathDist = minDisVertex.dist + grid[adjVertex.y][adjVertex.x];
                // 2.1 发现了更短路径
                if (newPathDist < adjVertex.dist) {
                    adjVertex.dist = newPathDist;
                    // 碍于原生PriorityQueue实现，先这么写但可以优化，这里的时间复杂度O(nlog(n))
                    minHeap.remove(adjVertex);
                    minHeap.add(adjVertex);
                }
            }
        }
        return vertexMap.get(getVertexKey(grid[0].length - 1, grid.length - 1)).dist;
    }

    private String[] getAdjKey(int[][] grid, Vertex v) {
        String[] adjacent = new String[2];
        adjacent[0] = v.y + 1 < grid.length ? getVertexKey(v.x, v.y + 1) : null;
        adjacent[1] = v.x + 1 < grid[0].length ? getVertexKey(v.x + 1, v.y) : null;
        return adjacent;
    }

    private String getVertexKey(int x, int y) {
        return x + "," + y;
    }

    private static class Vertex {
        /** 起始点s到当前顶点的最短距离 */
        private int dist = Integer.MAX_VALUE;
        /** 横坐标 */
        private final int x;
        /** 纵坐标 */
        private final int y;

        Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
