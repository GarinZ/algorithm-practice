package com.garinzhang.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class AdjacencyList {
    static class Graph {
        private int v;
        private LinkedList<Integer>[] adj;

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i ++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) {
            adj[s].add(t);
            adj[t].add(s);
        }
    }

    public List<Integer> bfs(int s, int t, Graph graph) {
        boolean[] visited = new boolean[graph.v];
        int[] prev = new int[graph.v];
        for (int i = 0; i < prev.length; i ++) {
            prev[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        LinkedList<Integer>[] adj = graph.adj;
        while (!queue.isEmpty()) {
            Integer e = queue.poll();
            visited[e] = true;
            LinkedList<Integer> edages = adj[e];
            for (int i = 0; i < edages.size(); i ++) {
                if (!visited[i]) {
                    if (edages.get(i).equals(t)) {
                        return getPath(prev, t);
                    }
                    prev[edages.get(i)] = e;
                    queue.add(edages.get(i));
                }
            }
        }
        return null;
    }

    public static List<Integer> dfs(int s, int t, Graph graph) {
        boolean[] visited = new boolean[graph.v];
        visited[s] = true;
        int[] prev = new int[graph.v];
        for (int i = 0; i < graph.v; i ++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev, graph);
        return getPath(prev, t);
    }

    public static void recurDfs(int s, int t, boolean[] visited, int[] prev, Graph graph) {
        LinkedList<Integer> edages = graph.adj[s];
        for (int i = 0; i < edages.size(); i ++) {
            if (!visited[edages.get(i)]) {
                prev[edages.get(i)] = s;
                visited[edages.get(i)] = true;
                recurDfs(edages.get(i), t, visited, prev, graph);
                if (prev[t] != -1) {
                    return;
                }
            }
        }
    }

    public static List<Integer> getPath(int[] prev, int t) {
        List<Integer> result = new ArrayList<>();
        int i = t;
        while (i != -1) {
            result.add(i);
            i = prev[i];
        }
        return result;
    }

    public static void main (String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(2);
    }
    
}
